package GetAPIData;

import java.util.ArrayList;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class CryptoMarket {

	public static void getCryptoMarket() {

		ArrayList<String> allCryptoData = new ArrayList<String>();
		
		// ******** REMOVE API KEY before committing *****
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/markets")
				.queryString("key", "").asString();

		String json = jsonStringResponse.getBody();
		System.out.println(json);
}

}