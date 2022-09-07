package com.example.hotelbookingsystemnea;
// currently this database class is made to retrieve data from the tables within the database
//each method is a separate table from the database, to be able to individually access or view the data within it
import java.sql.*;
import java.sql.Statement;
import java.io.IOException;

public class Database {


    public static void employeeTbl() {

        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";

        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM employee";
            ResultSet rs1 = stmt.executeQuery(sql);
            System.out.println("Employee Table:");
            while (rs1.next()) {

                System.out.println("EmployeeID:" + " " + rs1.getInt(1) + " " + "|First Name:" + " " + rs1.getString("First name") + " " + "|Surname:" + " " + rs1.getString("surname") + " " + "|Password:" + " " + rs1.getString("password"));
            }

            rs1.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error in the SQL class:" + e);
        }

    }

    public static void customerTbl() {
        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM Customer";
            ResultSet rs2 = stmt2.executeQuery(sql);
            System.out.println("Customer Table: ");
            while (rs2.next()) {                                                                                                                                                                                           //DOB format is inverted as to the format on the database
                System.out.println("CustomerID:" + " " + rs2.getInt(1) + " " + "|First Name:" + " " + rs2.getString("First Name") + " " + "|Surname:" + " " + rs2.getString("Surname") + " " + "|DOB (Y/D/M):" + " " + rs2.getDate("Date of Birth") + " " + "|Email:" + " " + rs2.getString("Email") + " " + "|Password:" + " " + rs2.getString("Password"));
            }
            rs2.close();
            con.close();

        } catch (Exception e) {
            System.out.println("error in the the customer table");
        }
    }

    public static void bookingTbl() {
        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            Statement stmt3 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM Booking";
            ResultSet rs3 = stmt3.executeQuery(sql);
            System.out.println("Booking Table: ");
            while (rs3.next()) {
                System.out.println("BookingID:" + " " + rs3.getInt(1) + " " + "|CustomerID:" + " " + rs3.getInt(2) + " " + "|Check in Date:" + " " + rs3.getDate("Check in Date") + " " + "|Check out date:" + " " + rs3.getDate("Check out Date") + " " + "|Paid:" + " " + rs3.getString("Paid"));
            }
            rs3.close();
            con.close();


        } catch (Exception e) {
            System.out.println("error in the booking table" + e);
        }
    }

    public static void bookingToRoomLinkTbl() {
        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            Statement stmt4 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM BookingToRoomLink";
            ResultSet rs4 = stmt4.executeQuery(sql);
            System.out.println("BookingToRoomLink Table: ");
            while (rs4.next()) {
                System.out.println("BookingRoomID:" + " " + rs4.getInt(1) + " " + "|BookingID:" + " " + rs4.getInt(2) + " " + "|Room Number:" + " " + rs4.getInt(3));
            }
            rs4.close();
            con.close();

        } catch (Exception e) {
            System.out.println("error in the bookingToRoomLink Table" + e);
        }

    }

    public static void restaurantBookingTbl() {
        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            Statement stmt5 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM restaurantBooking";
            ResultSet rs5 = stmt5.executeQuery(sql);
            System.out.println("restaurantBooking Table: ");
            while (rs5.next()) {
                System.out.println("RestaurantBookingID:" + " " + rs5.getInt(1) + " " + "|BookingID:" + " " + rs5.getInt(2) + " " + "|Table number:" + " " + rs5.getInt(3) + " " + "|Bill amount £:" + " " + rs5.getInt(4) + " " + "|Time:" + " " + rs5.getTime(5) + " " + "|Date:" + " " +rs5.getDate(6));
            }
            rs5.close();
            con.close();

        } catch (Exception e) {
            System.out.println("error in the Restaurant Booking table" + e);
        }
    }

    public static void roomTbl() {

        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            Statement stmt6 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM restaurantBooking";
            ResultSet rs6 = stmt6.executeQuery(sql);
            System.out.println("Room Table: ");
            while (rs6.next()) {
                System.out.println("Room Number:" + " " + rs6.getInt(1) + " " + "|Room type:" + " " +rs6.getString("room type")+ " " + "|Price £:" + " " + rs6.getInt(3));
            }
            rs6.close();
            con.close();

            }catch (Exception e){
            System.out.println("error in the Room Table" + e);
        }
        }
    }









