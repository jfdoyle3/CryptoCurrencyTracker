package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.cryptocurrency.backend.entities.CryptocurrencyDailyPrice;
import com.cryptocurrency.backend.entities.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.CryptocurrencyInterval;
import com.cryptocurrency.backend.payload.api.GetCurrency;
import com.cryptocurrency.backend.payload.response.Cryptocurrency;
import com.cryptocurrency.backend.payload.response.CurrencyDailyPrice;
import com.cryptocurrency.backend.payload.response.CurrencyInterval;
import com.cryptocurrency.backend.repositories.CryptocurrencyDailyPriceRepository;
import com.cryptocurrency.backend.repositories.CryptocurrencyInfoRepository;
import com.cryptocurrency.backend.repositories.CryptocurrencyIntervalRepository;

import kong.unirest.json.JSONArray;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CurrencyController {
	private int methodRan=0;
	@Autowired
	private CryptocurrencyInfoRepository infoRepository;
	
	@Autowired
	private CryptocurrencyDailyPriceRepository priceRepository;
	
	@Autowired
	private CryptocurrencyIntervalRepository intervalRepository;

	
    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/currency/")
    public ResponseEntity<?> cryptoHeader(@RequestParam(defaultValue="") String currencies) {

    	methodRan++;
    	System.out.println("Ran: "+methodRan+"| C:"+currencies+"|"+"# of Records: "+infoRepository.numberOfEntries());
    	
    	// Check if records are on the table.
    	// need to check against ranking to update table with new values
    	if (currencies.equals("") && infoRepository.numberOfEntries()>1) {
    		List<CryptocurrencyInfo> getAll=infoRepository.findAll();
    		return ResponseEntity.ok(getAll);
    	}
    	
    	// Get Currency API and create a List
    	// CALL API
    	// JSONArray json=callAPI(currencies, apiKey);
    	String upperCurrencies=currencies.toUpperCase();
    	String interval = "1d";
		GetCurrency gc=new GetCurrency();
		JSONArray json = gc.Currencies(upperCurrencies, interval,apiKey);
		List<Cryptocurrency> currency=gc.Cryptocurrency(json);
		
		// Iterate thru currencies that the user inputs.
		// save to database through entity
		for(Cryptocurrency item : currency) {
			CryptocurrencyInfo ci=new CryptocurrencyInfo(
														 item.getCurrency_id(),
														 item.getCurrency(),
														 item.getSymbol(),
														 item.getName(),
														 item.getRanking(),
														 item.getLogoUrl()
														 );
			infoRepository.save(ci);
		}
        return ResponseEntity.ok(currency);
    }
    
    @GetMapping("/dailyPrice/{p}")
    public ResponseEntity<List<CurrencyDailyPrice>> cryptoDailyPrice(@PathVariable String p){
//    	// Find if the record exists
//    	if(priceRepository.numberOfEntries()>=1)
//    		return null;
    	
    	// Get Currency API and create a List
    	String upperCurrencies=p.toUpperCase();
    	String interval="1d";
    	GetCurrency gc=new GetCurrency();
    	JSONArray json = gc.Currencies(upperCurrencies, interval,apiKey);
    	List<CurrencyDailyPrice> prices=gc.CurrencyDailyPrice(json);
    	
    	
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
			priceRepository.save(dp);
		}
    	return ResponseEntity.ok(prices);
    }

    
    @GetMapping("/interval/{c}/{i}")
    public ResponseEntity<List<CurrencyInterval>> cryptoInterval(@PathVariable String c, @PathVariable String i){
    	
    	// Get Currency API and create a List
    	String upperCurrencies=c.toUpperCase();
    	GetCurrency gc=new GetCurrency();
    	JSONArray json = gc.Currencies(upperCurrencies, i,apiKey);
    	List<CurrencyInterval> interval=gc.CurrencyTimeInterval(json,i);
    	
    	
    	// Iterate thru currencies that the user inputs.
    	// save to database through entity
    	for(CurrencyInterval item : interval) {
    		CryptocurrencyInterval ci=new CryptocurrencyInterval(
    															 item.getTimeInterval(),
    															 item.getSymbol(),
    															 item.getVolume(),
    															 item.getPriceChange(),
    															 item.getPriceChangePct(),
    															 item.getVolumeChange(),
    															 item.getVolumeChangePct(),
    															 item.getMarketCapChange(),
    															 item.getMarketCapChangePct()
    															);
    		intervalRepository.save(ci);
    	}   	
    	return ResponseEntity.ok(interval);
    }
    
    
    @GetMapping("/currency/topfive")
    public ResponseEntity<List<CryptocurrencyInfo>> getTopFive(){
    	List<CryptocurrencyInfo> topFive=infoRepository.findTopFive();
    	return ResponseEntity.ok(topFive);
    }
    
    @GetMapping("/getDailyPrice/{p}")
    public ResponseEntity<List<CryptocurrencyDailyPrice>> getDailyPrice(@PathVariable String p){
    	String upperCurrencies=p.toUpperCase();
    	List<CryptocurrencyDailyPrice> price=priceRepository.findBySymbol(upperCurrencies);
    	return ResponseEntity.ok(price);
    }	
}
