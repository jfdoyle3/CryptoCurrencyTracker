package GetAPIData;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

import DataObjects.AllCrypto;
import DataObjects.btc;

// ******** REMOVE API KEY before committing *****

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class CryptoData {

	public static void getCryptoData() {

		ArrayList<String> cryptoRoot = new ArrayList<String>();
		ArrayList<btc> btcRoot = new ArrayList<btc>();
		ArrayList<String> cryptOneDay = new ArrayList<>();
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "").queryString("ids", "BTC,ETH,XRP")
				.queryString("interval", "1d").asString();

		String json = jsonStringResponse.getBody();
		JSONArray cryptoJson = new JSONArray(json);
		for (int idx = 0; idx < cryptoJson.length(); idx++) {
			JSONObject cryptoData = cryptoJson.getJSONObject(idx);
			cryptoRoot.add(cryptoData.toString());

			JSONObject oneDayObj = (JSONObject) cryptoData.get("1d");

			cryptOneDay.add(oneDayObj.toString());
		}

		for (String items : cryptOneDay) {
			System.out.println(items);
		}

		// System.out.println(cryptoData.toString());
		// cryptoJson.get("1d");
		// for (int idx2 = 0; idx2 < .length(); idx++)

		// Object volume = geoLocationObj.get("volume");
		// cryptoRoot.add(cryptoData.toString());
		// System.out.printf("volume: %s ", volume);

		// for(int idx=0; idx<cryptoRoot.size(); idx++) {
		// AllCrypto data = new Gson().fromJson(cryptoRoot.get(idx), AllCrypto.class);
		// potholeList.add(data);
		// }
		// AllCrypto address=gsonBuild.fromJson(json, AllCrypto.class);
		// System.out.println(data);
	}
}

//String[] arrJson=stringJson.split("\\n");
// Gson gson = new Gson();
// String json = gson.toJson(arrJson[0]);
// System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);//String[] arrJson=stringJson.split("\\n");
//Gson gson = new Gson();
//String json = gson.toJson(arrJson[0]);
//System.out.println(arrJson[]);
//for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}for(int idx=0; idx<arrJson.length; idx++) {
//	PotHole data = new Gson().fromJson(arrJson[idx], PotHole.class);
//	potholeList.add(data);
////	}
////PotHole address=gsonBuild.fromJson(json, PotHole.class);
//
////System.out.println(data.toString());
//
//// System.out.println(json);
//}

//JSONArray potholeJson = new JSONArray(json);
//for (int i = 0; i < potholeJson.length(); i++) {
//	JSONObject pothole = potholeJson.getJSONObject(i);
//	if (pothole.get("geolocation") != null) {
//		JSONObject geoLocationObj = (JSONObject) pothole.get("geolocation");
//		Object latitude = geoLocationObj.get("latitude");
//		Object longitude = geoLocationObj.get("longitude");
//		System.out.printf("Latitude: %s, Longitude: %s", latitude, longitude);
//	} else {
//		System.out.println("No geolocation")
//	}
//}		JSONArray potholeJson = new JSONArray(json);
//for (int i = 0; i < potholeJson.length(); i++) {
//	JSONObject pothole = potholeJson.getJSONObject(i);
//	if (pothole.get("geolocation") != null) {
//		JSONObject geoLocationObj = (JSONObject) pothole.get("geolocation");
//		Object latitude = geoLocationObj.get("latitude");
//		Object longitude = geoLocationObj.get("longitude");
//		System.out.printf("Latitude: %s, Longitude: %s", latitude, longitude);
//	} else {
//		System.out.println("No geolocation")
//	}
//}		JSONArray potholeJson = new JSONArray(json);
//for (int i = 0; i < potholeJson.length(); i++) {
//	JSONObject pothole = potholeJson.getJSONObject(i);
//	if (pothole.get("geolocation") != null) {
//		JSONObject geoLocationObj = (JSONObject) pothole.get("geolocation");
//		Object latitude = geoLocationObj.get("latitude");
//		Object longitude = geoLocationObj.get("longitude");
//		System.out.printf("Latitude: %s, Longitude: %s", latitude, longitude);
//	} else {
//		System.out.println("No geolocation")
//	}
//}		JSONArray potholeJson = new JSONArray(json);
//for (int i = 0; i < potholeJson.length(); i++) {
//	JSONObject pothole = potholeJson.getJSONObject(i);
//	if (pothole.get("geolocation") != null) {
//		JSONObject geoLocationObj = (JSONObject) pothole.get("geolocation");
//		Object latitude = geoLocationObj.get("latitude");
//		Object longitude = geoLocationObj.get("longitude");
//		System.out.printf("Latitude: %s, Longitude: %s", latitude, longitude);
//	} else {
//		System.out.println("No geolocation")
//	}
//}		JSONArray potholeJson = new JSONArray(json);
//for (int i = 0; i < potholeJson.length(); i++) {
//	JSONObject pothole = potholeJson.getJSONObject(i);
//	if (pothole.get("geolocation") != null) {
//		JSONObject geoLocationObj = (JSONObject) pothole.get("geolocation");
//		Object latitude = geoLocationObj.get("latitude");
//		Object longitude = geoLocationObj.get("longitude");
//		System.out.printf("Latitude: %s, Longitude: %s", latitude, longitude);
//	} else {
//		System.out.println("No geolocation")
//	}
//}		JSONArray potholeJson = new JSONArray(json);
//for (int i = 0; i < potholeJson.length(); i++) {
//	JSONObject pothole = potholeJson.getJSONObject(i);
//	if (pothole.get("geolocation") != null) {
//		JSONObject geoLocationObj = (JSONObject) pothole.get("geolocation");
//		Object latitude = geoLocationObj.get("latitude");
//		Object longitude = geoLocationObj.get("longitude");
//		System.out.printf("Latitude: %s, Longitude: %s", latitude, longitude);
//	} else {
//		System.out.println("No geolocation")
//	}
//}