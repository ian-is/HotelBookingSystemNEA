// code which operates the screen and makes it interactive
package Customer;

import Functions.HashPassword;
import Functions.SQL;
import com.example.hotelbookingsystemnea.Main;
import Objects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerLoginAndRegistrationController {

    private Stage stage;

// these methods make the buttons on the GUI interactive
    @FXML // when 'Employee log in' button is clicked this switches it to the 'EmployeeLogin' page
    public void switchToEmployeeLoginPage(ActionEvent event) throws IOException {




    }
    @FXML // switches to employer registration page.
    public void switchToEmployeeRegisterPage(ActionEvent event) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EmployeeRegisterPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 705, 440);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }



    @FXML // return button on  the employeeLogin page returns to the start page
    public void returnToStartPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("startPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML // register button on the start page takes you to the 'registrationPage'
    public void registerButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("RegistrationPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 715, 560);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML // return button on the registration page takes you back to the start page
    public void registrationReturnBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("startPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML // return button on the AdminHomePage takes you back to the EmployeeLogin Page
    public void adminReturnBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EmployeeRegisterPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 705, 440);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    // this code makes the login buttons work and checks it with the database

    //login page fields
    @FXML
    private TextField EmailTextField;

    @FXML
    private TextField PasswordTextField;

    @FXML
    private Label IncorrectLogIn;


    // Registration page fields

    @FXML
    private TextField FirstName;

    @FXML
    private TextField Surname;

    @FXML
    private TextField DateOfBirth;

    @FXML
    private TextField RegEmail;

    @FXML
    private TextField RegPassword;

    @FXML
    private Label RegError;

    @FXML
    private Label RegSuccessful;


    @FXML
    protected void LoginClick(MouseEvent event) {
        try {

            String Email = EmailTextField.getText();
            String Password = PasswordTextField.getText();

            if (CustomerLogin.customerLogin(Email, Password)) {
                CustomerHomePage(event);
            } else {
                IncorrectLogIn.setText("Login Details are Incorrect");
            }
        } catch (Exception e) {
            System.out.println("details are incorrect: " + e.getCause());
        }

    }

    @FXML
    private void CustomerHomePage(MouseEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(Main.class.getResource("CustomerHomePage.fxml"));
        Scene scene = new Scene(fxml.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("CustomerHomePage");
        stage.setScene(scene);
        stage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();


    }
    // for the register page

    public static void CustomerAddedToDatabase (User customer){
        Connection con =  CustomerLogin.getConnection();
        String sql1 = "SELECT * FROM Customer where Email = ' " + customer.getEmail() + " ' " ;
        ResultSet result = SQL.executeQuery(con , sql1);
        try {

            assert result != null;
            if (result.isBeforeFirst()) {
                System.out.println("This User already exists");
                result.close();
                if (con != null) {
                    con.close();

                }
            } else {
                result.close();
                String sql2 = "INSERT INTO Customer  (FirstName, Surname, DateOfBirth, Email, Password) " +
                        "VALUES ('" + customer.getFirstName() + "', '" + customer.getSurname() + "', '" + customer.getDateOfBirth() + "', '" + customer.getDateOfBirth() + "', '" + customer.getPassword() + "')";
                SQL.executeUpdate(con, sql2);
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException e) {
            System.out.println("User was not added to the database");

        }


    }

    @FXML
    protected void RegisterBtn2 (MouseEvent event) throws IOException {
        try {
            if (RegPassword.getText().equals("")) {
                RegError.setText("Information Fields incomplete");
            } else {
                byte[] hashSalt = HashPassword.SaltGeneration();
                byte[] passwordHash = HashPassword.PasswordHash(RegEmail.getText(), hashSalt);
                String hashHex = HashPassword.ConvertToHex(passwordHash);
                String salt = HashPassword.ConvertToHex(hashSalt);

                int CustomerID = 0;
                if (FirstName.getText().equals("")) {
                    RegError.setText("Field incomplete");
                } else if (Surname.getText().equals("")) {
                    RegError.setText("Field incomplete");
                } else if (DateOfBirth.getText().equals("")) {
                    RegError.setText("Field incomplete");
                } else if (RegEmail.getText().equals("")) {
                    RegError.setText("Field incomplete");
                } else if (RegPassword.getText().equals("")) {
                    RegError.setText("Field incomplete");
                } else {                                                                      // add back dateofbirth.gettext
                    User customer = new User(CustomerID, FirstName.getText(), Surname.getText(), RegEmail.getText(), hashHex, salt);
                    CustomerAddedToDatabase(customer);
                    RegError.setText("Registration error");
                    RegSuccessful.setText("account registered");
                }
            }
        } catch (Exception e) {
            System.out.println("account registration error:" + e);

        }

    }



    }




