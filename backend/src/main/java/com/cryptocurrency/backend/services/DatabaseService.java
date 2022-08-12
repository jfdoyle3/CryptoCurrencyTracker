package com.cryptocurrency.backend.services;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.cryptocurrency.backend.entities.auth.ERole;

@Service
public class DatabaseService {

    public boolean rolesExists() {
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/cryptocurrencytracker",
                    "username",
                    "password");

            System.out.println("Connection Open");

            Statement statement = connection.createStatement();

            String query = "select count(*) from role";

            ResultSet results = statement.executeQuery(query);
            results.next();

            count = results.getInt(1);

            if (connection != null) {
                System.out.println("Close");
                connection.close();
            }

        } catch (SQLException e) {
            System.out.println("SQL error!!!!");
            e.printStackTrace();
        }
        if (count > 0) {
            return true;
        }
        return false;
    }


    public void writeRoles() {

        int id = 0;

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/cryptocurrencytracker",
                    "username",
                    "password");


            String sql = "INSERT INTO role (id, name) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (ERole role : ERole.values()) {
                statement.setString(1, Integer.toString(++id));
                statement.setString(2, role.toString());
                statement.executeUpdate();

            }
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Detects Table Exists
    private void tableExists(String databaseName, String tableName) {

        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/cryptocurrencytracker",
                    "username",
                    "password");

            DatabaseMetaData dbm = connection.getMetaData();

            ResultSet rs = dbm.getTables(null, databaseName, tableName, null);

            if (rs.next())
                System.out.printf("Table %s exists in %s",tableName,databaseName);

            if (connection != null)
                connection.close();

        } catch(SQLException e){
            e.printStackTrace();
        }

    }
}
