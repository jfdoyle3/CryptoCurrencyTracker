package get_api_data;

import java.util.ArrayList;

import com.google.gson.Gson;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import objects.CurrencyID;
import objects.CurrencyInfo;

public class GetCurrencyAllCode {

	public static void allCodeCurrencies(String currency) {

		ArrayList<CurrencyID> allCryptoRoot = new ArrayList<>();
		ArrayList<CurrencyInfo> allOneDay = new ArrayList<>();
		ArrayList<String> cryptOneDay = new ArrayList<>();
		
		// ******** REMOVE API KEY before committing *****

		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "").queryString("ids", currency).queryString("interval", "1d").asString();

		String json = jsonStringResponse.getBody();
		System.out.println("ALL: "+json);
		
		JSONArray cryptoJson = new JSONArray(json);
//		for (int idx = 0; idx < cryptoJson.length(); idx++) {
			JSONObject cryptoData = cryptoJson.getJSONObject(0);
		//	System.out.println(cryptoData);
//	//	allCryptoRoot.add(cryptoData.toString());
	JSONObject label = (JSONObject) cryptoData.get("logo_url");
//			cryptOneDay.add(oneDayObj.toString());
//		}
		System.out.println(label.toString());
//		
//		CaseLog currentCase = new Gson().fromJson(caseJson.getJSONObject(i).toString(), CaseLog.class);
//		
////		for (int idx = 0; idx <= allCryptoRoot.get(0).length(); idx++) {
//		CurrencyID data = new Gson().fromJson(allCryptoRoot.get(0), CurrencyID.class);
////			allCryptoRoot.add(data);
////		}
//		System.out.println(data);
////		for (int idx = 0; idx < cryptOneDay.size(); idx++) {
////			All1day data = new Gson().fromJson(cryptOneDay.get(idx), All1day.class);
////			allOneDay.add(data);
////		}
//
//	//	for(AllCrypto item : allCryptoRoot) {
////			System.out.println(item);
//	//	}
//		// AllCrypto btc = allCryptoRoot.get(0);
//		//System.out.println(btc.getHigh());

		
		
		
		System.out.println("end of line");
	}
}