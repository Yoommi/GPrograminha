package com.example.gp;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class RootLayoutController {

    @FXML
    private MenuBar menuBar;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void showGame() {
        mainApp.showGameView();
    }
}


