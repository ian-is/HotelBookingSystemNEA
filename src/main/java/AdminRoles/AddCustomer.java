package AdminRoles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


// THIS CLASS IS FOR GETTING THE CONNECTION TO THE DATABASE AND FOR ADMIN TO BE ABLE TO ADD CUSTOMER TO THE DATABASE.
public class AddCustomer {

    // GETS A CONNECTION TO THE DATABASE
    public static void ToDatabase (String sql){

        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
        try{
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            Statement stmts = con.createStatement();
            stmts.execute(sql);
            con.close();

        } catch (SQLException e) {
            System.out.println("error in AddCustomer class (ToDatabase method): " + e);

        }

       //public static void AddCustomer (String FirstName, )


    }







}
