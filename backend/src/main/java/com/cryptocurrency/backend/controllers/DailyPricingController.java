package com.cryptocurrency.backend.controllers;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyDailyPrice;
import com.cryptocurrency.backend.payloads.api.GetCurrency;
import com.cryptocurrency.backend.payloads.response.cryptocurrency.CurrencyDailyPrice;
import com.cryptocurrency.backend.repositories.cryptocurrency.CryptocurrencyDailyPriceRepository;
import com.cryptocurrency.backend.services.UserService;
import com.cryptocurrency.backend.utils.CheckDateStamp;

import kong.unirest.json.JSONArray;

@RestController
@CrossOrigin
@RequestMapping("/api/currency")
public class DailyPricingController {
	
	private int methodRan=0;
	private int dailyRan=0;
	
	@Autowired
	private CryptocurrencyDailyPriceRepository repository;
	
	@Autowired
	UserService userService;
	
    @Value("${api.key}")
    private String apiKey;
    
    // GET MAPPING
    // Get Daily Price / Symbol from API
    @GetMapping("/dailyPrice/{symbol}")
    public ResponseEntity<List<CurrencyDailyPrice>> cryptoDailyPrice(@PathVariable String symbol) throws ParseException{
    	String upperCurrencySymbol=symbol.toUpperCase();
    	String interval="1d";
    	System.out.println(">>==> "+upperCurrencySymbol);
    	GetCurrency gc=new GetCurrency();
    	JSONArray json = gc.Currencies(upperCurrencySymbol, interval,apiKey);
    	List<CurrencyDailyPrice> prices=gc.CurrencyDailyPrice(json);
    	
    	// CheckDateStamp.displayDateStamp(prices);
    	
    	//Checking on dates
//    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");  
//    	   LocalDateTime now = LocalDateTime.now();  
//    	   
//    	System.out.println("====> TimeStamp: "+prices.get(0).getPriceTimeStamp());
//    	System.out.println("====> JAVAStamp: "+dtf.format(now).toString());
    	// Iterate thru currencies that the user inputs.
    	// save to database through entity
    	for(CurrencyDailyPrice item : prices) {
    		CryptocurrencyDailyPrice dp=new CryptocurrencyDailyPrice(
    																 item.getSymbol(),
    													 			 item.getPrice(),
    													 			 item.getPriceDate(),
    													 			 item.getPriceTimeStamp(),
    													 			 item.getCirculatingSupply(),
    													 			 item.getMaxSupply(),
    													 			 item.getMarketCap(),
    													 			 item.getHigh(),
    													 			 item.getHighTimeStamp()
    													 			 );
			repository.save(dp);
		}
    	dailyRan=1;
    	return ResponseEntity.ok(prices);
    }
    
    //Get Daily Price from Table
    @GetMapping("/getDailyPrice/{p}")
    public ResponseEntity<List<CryptocurrencyDailyPrice>> getDailyPrice(@PathVariable String p){
    	String upperCurrencies=p.toUpperCase();
    	List<CryptocurrencyDailyPrice> price=repository.findBySymbol(upperCurrencies);
    	return ResponseEntity.ok(price);
    }

}
