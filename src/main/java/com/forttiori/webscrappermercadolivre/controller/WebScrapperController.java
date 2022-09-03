package com.forttiori.webscrappermercadolivre.controller;

import com.forttiori.webscrappermercadolivre.service.WebScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("v1/webscrapper")
@RequiredArgsConstructor
public class WebScrapperController {

    private final WebScrapperService webScrapperService;

    @GetMapping("/{query}")
    public String scrape(@PathVariable String query) throws IOException {
        return webScrapperService.startScrapping(query);
    }

}
