module com.example.hotelbookingsystemnea {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hotelbookingsystemnea to javafx.fxml;
    exports com.example.hotelbookingsystemnea;
}