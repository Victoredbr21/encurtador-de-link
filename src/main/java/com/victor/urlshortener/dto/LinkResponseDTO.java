package com.victor.urlshortener.dto;


public class LinkResponseDTO {

    private String shortUrl;

    public LinkResponseDTO() {}

    public LinkResponseDTO(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public  String getShortUrl() {
        return shortUrl;
    }
}