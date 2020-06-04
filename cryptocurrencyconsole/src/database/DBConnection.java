package database;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.sql.Timestamp;
	import java.util.ArrayList;
	
public class DBConnection {

		public static void connectDB() {

			try {

				Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.201/financialscraper",
						"jfdoyle3", "F1ipp3r6467");

//				String sql = "INSERT INTO stocktable (datestamp, symbol, lastprice,pricechange,changepercentage,markettime,volume,avgvol,marketcap) values (?,?,?,?,?,?,?,?,?)";
//				PreparedStatement statement = connection.prepareStatement(sql);
//
//				for (int idx = 0; idx < stockList.size(); idx++) {
//					Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//					statement.setTimestamp(1, timeStamp);
//					statement.setString(2, stockList.get(idx).symbol);
//					statement.setString(3, stockList.get(idx).lastprice);
//					statement.setString(4, stockList.get(idx).pricechange);
//					statement.setString(5, stockList.get(idx).changepercentage);
//					statement.setString(6, stockList.get(idx).markettime);
//					statement.setString(7, stockList.get(idx).volume);
//					statement.setString(8, stockList.get(idx).avgvol);
//					statement.setString(9, stockList.get(idx).marketcap);
//
//					statement.executeUpdate();

					System.out.println("connection works!!");
					connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

