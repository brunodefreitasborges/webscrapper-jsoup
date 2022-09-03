package com.forttiori.webscrappermercadolivre.service;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WebScrapperService {


    public String startScrapping(String query) throws IOException {

        // Declaring the URL to be used in the searches
        String URL = "https://lista.mercadolivre.com.br/" + query;

        // Connecting to the URL and returning the HTML page
        Document document = Jsoup.connect(URL).get();

        // Extracting all the products from the page
        Elements elements = document.select("li.ui-search-layout__item");

        // Declare a List to store all the individual Product Prices
        List<Double> productPrices = new ArrayList<>();

        // Looping through all the individual elements and extracting its price
        for (Element e : elements) {

            String productPrice = Objects.requireNonNull(e.select("span.price-tag-amount").first()).text();
            Double price = Double.valueOf(productPrice.substring(2).replace(",", "."));
            productPrices.add(price);
        }

        // Calculating and returning the average price
        Double totalPrices = productPrices.stream().reduce(0.0, Double::sum);

        return String.format("%.2f", totalPrices / productPrices.size());
    }
}
