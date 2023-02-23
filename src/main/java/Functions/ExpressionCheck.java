package Functions;


import java.util.Scanner;
import java.util.regex.Pattern;

public class ExpressionCheck {


    //REGUALR EXPRESSION CHECK FOR EMAIL
    public static String RegularExpression (String check, String regex, String Field, String Attributes){
        Scanner input = new Scanner (System.in);
        System.out.println("Enter " + Field + ":" +Attributes);
        String Email = input.next();
        String wrongPattern =  "^(.+)@(\\S+)$";
        while (!(Pattern.compile(regex).matcher(Email).matches())){
            input.nextLine();
            System.out.println(Field  + ":field entered is incorrect");
            System.out.println("ente the approproate field ");
            Email = input.next();


        }
        return Email;

    }


}
