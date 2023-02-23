// set up a new scene and shows it on screen

package com.example.hotelbookingsystemnea;

import Admin.AdminEntry;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("startPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) {
        launch();

        Scanner input = new Scanner(System.in);
        System.out.println("welcome to the booking System");
        System.out.println("Are you a Admin (Y/N)");
        String userInput = input.next();
        if (userInput.equals("Y")) {
            AdminEntry.AdminEntry();

        }else {
            System.out.println("if you are a customer please use the customer interface (GUI)");
        }













    }
}

