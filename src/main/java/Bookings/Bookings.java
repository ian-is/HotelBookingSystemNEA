package Bookings;

import java.sql.Date;
import java.time.LocalDate;

public class Bookings {

    private int BookingID;

    private LocalDate CheckInDate;

    private LocalDate CheckOutDate;

    private int RoomNumber;

    private String RoomType;

    private String RoomPrice;

    public Bookings (int bookingID,LocalDate checkInDate, LocalDate checkOutDate, int roomNumber, String roomPrice, String roomType){
        BookingID = bookingID;
        CheckInDate = checkInDate;
        CheckOutDate = checkOutDate;
        RoomNumber = roomNumber;
        RoomType = roomType;
        RoomPrice = roomPrice;


    }

    public Bookings(int anInt, int anInt1, Date date, Date date1) {
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public LocalDate getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        CheckInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        CheckOutDate = checkOutDate;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.RoomNumber = roomNumber;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        this.RoomType = roomType;
    }

    public String getRoomPrice() {
        return RoomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.RoomPrice = roomPrice;
    }

    @Override
    public String toString (){
        return "Booking{" +
                "BookingID =" + BookingID+
                "CheckInDate =" + CheckInDate +
                "CheckOutDate =" + CheckOutDate+
                "RoomNumber =" +RoomNumber +
                "RoomType =" + RoomType +
                "RoomPrice =" +RoomPrice+
                '}';
    }




}
