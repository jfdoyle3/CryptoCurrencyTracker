package GetAPIData;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

import DataObjects.CryptoInfo;
import DataObjects.CryptoIntervals;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class CryptoIntervalData {

	public static void getCryptoIntervalData(String currency,String interval) {

		ArrayList<String> cryptoRoot = new ArrayList<String>();
		ArrayList<CryptoInfo> allCryptoRoot = new ArrayList<>();
		ArrayList<CryptoIntervals> allOneDay = new ArrayList<>();
		ArrayList<String> cryptOneDay = new ArrayList<>();
		// ******** REMOVE API KEY before committing *****
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "").queryString("ids", currency).asString();
				

		String json = jsonStringResponse.getBody();
		JSONArray cryptoJson = new JSONArray(json);
		for (int idx = 0; idx < cryptoJson.length(); idx++) {
			JSONObject cryptoData = cryptoJson.getJSONObject(idx);
			cryptoRoot.add(cryptoData.toString());
			JSONObject oneDayObj = (JSONObject) cryptoData.get("1d");
			cryptOneDay.add(oneDayObj.toString());
		}
		System.out.println(cryptoRoot.get(0));
		
		Iterator<String>  btcItr=cryptoRoot.iterator();
		
		for (int idx = 0; idx <= cryptoRoot.get(0).length(); idx++) {
			CryptoInfo data = new Gson().fromJson(cryptoRoot.get(idx), CryptoInfo.class);
			allCryptoRoot.add(data);
		}
		
//		for (int idx = 0; idx < cryptOneDay.size(); idx++) {
//			All1day data = new Gson().fromJson(cryptOneDay.get(idx), All1day.class);
//			allOneDay.add(data);
//		}

		for(CryptoInfo item : allCryptoRoot) {
			System.out.println(item);
		}
		// AllCrypto btc = allCryptoRoot.get(0);
		//System.out.println(btc.getHigh());

		System.out.println("end of line");
	}
}