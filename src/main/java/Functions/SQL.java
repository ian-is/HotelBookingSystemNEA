package Functions;

import Objects.User;

import java.sql.*;
import java.util.ArrayList;

public class SQL {

// retrieves info from database
   public static ResultSet executeQuery (Connection con, String query) {
       try {
           Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           ResultSet rs = stmt.executeQuery(query);
           stmt.close();
           return rs;

       } catch (SQLException e) {
           System.out.println("executeQuery SQL class error :" + e);
           return null;
       }


   }

// info is added to database

   public static void executeUpdate (Connection con, String query){
       try{
           Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stmt.executeUpdate(query);
           stmt.close();


       } catch (SQLException e) {
           System.out.println("executeUpdate error:" +e);
       }
   }

   // searches the databse for customer details
   public static ArrayList <User> SearchDatabase (String sql){
       boolean search = true;
       ArrayList <User> output = new ArrayList<>();
       String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
       try{
           Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
           Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           ResultSet rsSearch = stmt.executeQuery(sql);
           ResultSetMetaData rsmdSearch = rsSearch.getMetaData();
           int columns = rsmdSearch.getColumnCount();
           rsSearch.last();
           int columnRow = rsSearch.getRow();
           rsSearch.beforeFirst();


           while (rsSearch.next()){
               for (int i = 0; i < columnRow; i++) {
                   User customer = new User(rsSearch.getInt(1), rsSearch.getString(2),rsSearch.getString(3),rsSearch.getString(4)
                   ,rsSearch.getString(5), rsSearch.getString(6));
                   output.add(customer);
                   rsSearch.next();

               }
           }

           con.close();

       } catch (SQLException e) {
           System.out.println("error in search database class");

       }return output;


   }




}
