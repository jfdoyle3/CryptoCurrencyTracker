package testhibernate;

import java.util.List;

import kong.unirest.json.JSONArray;

public class ListCurrencies {

	public static void main(String[] args) {
	
		JSONArray json = APIEntity.Currencies("", "1D");
		List<Cryptocurrency> list=APIEntity.CurrencyID(json);
		
		for (int idx=0; idx<5; idx++) {
			System.out.println(list.get(idx));
		}

	}

}
