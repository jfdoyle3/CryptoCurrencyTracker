package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.cryptocurrency.backend.entity.objects.CryptocurrencyDailyPrice;
import com.cryptocurrency.backend.entity.objects.CryptocurrencyInfo;
import com.cryptocurrency.backend.entity.objects.CryptocurrencyInterval;
import com.cryptocurrency.backend.payload.api.GetCurrency;
import com.cryptocurrency.backend.payload.response.Cryptocurrency;
import com.cryptocurrency.backend.payload.response.CurrencyDailyPrice;
import com.cryptocurrency.backend.payload.response.CurrencyInterval;
import com.cryptocurrency.backend.repository.CryptocurrencyDailyPriceRepository;
import com.cryptocurrency.backend.repository.CryptocurrencyInfoRepository;
import com.cryptocurrency.backend.repository.CryptocurrencyIntervalRepository;

import kong.unirest.json.JSONArray;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CurrencyController {

	@Autowired
	private CryptocurrencyInfoRepository infoRepository;
	
	@Autowired
	private CryptocurrencyDailyPriceRepository priceRepository;
	
	@Autowired
	private CryptocurrencyIntervalRepository intervalRepository;

	
    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/currency/")
    public ResponseEntity<List<Cryptocurrency>> cryptoHeader(@RequestParam(defaultValue="") String currencies) {
    	String upperCurrencies=currencies.toUpperCase();
    	String interval = "1d";
		GetCurrency gc=new GetCurrency();
		JSONArray json = gc.Currencies(upperCurrencies, interval,apiKey);
		List<Cryptocurrency> currency=gc.Cryptocurrency(json);
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
    	String interval="1d";
    	GetCurrency gc=new GetCurrency();
    	JSONArray json = gc.Currencies(p, interval,apiKey);
    	List<CurrencyDailyPrice> prices=gc.CurrencyDailyPrice(json);
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
    	GetCurrency gc=new GetCurrency();
    	JSONArray json = gc.Currencies(c, i,apiKey);
    	List<CurrencyInterval> interval=gc.CurrencyTimeInterval(json,i);
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
}
