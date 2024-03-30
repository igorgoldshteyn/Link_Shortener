package com.MicroserviceSpringApp.mainservice.db.repository;

import com.MicroserviceSpringApp.mainservice.db.model.ShortenedLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenedLinkRepository extends JpaRepository<ShortenedLink, Long> {
@Query(nativeQuery = true,
value = "SELECT * FROM shortened_links WHERE original_link = :originalLink")
Optional<ShortenedLink> getShortenedLinkByOriginalLink(String originalLink);
}
