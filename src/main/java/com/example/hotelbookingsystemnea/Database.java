package com.example.hotelbookingsystemnea;

import java.sql.*;
import java.sql.Statement;
import java.io.IOException;

public class Database {


    public static void SQLTest() {

        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";


        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM employee";


            ResultSet rs1 = stmt.executeQuery(sql);

            while (rs1.next()) {
                System.out.println("EmployeeID : " + rs1.getString("First name") + "" + rs1.getString("surname") + "" + rs1.getString("password"));
            }
            rs1.close();
            con.close();


            }catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }


        }
    }





