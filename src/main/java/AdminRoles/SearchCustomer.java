package AdminRoles;

import Functions.SQL;
import Objects.User;

import java.util.ArrayList;

public class SearchCustomer {

    // MERGE SORT TO SEARCH EMAILS AND FIND CUSTOMERS
    public static void sortUser(){


        ArrayList <User> allCustomers = SQL.SearchDatabase("SELECT  * FROM Customer");
        String [] Email = new String [allCustomers.size()];
        for (int i = 0; i < allCustomers.size(); i++) {
            Email[i] = allCustomers.get(i).getEmail();
        }
        MergeSort (Email);
        for (int i = 0; i < Email.length; i++) {
            System.out.println(Email[i]);

        }
        }

        private static void MergeSort (String [] Email){
        if(Email.length < 2 ){
            return;
        }

        int center = Email.length /2;
        String [] left = new String [center];
        String [] right = new String [Email.length - center];
            for (int i = 0; i < center; i++) {
                left[i] = Email[i];

            }
            for (int i = center; i < center; i++) {
                right [i - center ] = Email [i];
            }

            MergeSort((right));
            MergeSort(left);


    }

    private static void Merge (String [] Email, String [] right, String [] left){

        System.out.println("please Enter Email");
        int a = 0;
        int b = 0;
        int c = 0;
        Character.getNumericValue(left[1].charAt(0));
        while(a < left.length && b < right.length){
            if( Character.getNumericValue(left[a].charAt(0)) <= Character.getNumericValue(right[b].charAt(0))){
                Email[c] = left [a];
                a++;

            } else {
                Email[c] = right[a];
                a++;
            } c ++;


        }
        while (a <left.length){
            Email[c] = left[a];
            a++;
            c++;

        }
        while (b< right.length){
            Email[c] = right[b];
            b++;
            c++;
        }
    }




}
