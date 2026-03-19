package com.victor.urlshortener.controller;

import com.victor.urlshortener.dto.LinkRequestDTO;
import com.victor.urlshortener.dto.LinkResponseDTO;
import com.victor.urlshortener.service.LinkService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/shorten")
    @Transactional
    public LinkResponseDTO shorten(@RequestBody LinkRequestDTO dto) {
        return linkService.shorten(dto);
    }
}