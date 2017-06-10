package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


import java.util.Random;

public class Controller {


    @FXML
    private Button button;


    @FXML
    private void handleButtonAction() {
        Random rd = new Random();
        button.setLayoutX(rd.nextInt(300));
        button.setLayoutY(rd.nextInt(300));
    }

    @FXML
    private void Clicked() {
        Platform.exit();
        System.exit(0);
    }

}
