package com.MicroserviceSpringApp.mainservice.service;

import com.MicroserviceSpringApp.mainservice.db.model.ShortenedLink;
import com.MicroserviceSpringApp.mainservice.db.repository.ShortenedLinkRepository;
import com.MicroserviceSpringApp.mainservice.utils.HashCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Optional;

@Service
public class LinkShortenerService {

//    todo check if autowired is needed
    @Autowired
    HashCreator hashCreator;
    @Autowired
    ShortenedLinkRepository getShortenedLinkRepository;
    ShortenedLinkRepository shortenedLinkRepository;

    public Optional<ShortenedLink> getShortenedLinkByOriginalLink(String link) {
        return shortenedLinkRepository.getShortenedLinkByOriginalLink(link);
    }

    public ShortenedLink getShortenedLink(String originalLink) {
        Optional<ShortenedLink> shortenedLink = getShortenedLinkByOriginalLink(originalLink);
        return shortenedLink.orElseGet(() -> shortALink(originalLink));
    }

    public ShortenedLink shortALink(String link) {

        char[] linkCharArray = link.toCharArray();
        char[] revertedLinkCharArray = new char[linkCharArray.length];

        for (int x = linkCharArray.length; x != 0; x--) {
            revertedLinkCharArray[Math.abs(x - linkCharArray.length)] = linkCharArray[x];
        }

        ShortenedLink shortenedLink = new ShortenedLink(revertedLinkCharArray.toString(), link);
        shortenedLinkRepository.save(shortenedLink);

        return shortenedLink;
    }

//    todo:Hashing Algorithm
//    You can use a hashing algorithm such as MD5, SHA-256, or CRC32 to generate a hash value from
//    the long URL. The hash value can then be encoded using base62 or base64 encoding to create a short URL. This
//    approach provides a good balance between uniqueness and simplicity.

    //    todo rename
    private String shortenAnUrl(String url) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {

        String hash = hashCreator.generateStrongPasswordHash(url);
        String encodedString = Base64.getEncoder().encodeToString(hash.getBytes());

        ShortenedLink shortenedLink = new ShortenedLink();
        shortenedLink.setLink(encodedString);
        shortenedLink.setOriginalLink(url);

//        save in db
        getShortenedLinkRepository.save(shortenedLink);

//        test
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);

        return encodedString;
    }
}
