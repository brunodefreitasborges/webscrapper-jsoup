package com.forttiori.webscrappermercadolivre.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebScrapperControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Should return a String of a product price that was scraped")
    void scrape_ShouldReturnStringContainingTheAveragePrice_WhenSuccessful() throws Exception {
        // When
        MvcResult mvcResult = mockMvc.perform(get("/v1/webscrapper/{query}", "naruto"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();

        // Then
        Assertions.assertThat(json).isNotNull().isNotEmpty();
    }
}