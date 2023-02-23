package Admin;

import java.sql.*;
import java.util.Scanner;

public class AdminEntry {

    public static boolean [] AdminEntry (){

        boolean [] adminCheck = {false , false };
        try {
            boolean adminEntry = false;
            while (!adminEntry){
                for (int i = 0; i < 1; i++) {

                    Scanner input = new Scanner (System.in);
                    System.out.println("Please Enter your Employee ID ");
                    String ID = input.next();


                    System.out.println("please enter your password");
                    String password = input.next();
                    String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
                    Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
                    Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs1 = stmt1.executeQuery("SELECT * FROM employee WHERE (EmployeeID = ' " + ID + " ') AND (AdminPassword = ' " + password + "')");

                    while(rs1.next()){
                        ResultSetMetaData rsmd1 = rs1.getMetaData();
                        System.out.println("Admin login Successful ");
                        return adminCheck;




                }

                }
            }
            adminEntry = true;


        } catch (SQLException e) {
            System.out.println("error in the AdminEntry class: " + e);
            System.out.println("please try again");
        }


        return adminCheck;
    }





}

