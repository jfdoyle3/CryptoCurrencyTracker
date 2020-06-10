package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class writeInfo {
	public static void currencyIfo() {
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.201/cryptocurrencytracker",
					"jfdoyle3", "F1ipp3r6467");
			
			
			
		
				connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
