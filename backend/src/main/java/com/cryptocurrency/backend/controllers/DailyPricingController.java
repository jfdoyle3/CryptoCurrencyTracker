package com.cryptocurrency.backend.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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

import kong.unirest.json.JSONArray;

@RestController
@CrossOrigin
@RequestMapping("/api/currency")
public class DailyPricingController {

	@Autowired
	private CryptocurrencyDailyPriceRepository repository;

	@Autowired
	UserService userService;

	@Value("${api.key}")
	private String apiKey;

	// GET MAPPING

	// Get Daily Price / Symbol from API
	@GetMapping("/altDailyPrice/{symbol}")
	public ResponseEntity<List<CurrencyDailyPrice>> cryptoCurrenctDailyPrice(@PathVariable String symbol)
			throws ParseException {
		// Setup
		String upperCurrencySymbol = symbol.toUpperCase();
		CryptocurrencyDailyPrice lastPrice = repository.findTopByOrderByIdDesc();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

		// Logic API or Database
		if (upperCurrencySymbol.equals(lastPrice.getSymbol())) {
			// TODO Console out: Symbols Match
			System.out.println("Symbols Match");

		} else {
			System.out.println("Last Symbol on the table is not " + upperCurrencySymbol);

		}

		// TODO Console out Daily Pricing Controller: Last Price
		System.out
				.println(">>==> Last Price: " + lastPrice.getSymbol() + " | " + lastPrice.getPriceTimeStamp() + " | ");

		// Start of Code to get data from API
		//
		String interval = "1d";
		GetCurrency gc = new GetCurrency();
		JSONArray json = gc.Currencies(upperCurrencySymbol, interval, apiKey);
		List<CurrencyDailyPrice> prices = gc.CurrencyDailyPrice(json);

		for (CurrencyDailyPrice item : prices) {
			CryptocurrencyDailyPrice dp = new CryptocurrencyDailyPrice(item.getSymbol(), item.getPrice(),
					item.getPriceDate(), item.getPriceTimeStamp(), item.getCirculatingSupply(), item.getMaxSupply(),
					item.getMarketCap(), item.getHigh(), item.getHighTimeStamp());
			repository.save(dp);
		}

		return ResponseEntity.ok(prices);
	}

	// Get Daily Price / Symbol from API
	@GetMapping("/dailyPrice/{symbol}")
	public ResponseEntity<List<CurrencyDailyPrice>> cryptoDailyPrice(@PathVariable String symbol)
			throws ParseException {
		String upperCurrencySymbol = symbol.toUpperCase();

		// Start of Code to get data from API
		//
		String interval = "1d";
		GetCurrency gc = new GetCurrency();
		JSONArray json = gc.Currencies(upperCurrencySymbol, interval, apiKey);

		// Temp fix for the double call to the API
		if (json.length() == 0) {
			System.out.println("JSON== 0 - IF STATEMENT RUNNING");
			List<CryptocurrencyDailyPrice> daily = getDailyPrice(symbol).getBody();
			List<CurrencyDailyPrice> currDailyPrice = new ArrayList<>();

			for (CryptocurrencyDailyPrice item : daily) {
				CurrencyDailyPrice dp = new CurrencyDailyPrice(item.getSymbol(), item.getPrice(), item.getPriceDate(),
						item.getPriceTimeStamp(), item.getCirculatingSupply(), item.getMaxSupply(), item.getMarketCap(),
						item.getHigh(), item.getHighTimeStamp());
				currDailyPrice.add(dp);
			}
			return ResponseEntity.ok(currDailyPrice);
		}

		List<CurrencyDailyPrice> prices = gc.CurrencyDailyPrice(json);

		for (CurrencyDailyPrice item : prices) {
			CryptocurrencyDailyPrice dp = new CryptocurrencyDailyPrice(item.getSymbol(), item.getPrice(),
					item.getPriceDate(), item.getPriceTimeStamp(), item.getCirculatingSupply(), item.getMaxSupply(),
					item.getMarketCap(), item.getHigh(), item.getHighTimeStamp());
			repository.save(dp);
		}

		return ResponseEntity.ok(prices);
	}

