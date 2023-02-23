package Admin;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdminLogin {

    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";

    private static AdminUser admin;

    public static Connection getAdminConnection() {

        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;
        } catch (Exception e) {
            System.out.println("AdminLogin class error:" + e);
        }
        return null;

    }

    // logs in as the employee

    public static boolean AdminLogin (String AdminFirstName, String AdminSurname, String AdminPassword, int EmployeeID ){
        try {
            String sql = "SELECT * FROM employee where EmployeeID = '" + EmployeeID + "'";




        }catch(Exception e){
            System.out.println("Admin login error: " + e);
        }

        return false;
    }







}
