package Bookings;

import java.sql.*;
import java.util.ArrayList;

public class RoomBooking {



    public static ArrayList<Bookings> AddBooking(String sql) {
        ArrayList<Bookings> addBookings = new ArrayList<Bookings>();
        String DatabaseLocation = System.getProperty("user.dir") + "\\Database1.accdb";
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt.executeQuery(sql);
            ResultSetMetaData rsmd1 = rs1.getMetaData();

            while (rs1.next()) {
                Date date = rs1.getDate(3);
                Bookings addNewBooking = new Bookings(rs1.getInt(1), rs1.getInt(2), rs1.getDate(3), rs1.getDate(4));
                addBookings.add(addNewBooking);
            } con.close();


        } catch (Exception e) {
            System.out.println("error in Room Booking class: " + e);
        }
        return addBookings;


    }



        }




