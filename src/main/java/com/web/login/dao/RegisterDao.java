package com.web.login.dao;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class RegisterDao {
    Dotenv dotenv = Dotenv.load();
    String uname = dotenv.get("DB_USERNAME");
    String url = dotenv.get("DB_URL");
    String pass = dotenv.get("DB_PASSWORD");
    String query = "insert into login values (?,?)";
    public boolean register(String name, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,uname,pass);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,name);
        pst.setString(2,password);
        int rows = pst.executeUpdate();
        if(rows == 0)
            return false;
        return true;
    }
}
