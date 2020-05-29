package GetAPIData;

// ********  REMOVE API KEY  before committing *****
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class CryptoData {

	public static void getCryptoData() {

		
		String oneJson="[{\"exchange\":\"coinbene\",\"market\":\"BETHER_ETH\",\"base\":\"BETHER\",\"quote\":\"ETH\"}";
		final   HttpResponse<String> jsonResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "")
				//.queryString("ids","BTC,ETH,XRP")
				//.queryString("interval","1d,30d")
				.asString();
		//String[] arrJson=stringJson.split("\\n");
		Gson gson = new Gson();
		//String json = gson.toJson(arrJson[0]);
		//System.out.println(arrJson[]);
		
	//	for(int idx=0; idx<arrJson.length; idx++) {
	//		PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
	//		potholeList.add(data);
	//	}
		//PotHole address=gsonBuild.fromJson(json, PotHole.class);
		
		//System.out.println(data.toString());
		
		 System.out.println(jsonResponse.getBody());
	}
}
