package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NurseEvaluationController {

    @FXML
    private TextField tfBloodPressure;

    public void submitEvaluation(ActionEvent e){
        String bp = tfBloodPressure.getText();
    }
}
