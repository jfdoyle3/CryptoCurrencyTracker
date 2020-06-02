package GetAPIData;

import java.util.ArrayList;

import com.google.gson.Gson; 
import DataObjects.CryptoInfo;

public class Main {

	public static void main(String[] args) {

	// ArrayList<CryptoInfo> cryptoInfo=new ArrayList<CryptoInfo>();
	// ArrayList<String> allData=CryptoInfoOrg.("BTC","");
		CryptoDataOrg.getCryptoData();
//		for (String item : allData) {
//			System.out.println(item);
//		}

	 
	 
//	 for (int idx = 0; idx < cryptoInfo.size(); idx++) {
//		CryptoInfo data = new Gson().fromJson(allData.get(idx), CryptoInfo.class);
//		cryptoInfo.add(data);
//	}
		
		
	
 	 
	//	WriteJSONfile.writeFile(allData);
	//	CryptoMarket.getCryptoMarket();
	 
	 System.out.println("end of line");
	}
}
