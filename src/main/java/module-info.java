module com.example.hotelbookingsystemnea {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hotelbookingsystemnea to javafx.fxml;
    exports com.example.hotelbookingsystemnea;
    exports Functions;
    opens Functions to javafx.fxml;
    exports Customer;
    opens Customer to javafx.fxml;
    exports Objects;
    opens Objects to javafx.fxml;
}