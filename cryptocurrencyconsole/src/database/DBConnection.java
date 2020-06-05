package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnection {

	public static void connectDB() {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.201/cryptocurrencytracker",
					"jfdoyle3", "F1ipp3r6467");
			// fields id and currency
			String sql = "INSERT INTO cryptocurrencies (id) values (?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, "BTC");
			

			statement.executeUpdate();

			connection.close();
			System.out.println("table written!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
