package com.lab6;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    protected void onHelloButtonClick() {
        System.out.println("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onExitButtonClick(){
        System.exit(0);
    }
}