package com.example.hotelbookingsystemnea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class CustomerLogin {




    // customer login
    public static boolean CustomerLogin (String Email , String Password){

        try{
            String Database = "SELECT * FROM Customer where Email =  '" + Email + "'";
            Connection con = getConnection();
            ResultSet rs2 = SQL.exec
        }
    }
}
