package Functions;

import java.sql.*;

public class SQL {

// retrieves info from database
   public static ResultSet executeQuery (Connection con, String query){
    try{
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(query);
        stmt.close();
        return rs;

    } catch (SQLException e) {
        System.out.println("SQL class error:" + e);

    } return null;

}

// info is added to database

   public static void executeUpdate (Connection con, String query){
       try{
           Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stmt.executeUpdate(query);
           stmt.close();


       } catch (SQLException e) {
           System.out.println("executeUpdate error" +e);
       }
   }




}
