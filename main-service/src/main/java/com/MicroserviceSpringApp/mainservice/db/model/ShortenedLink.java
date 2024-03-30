package com.MicroserviceSpringApp.mainservice.db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table
@Entity(name = "shortened_links")
public class ShortenedLink {

    public ShortenedLink() {

    }
    public ShortenedLink(String link,String originalLink){
        this.link = link;
        this.originalLink = originalLink;
    }

    @Id
    @GeneratedValue
    Long id;

    String link;

    String originalLink;



}


