// set up a new scene and shows it on screen

package com.example.hotelbookingsystemnea;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("startPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
        //database tables
        Database.employeeTbl();
        Database.customerTbl();
        Database.bookingTbl();
        Database.bookingToRoomLinkTbl();
        Database.restaurantBookingTbl();
        Database.roomTbl();







    }
}

