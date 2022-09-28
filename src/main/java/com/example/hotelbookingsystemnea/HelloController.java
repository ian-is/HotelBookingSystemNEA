// code which operates the screen and makes it interactive
package com.example.hotelbookingsystemnea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;


    @FXML // when 'Employee log in' button is clicked this switches it to the 'EmployeeLogin' page
    public void switchToEmployeeLoginPage (ActionEvent event) throws IOException  {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EmployeeLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 705, 440);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }
    @FXML // return button on  the employeeLogin page returns to the start page
    public void returnToStartPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("startPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML // register button on the start page takes you to the 'registrationPage'
    public void registerButton (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrationPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 715, 560);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML // return button on the registration page takes you back to the start page
    public void registrationReturnBtn (ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("startPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML // return button on the AdminHomePage takes you back to the EmployeeLogin Page
    public void adminReturnBtn (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EmployeeLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 705, 440);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }























    }
