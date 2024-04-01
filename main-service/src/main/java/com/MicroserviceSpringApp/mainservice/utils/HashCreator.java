package com.MicroserviceSpringApp.mainservice.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import static org.apache.tomcat.util.buf.ByteChunk.convertToBytes;

@Component
public class HashCreator {


//    todo rename
    public String generateStrongPasswordHash(final String password)
            throws NoSuchAlgorithmException,
            InvalidKeySpecException,
            NoSuchProviderException {
        int iterations = 1000;
        byte[] salt = createSalt();

        byte[] hash = createPBEHash(password, iterations, salt, 64);

        // prepend iterations and salt to the hash
        return iterations + ":"
                + convertToHex(salt) + ":"
                + convertToHex(hash);
    }

    //Create salt
    private byte[] createSalt()
            throws NoSuchAlgorithmException,
            NoSuchProviderException {

        //Always use a SecureRandom generator for random salt
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        //Create array for salt
        byte[] salt = new byte[16];

        //Get a random salt
        sr.nextBytes(salt);

        //return salt
        return salt;
    }

    //Create hash of password with salt, iterations, and keylength
    private byte[] createPBEHash(
            final String password,
            final int iterations,
            final byte[] salt,
            final int keyLength)
            throws NoSuchAlgorithmException,
            InvalidKeySpecException {

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),
                salt, iterations, keyLength * 8);

        SecretKeyFactory skf = SecretKeyFactory
                .getInstance("PBKDF2WithHmacSHA1");

        return skf.generateSecret(spec).getEncoded();
    }


    private boolean validatePassword(final String originalPassword,
                                     final String storedPasswordHash)
            throws NoSuchAlgorithmException,
            InvalidKeySpecException {

        // Split the string by :
        String[] parts = storedPasswordHash.split(":");

        // Extract iterations, salt, and hash
        // from the stored password hash
        int iterations = Integer.valueOf(parts[0]);
        byte[] salt = convertToBytes(parts[1]);
        byte[] hash = convertToBytes(parts[2]);

        byte[] originalPasswordHash = createPBEHash(
                originalPassword,
                iterations,
                salt,
                hash.length);

        int diff = hash.length ^ originalPasswordHash.length;
        for (int i = 0; i < hash.length
                && i < originalPasswordHash.length; i++) {

            diff |= hash[i] ^ originalPasswordHash[i];
        }

        return diff == 0;

    }

    private String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
            hexText = "0".concat(hexText);
        }
        return hexText;
    }

}
