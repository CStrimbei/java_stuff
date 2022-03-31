module com.lab6.lab6comp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab6 to javafx.fxml;
    exports com.lab6;
}