package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class writeIntervals {

	public static void dbIntervals() {
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.201/financialscraper",
					"jfdoyle3", "F1ipp3r6467");

		
				connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
