package get_api_data;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;


import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class GetIntervals {

	public static void getCryptoIntervalData(String currency,String interval) {


		// ******** REMOVE API KEY before committing *****
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "").queryString("ids", currency).asString();
				

		String json = jsonStringResponse.getBody();
		JSONArray cryptoJson = new JSONArray(json);
		for (int idx = 0; idx < cryptoJson.length(); idx++) {
			JSONObject cryptoData = cryptoJson.getJSONObject(idx);
	//		cryptoRoot.add(cryptoData.toString());
			JSONObject oneDayObj = (JSONObject) cryptoData.get("1d");
	//		cryptOneDay.add(oneDayObj.toString());
		}
	//	System.out.println(cryptoRoot.get(0));
		
	
		
	//	for (int idx = 0; idx <= cryptoRoot.get(0).length(); idx++) {
	//		AllCrypto data = new Gson().fromJson(cryptoRoot.get(idx), AllCrypto.class);
	//		allCryptoRoot.add(data);
	//	}
		
//		for (int idx = 0; idx < cryptOneDay.size(); idx++) {
//			All1day data = new Gson().fromJson(cryptOneDay.get(idx), All1day.class);
//			allOneDay.add(data);
//		}

//		for(AllCrypto item : allCryptoRoot) {
//			System.out.println(item);
//		}
		// AllCrypto btc = allCryptoRoot.get(0);
		//System.out.println(btc.getHigh());

		System.out.println("end of line");
	}
}