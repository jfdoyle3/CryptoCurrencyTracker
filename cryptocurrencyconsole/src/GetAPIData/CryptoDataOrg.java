package GetAPIData;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

import DataObjects.CryptoInfo;
import DataObjects.CryptoIntervals;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class CryptoDataOrg {

	public static void getCryptoData() {

		ArrayList<String> cryptoInfo = new ArrayList<>();
		ArrayList<CryptoInfo> allCryptoRoot = new ArrayList<>();
		ArrayList<CryptoIntervals> cryptoInterval = new ArrayList<>();
		ArrayList<String> cryptOneDay = new ArrayList<>();
		
		// ******** REMOVE API KEY before committing *****
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "8381f81057e8766c11cd0109bae84864").queryString("ids", "BTC")
				.queryString("interval", "1d").asString();

		String json = jsonStringResponse.getBody();
		System.out.println(json);
		JSONArray cryptoJson = new JSONArray(json);
		
		for (int idx = 0; idx < cryptoJson.length(); idx++) {
			JSONObject cryptoData = cryptoJson.getJSONObject(idx);
			cryptoInfo.add(cryptoData.toString());
		//	JSONObject oneDayObj = (JSONObject) cryptoData.get("1d");
		//	cryptOneDay.add(oneDayObj.toString());
		}
		
	//	System.out.println(cryptoInfo.get(0));
		
		
		for (int idx = 0; idx < cryptoInfo.size(); idx++) {
			CryptoInfo data = new Gson().fromJson(cryptoInfo.get(idx), CryptoInfo.class);
			allCryptoRoot.add(data);
		}
		
//		for (int idx = 0; idx < cryptOneDay.size(); idx++) {
//			cryptoInterval data = new Gson().fromJson(cryptOneDay.get(idx), All1day.class);
//			allOneDay.add(data);
//		}

		for(CryptoInfo item : allCryptoRoot) {
			System.out.println(item.getId());
	}
		// AllCrypto btc = allCryptoRoot.get(0);
		//System.out.println(btc.getHigh());

		System.out.println("end of line");
	}
}