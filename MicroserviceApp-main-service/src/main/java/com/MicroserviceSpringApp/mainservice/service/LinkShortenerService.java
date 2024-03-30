package com.MicroserviceSpringApp.mainservice.service;

import com.MicroserviceSpringApp.mainservice.db.model.ShortenedLink;
import com.MicroserviceSpringApp.mainservice.db.repository.ShortenedLinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkShortenerService {

    ShortenedLinkRepository shortenedLinkRepository;

    public Optional<ShortenedLink> getShortenedLinkByOriginalLink(String link){
        Optional<ShortenedLink> shortenedLink = shortenedLinkRepository.getShortenedLinkByOriginalLink(link);
    return shortenedLink;
    }

    public ShortenedLink getShortenedLink(String originalLink){
        Optional<ShortenedLink> shortenedLink = getShortenedLinkByOriginalLink(originalLink);
        if(shortenedLink.isPresent()){
            return shortenedLink.get();
        }else{
            return shortALink(originalLink);
        }
    }

    public ShortenedLink shortALink(String link){

            char[] linkCharArray = link.toCharArray();
            char[] revertedLinkCharArray = new char[linkCharArray.length];

            for(int x = linkCharArray.length; x!= 0; x--){
                revertedLinkCharArray[Math.abs( x - linkCharArray.length)] = linkCharArray[x];
            }

            ShortenedLink shortenedLink = new ShortenedLink(revertedLinkCharArray.toString(),link);
            shortenedLinkRepository.save(shortenedLink);

            return shortenedLink;
    }


    private encryptPassword(String password){
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
