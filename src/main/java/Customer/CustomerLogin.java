package Customer;

import Functions.HashPassword;
import Objects.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


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
            Connection con = getConnection();
            String sql = "UPDATE * FROM Customer where Email = '" + Email +  "SELECT * Customer where Password = '" + Password +"'";
            Statement stmt = con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);

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
            rs.close();
            assert con != null;
            con.close();

        } catch (Exception e) {
            System.out.println("customer Login error:" + e);

        }

        return false;
    }
}




