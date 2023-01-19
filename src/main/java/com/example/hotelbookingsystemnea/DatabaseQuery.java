package com.example.hotelbookingsystemnea;

import java.sql.ResultSet;
import java.sql.*;

public class DatabaseQuery {

//information is pulled from the database

    public static ResultSet FetchFromTable (Connection con , String query){

        try{
          Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
          ResultSet rs1 = stmt1.executeQuery(query);
          stmt1.close();
          return rs1;
        } catch (SQLException e) {
            System.out.println("Error:" + e);
            return null;

        }
    }
    // information is added to the database (database is updated)
    public static void UpdateDatabase (Connection con, String query){
        try{
            Statement stmt1 = con.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt1.executeUpdate(query);
            stmt1.close();
        } catch (SQLException e) {
            System.out.println("Error updating database:" + e);
        }


    }





}
