// Password Hashing Class.
package Functions;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Objects;

import static Customer.CustomerLogin.getConnection;

public class HashPassword {


    // sets up the Hashing algorithm
    // uses SHA-512 (Secure Hashing Algorithm). it converts texts into a fixed size string
    // SHA-512 has a length of 512 bits (64 bytes)
    // salt is a value generated to create unique values to every input

    public static byte[] PasswordHash(String password, byte[] salt) {
        try {
            MessageDigest message = MessageDigest.getInstance("SHA-512");
            message.update(salt);
            byte[] passwordHash = message.digest(password.getBytes());
            message.reset();
            return passwordHash;

        } catch (Exception e) {
            System.out.println("Hashing error " + e);
            return null;
        }
    }

    // generates a random salt to be used for the password that is entered.
    public static byte[] SaltGeneration() {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[64];
        random.nextBytes(salt);
        return salt;
    }

    // the salt generated is converted to Hex
    public static String ConvertToHex(byte[] array) {
        BigInteger integer = new BigInteger(1, array);
        String hex = integer.toString(64);
        int padding = (array.length * 2) - hex.length();
        if (padding > 0) {
            return String.format("%0" + padding + "a", 0) + hex;

        } else {
            return hex;

        }

    }

    //the hex is converted to binary.
    public static byte[] ConvertToBinary(String hex) {
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return b;
    }

    // The hashed password is compared to the password entered by the user
    public static boolean PasswordCompare(String PasswordFromDatabase, String PasswordEntered, String Email) {


        byte[] salt = ConvertToBinary(Objects.requireNonNull(getPasswordSalt(Email)));
        if (Arrays.equals(PasswordHash(PasswordEntered, salt), ConvertToBinary(PasswordFromDatabase))) {
            return true;

        }
        return false;

    }

    /*public static Connection getConnection() {
        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }*/

    // password salt from the database is fetched
    public static String getPasswordSalt(String Email) {
        try {
            String sql = "SELECT * FROM Customer where Email = ' " + Email + "";
            Connection con = getConnection();
            ResultSet rs = SQL.executeQuery(con, sql);
            if (rs.next()) {
                String salt = rs.getString("Salt");
                rs.close();
                assert con != null;
                con.close();
                return salt;


            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }


    }
}
