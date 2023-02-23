package Bookings;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class GetDate {

    // chooses a date and checks to see if it is after a specified date
    public static LocalDate getDate (Scanner input, LocalDate dateChosen) {
        boolean dateBL = false;        /*(dateBL = date boolean) */
        while (!dateBL) {
            try {
                String date1 = input.next();
                dateChosen = LocalDate.parse(date1);
                if (dateChosen.isAfter(LocalDate.now().plusDays(7).plusMonths(12))) {
                    System.out.println("please select a date you wish to book");
                } else {
                    dateBL = true;
                }

            } catch (DateTimeException D) {
                System.out.println("please select appropriate date (MM/DD/YYYY)");
            } catch (Exception e) {
                System.out.println("error in the getDate class");

            }

        }
        return dateChosen;
    }


}
