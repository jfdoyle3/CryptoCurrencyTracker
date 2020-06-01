package GetAPIData;

import java.util.ArrayList;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class CryptoData {

	public static ArrayList<String> getCryptoData(String currency, String interval) {

		ArrayList<String> allCryptoData = new ArrayList<String>();
		
		// ******** REMOVE API KEY before committing *****
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "").queryString("ids", currency)
		        .queryString("interval", interval).asString();

		String json = jsonStringResponse.getBody();

		JSONArray cryptoJson = new JSONArray(json);
		for (int idx = 0; idx < cryptoJson.length(); idx++) {
			JSONObject cryptoData = cryptoJson.getJSONObject(idx);
			allCryptoData.add(cryptoData.toString());
		}
		
		for(String item : allCryptoData) {
		System.out.println(item);
		}

		System.out.println("retrieved the data");

		return allCryptoData;
}

}