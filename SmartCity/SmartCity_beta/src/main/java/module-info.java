module com.example.smartcity_beta {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.smartcity_beta to javafx.fxml;
    exports com.example.smartcity_beta;
}