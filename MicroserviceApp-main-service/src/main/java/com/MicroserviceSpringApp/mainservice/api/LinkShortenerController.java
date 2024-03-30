package com.MicroserviceSpringApp.mainservice.api;

import com.MicroserviceSpringApp.mainservice.MainServiceApplication;
import com.MicroserviceSpringApp.mainservice.db.model.ShortenedLink;
import com.MicroserviceSpringApp.mainservice.service.LinkShortenerService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkShortenerController {

    @Autowired
    LinkShortenerService linkShortenerService;
    private static final Logger logger = LogManager.getLogger(MainServiceApplication.class);

    @GetMapping("/getShortenedLink/{link}")
    @Operation(summary = "Get shortened link from a link")
public ShortenedLink getShortenedLink(@PathVariable("link") String link){
        logger.info("GET REQUEST: /getShortenedLink/" + link);
         return linkShortenerService.getShortenedLink(link);
    }
}