	// Get Daily Price from Table
	@GetMapping("/getDailyPrice/{symbol}")
	public ResponseEntity<List<CryptocurrencyDailyPrice>> getDailyPrice(@PathVariable String symbol) {
		String upperCurrencies = symbol.toUpperCase();
		List<CryptocurrencyDailyPrice> price = repository.findBySymbol(upperCurrencies);
		/*
		 * check if timestamp changed yes: API No: Database get json and get timestamp
		 * from api compare to database to determine if a api call is needed. need to
		 * regulate the calls to the API get latest price json obj:
		 * price.get(price.size()-1); call: cryptoDailyPrice(@PathVariable String
		 * symbol) to get a new record
		 * 
		 * System.out.println("price: <==>"+price.get(price.size()-1).getSymbol()+
		 * ">===<"+price.get(price.size()-1).getPriceTimeStamp());
		 * for(CryptocurrencyDailyPrice item : price)
		 * System.out.println("<==>"+item.getSymbol()+">===<"+item.getPriceTimeStamp());
		 * 
		 */

		return ResponseEntity.ok(price);
	}

	@GetMapping("/currentDailyPrice/{symbol}")
	public ResponseEntity<CryptocurrencyDailyPrice> getSingleDailyPrice(@PathVariable String symbol)
			throws ParseException {

		String upperCurrencySymbol = symbol.toUpperCase();
		CryptocurrencyDailyPrice lastPrice = repository.findTopByOrderByIdDesc();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		LocalDateTime now = LocalDateTime.now();
		String strNow = dtf.format(now).toString();
		DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//    	Date date = utcFormat.parse("2012-08-15T22:56:02Z");
//
//    	DateFormat pstFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//    	pstFormat.setTimeZone(TimeZone.getTimeZone("PST"));
//
//    	System.out.println(pstFormat.format(date));

		// Logic API or Database
		if (upperCurrencySymbol.equals(lastPrice.getSymbol())) {
			// TODO Console out: Symbols Match
			System.out.println("--> Symbols Match <--");
			System.out.println("Last Date:" + lastPrice.getPriceTimeStamp());

			// Date Stuff
			Date date = utcFormat.parse(lastPrice.getPriceTimeStamp());
			DateFormat estFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			estFormat.setTimeZone(TimeZone.getTimeZone("EST"));
			System.out.println("**** EST: " + estFormat.format(date));

		} else {
			System.out.println("-=-=-=> Last Symbol on the table is not " + upperCurrencySymbol);

		}

		// TODO Console out Daily Pricing Controller: Last Price
		System.out.println(">>==> Last Price: " + lastPrice.getSymbol() + " | " + lastPrice.getPriceTimeStamp());
		System.out.println("**** Now: " + strNow);
		System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		return ResponseEntity.ok(lastPrice);
	}

	@GetMapping("/testingTime/{symbol}")
	public ResponseEntity<CryptocurrencyDailyPrice> testingTime(@PathVariable String symbol) throws ParseException {

		// UpCase Symbol
		String upperCurrencySymbol = symbol.toUpperCase();
		CryptocurrencyDailyPrice lastPrice = repository.findTopByOrderByIdDesc();
		
		// Date Stuff
		
		// Date Formatter NOW
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		LocalDateTime now = LocalDateTime.now();
		String strNow = dtf.format(now).toString();
		
		// Date Format - UTC / EDT
		DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date date = utcFormat.parse(lastPrice.getPriceTimeStamp());
		DateFormat edtFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		edtFormat.setTimeZone(TimeZone.getTimeZone("EDT"));
		

		// TODO Console out Daily Pricing Controller: Last Price
		System.out.println("Last Date:" + lastPrice.getPriceTimeStamp());
		System.out.println("**** EDT: " + edtFormat.format(date));
		System.out.println("**** Now: " + strNow);
		System.out
				.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		return ResponseEntity.ok(lastPrice);
	}

}
