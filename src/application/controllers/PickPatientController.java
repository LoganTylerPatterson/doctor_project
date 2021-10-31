package application.controllers;

import application.JsonUtil;
import application.Main;
import application.model.Doctor;
import application.model.Nurse;
import application.model.Patient;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class PickPatientController {

    @FXML
    Button btnGo;
    @FXML
    Label labelRole;
    @FXML
    Label labelUser;
    @FXML
    ComboBox comboBoxPatients;

    private User user;
    private Nurse nurse;
    private Doctor doctor;
    private Stage stage;
    private JsonUtil util;

    public PickPatientController(){
        util = new JsonUtil();
    }

    public void setUser(User user){
        this.user = user;
        if(user.getClass().toString().equals("class application.model.Doctor")){
            doctor = (Doctor) user;
            labelUser.setText(doctor.getFirstName() + " " + doctor.getLastName());
            labelRole.setText("Doctor");
            setComboBoxItems(doctor.getPatients());
        }
        else if(user.getClass().toString().equals("class application.model.Nurse")){
            nurse = (Nurse) user;
            labelUser.setText(nurse.getFirstName() + " " + nurse.getLastName());
            labelRole.setText("Nurse");
            setComboBoxItems(nurse.getPatients());
        }
    }

    public void setComboBoxItems(ArrayList<String> patients){
        for(int i = 0; i <= patients.size() - 1;i++){
            Patient tmp = util.getPatientObjFromJson(patients.get(i));
            comboBoxPatients.getItems().add(tmp.getFirstName() + " " + tmp.getLastName());
        }
    }

    @FXML
    private void recieveData(MouseEvent event){
        System.out.println("RecieveData was called");
        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
    }

    public void switchToScene(ActionEvent e){
        Main main = new Main();
        String destination = "";
        if(Objects.equals(labelRole.getText(), "Nurse")){
            destination = "nurse_evaluation.fxml";
        }
        if(Objects.equals(labelRole.getText(), "Doctor")){
            destination = "nurse_evaluation.fxml";
        }
        main.switchToSceneWithUser(e, destination, user);
    }
}
