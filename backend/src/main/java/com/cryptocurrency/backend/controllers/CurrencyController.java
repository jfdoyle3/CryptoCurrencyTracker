package com.cryptocurrency.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.entities.auth.User;
import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyDailyPrice;
import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInterval;
import com.cryptocurrency.backend.entities.rating.Rating;
import com.cryptocurrency.backend.entities.tracker.Tracker;
import com.cryptocurrency.backend.payloads.api.GetCurrency;
import com.cryptocurrency.backend.payloads.request.SetRating;
import com.cryptocurrency.backend.payloads.response.cryptocurrency.Cryptocurrency;
import com.cryptocurrency.backend.payloads.response.cryptocurrency.CurrencyDailyPrice;
import com.cryptocurrency.backend.payloads.response.cryptocurrency.CurrencyInterval;
import com.cryptocurrency.backend.repositories.cryptocurrency.CryptocurrencyDailyPriceRepository;
import com.cryptocurrency.backend.repositories.cryptocurrency.CryptocurrencyInfoRepository;
import com.cryptocurrency.backend.repositories.cryptocurrency.CryptocurrencyIntervalRepository;
import com.cryptocurrency.backend.repositories.rating.RatingRepository;
import com.cryptocurrency.backend.repositories.tracker.TrackerRepository;
import com.cryptocurrency.backend.services.UserService;

import kong.unirest.json.JSONArray;

@RestController
@CrossOrigin
@RequestMapping("/api/currency")
public class CurrencyController {
	private int methodRan=0;
	@Autowired
	private CryptocurrencyInfoRepository infoRepository;
	
	@Autowired
	private CryptocurrencyDailyPriceRepository priceRepository;
	
	@Autowired
	private CryptocurrencyIntervalRepository intervalRepository;
	
	@Autowired
	private TrackerRepository trackerRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	UserService userService;
	
    @Value("${api.key}")
    private String apiKey;
    
    
    
    // GET MAPPINGS:
    // Currencies:  Empty- Get the first 100 currencies
    // 				Typing a List of currency will get those only.
    @GetMapping
    public ResponseEntity<?> cryptoHeader(@RequestParam(defaultValue="") String currencies) {

    	methodRan++;
    	// TODO Console: Curr CTRL: Ran: "+methodRan+"| C:"+currencies+"|"+"# of Records: "+infoRepository.numberOfEntries()
    	System.out.println("Curr CTRL: Ran: "+methodRan+"| C:"+currencies+"|"+"# of Records: "+infoRepository.numberOfEntries());
    	
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
														 item.getSymbol(),
														 item.getName(),
														 item.getRanking(),
														 item.getLogoUrl()
														 );
			infoRepository.save(ci);
		}
        return ResponseEntity.ok(currency);
    }
    
    
 

    // Currency Interval - Symbol - time (1d, 7d, 1y)
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
    
    
    // Get the Top Five currencies
    @GetMapping("/topfive")
    public ResponseEntity<List<CryptocurrencyInfo>> getTopFive(){
    	List<CryptocurrencyInfo> topFive=infoRepository.findTopFive();
    	return ResponseEntity.ok(topFive);
    }
}
