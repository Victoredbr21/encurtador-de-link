package com.victor.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public class LinkRequestDTO {
    @NotBlank
    @URL
   private String originalUrl;

    public LinkRequestDTO() {}

    public LinkRequestDTO(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public @NotBlank @NotNull String getOriginalUrl() {
        return originalUrl;
    }
}
