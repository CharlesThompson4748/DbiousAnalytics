package com.example.analytics.dbious.busyfit;

import java.sql.*;

import javax.xml.transform.Result;

public class RemoteDatabaseHandler {
    ResultSet results;

    RemoteDatabaseHandler() {}
    RemoteDatabaseHandler(String table)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:8889/LazyFit", "root", "root");
            android.util.Log.d("Success!", "Connected to the DB");
            try
            {
                String sqlStmt = "select * from BusyFit_User;";
                PreparedStatement query = connection.prepareStatement(sqlStmt);

                results = query.executeQuery();
                connection.close();

                android.util.Log.d("Result: ","Successfully connected and executed query!");
            }
            catch (SQLException s)
            {
                android.util.Log.d("Error!","Unable to execute query");
            }
        }
        catch (SQLException s)
        {
            android.util.Log.d("Error!", "Failed to get connection to DB"+s.getMessage());
        }
    }
    public ResultSet getResult()
    {
        return results;
    }
}
