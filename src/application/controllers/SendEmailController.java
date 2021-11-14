package application.controllers;

import application.Main;
import application.SceneUtil;
import application.model.Doctor;
import application.model.Nurse;
import application.model.Patient;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendEmailController {

    Doctor d = null;
    Nurse n = null;
    Patient p = null;

    @FXML
    TextField to;

    @FXML
    TextField subject;

    @FXML
    TextArea body;

    @FXML
    Button send;

    @FXML
    Button cancel;

    public void setData(User u) {
        if(u.getClass().toString().equals("class application.model.Doctor")){
            d = (Doctor) u;
        }
        else if(u.getClass().toString().equals("class application.model.Nurse")){
            n = (Nurse) n;
        }
        else if(u.getClass().toString().equals("class application.model.Patient")){
            p = (Patient) p;
        }
    }

    public void cancel(ActionEvent event){
        SceneUtil s = new SceneUtil();
        if(p != null){
            s.switchToPatientPortal(event, p);
        }
        else if(d != null){
            s.switchToPickerScene(event, d);
        }
        else if(n != null){
            s.switchToPickerScene(event, n);
        }
    }

    public void sendEmail(ActionEvent event){
        Main main = new Main();
        main.sendEmail(to.getText(), subject.getText(), body.getText());
        SceneUtil s = new SceneUtil();
        if(p != null){
            s.switchToPatientPortal(event, p);
        }
        else if(d != null){
            s.switchToPickerScene(event, d);
        }
        else if(n != null){
            s.switchToPickerScene(event, n);
        }
    }
}
