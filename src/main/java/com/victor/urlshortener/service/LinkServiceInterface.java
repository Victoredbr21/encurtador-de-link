package com.victor.urlshortener.service;

import com.victor.urlshortener.dto.LinkRequestDTO;
import com.victor.urlshortener.dto.LinkResponseDTO;

public interface LinkServiceInterface {
    LinkResponseDTO shorten(LinkRequestDTO dto);
}
