package com.victor.urlshortener.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_url", nullable = false, length = 2048)
    private String originalUrl;

    @Column(name = "short_key", nullable = false, unique = true, length = 10)
    private String shortKey;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "click_count", nullable = false)
    private Long clickCount = 0L;



    //getters

    public Long getId() {
        return id;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getShortKey() {
        return shortKey;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
    // setters


    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }


    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }
}
