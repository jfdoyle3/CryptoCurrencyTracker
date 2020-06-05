package get_api_data;

import java.util.ArrayList;

import com.google.gson.Gson;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import objects.CurrencyID;
import objects.CurrencyInfo;

public class GetCurrency {

	public static void Currencies(String currency) {

		// ******** REMOVE API KEY before committing *****

		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "").queryString("ids", currency)
				.queryString("interval", "1d").asString();

		String json = jsonStringResponse.getBody();

		JSONArray currencyJson = new JSONArray(json);
		JSONObject currencyData0 = currencyJson.getJSONObject(0);
	//	JSONObject currencyData1 = currencyJson.getJSONObject(1);

		  JSONObject jo = (JSONObject) currencyData0; 
          
	        String logoUrl = (String) jo.get("logo_url"); 
	     
	          
	        System.out.println(logoUrl); 
	        
	        

		
	//	System.out.printf("0: %s\n",currencyData0.toString());
	//	System.out.printf("1: %s",currencyData1.toString());
		System.out.println("\nend of line");
	}
}