package GetAPIData;

import java.util.ArrayList;

import com.google.gson.Gson;

import DataObjects.CryptoInfo;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class CurrencyInfo {

	public static ArrayList<String> getCryptoInfo(String currency, String interval) {

		ArrayList<String> cryptoInfo = new ArrayList<String>();

		// ******** REMOVE API KEY before committing *****
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "8381f81057e8766c11cd0109bae84864").queryString("ids", currency).queryString("interval", interval).asString();

		String json = jsonStringResponse.getBody();

		JSONArray cryptoJson = new JSONArray(json);
		for (int idx = 0; idx < cryptoJson.length(); idx++) {
			JSONObject cryptoData = cryptoJson.getJSONObject(idx);
			cryptoInfo.add(cryptoData.toString());
		}
		
//		 for (int idx = 0; idx < cryptoInfo.size(); idx++) {
//				CryptoInfo data = new Gson().fromJson(.get(idx), CryptoInfo.class);
//				cryptoInfo.add(data);
//			}
//				

		for (String item : cryptoInfo) {
			System.out.println(item);
		}

		System.out.println("retrieved the data");

		return cryptoInfo;
	}
}