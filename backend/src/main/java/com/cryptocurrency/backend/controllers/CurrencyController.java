package com.cryptocurrency.backend.controllers;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
// import org.springframework.web.client.RestTemplate;

import com.cryptocurrency.backend.payload.nomics.api.GetCurrency;
import com.cryptocurrency.entity.objects.Cryptocurrency;

import kong.unirest.json.JSONArray;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CurrencyController {


//    @Autowired
//    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/currency/{q}")
    public ResponseEntity<List<Cryptocurrency>> cryptoHeader(@PathVariable String q) {
		String interval = "1d";
		GetCurrency gc=new GetCurrency();
		JSONArray json = gc.Currencies(q, interval,apiKey);
		List<Cryptocurrency> list=gc.Cryptocurrency(json);
		
        return ResponseEntity.ok(list);
    }


//    @GetMapping("/news/{q}")
//    public ResponseEntity<?> getNewsArticles(@PathVariable String q) {
//        String uri = "https://newsapi.org/v2/everything?sortBy=popularity&apiKey=" + apiKey + "&q=" + q;
//
//        NewsResponse response = restTemplate.getForObject(uri, NewsResponse.class);
//
//        return ResponseEntity.ok(response.getArticles());
//    }

}
