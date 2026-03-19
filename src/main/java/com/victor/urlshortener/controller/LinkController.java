package com.victor.urlshortener.controller;

import com.victor.urlshortener.dto.LinkRequestDTO;
import com.victor.urlshortener.dto.LinkResponseDTO;
import com.victor.urlshortener.entity.Link;
import com.victor.urlshortener.repository.LinkRepository;
import com.victor.urlshortener.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    private LinkService linkService;
    @Autowired
    private LinkRepository linkRepository;

    // ─── POST ───────────────────────────────────────────────
    @PostMapping("/shorten")
    @Transactional
    public LinkResponseDTO shorten(@RequestBody LinkRequestDTO dto) {
        return linkService.shorten(dto);
    }

    // ─── GET ALL ─────────────────────────────────────────────
    @GetMapping("/{key}")
    public void redirect(@PathVariable String key, HttpServletResponse response) throws IOException {
        Optional<Link> linkOpt = linkRepository.findByShortKey(key);

        if (linkOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Link não encontrado!");
        }

        Link link = linkOpt.get();
        link.setClickCount(link.getClickCount() + 1);
        linkRepository.save(link);

        response.sendRedirect(link.getOriginalUrl());
    }


}