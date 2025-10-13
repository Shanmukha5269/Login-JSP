package com.web.login.dao;

import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class LoginDao {
    Dotenv dotenv = Dotenv.load();
    String uname = dotenv.get("DB_USERNAME");
    String url = dotenv.get("DB_URL");
    String pass = dotenv.get("DB_PASSWORD");
    String query = "select * from login where name=? and password=?";
    public boolean check(String name, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,uname,pass);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,name);
        pst.setString(2,password);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            return true;
        }
        return false;
    }
}
