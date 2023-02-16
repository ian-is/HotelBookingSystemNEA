package Customer;

import Functions.HashPassword;
import Functions.SQL;
import Objects.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class CustomerLogin {


    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
    private static User Customer;

    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;
        } catch (Exception e) {
            System.out.println("CustomerLogin class error:" + e);
        }
        return null;

    }

    // customer login
    public static boolean customerLogin(String Email, String Password) {
        try {
            String sql = "SELECT from Customer where Email = '" + Email + "'";
            Connection con = getConnection();
            ResultSet rs = SQL.executeQuery(con, sql);

            if (rs.next()) {
                Customer = new User(rs.getInt("CustomerID"),
                        rs.getString("FirstName"),
                        rs.getString("Surname"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Email"),
                        rs.getString("Password"));
                rs.close();
                assert con != null;
                con.close();


                if (HashPassword.PasswordCompare(Customer.getPassword(), Email, Password)) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println("customer Login error:" + e);

        }

        return false;
    }
}




