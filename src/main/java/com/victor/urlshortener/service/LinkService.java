package com.victor.urlshortener.service;

import com.victor.urlshortener.dto.LinkRequestDTO;
import com.victor.urlshortener.dto.LinkResponseDTO;
import com.victor.urlshortener.entity.Link;
import com.victor.urlshortener.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LinkService implements LinkServiceInterface {

    @Autowired
    private LinkRepository linkRepository;


        public LinkResponseDTO shorten(LinkRequestDTO dto) {

            Link link = new Link();

            link.setOriginalUrl(dto.getOriginalUrl());


            String shortKey;
            do {
                shortKey = UUID.randomUUID().toString().substring(0, 8);
            } while (linkRepository.existsByShortKey(shortKey));

            link.setShortKey(shortKey);
            linkRepository.save(link);
            String shortUrl = "http://localhost:8080/api/" + shortKey;
            return new LinkResponseDTO(shortUrl);
        }

    }

