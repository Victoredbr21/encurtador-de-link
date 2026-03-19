package com.victor.urlshortener.repository;

import com.victor.urlshortener.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link,Long> {
    Optional<Link> findByShortKey  (String shortKey);
    boolean  existsByShortKey  (String shortKey);
}
