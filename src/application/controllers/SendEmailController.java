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

    Doctor d;
    Nurse n;
    Patient p;
    boolean isDoctor;
    boolean isNurse;
    boolean isPatient;

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

    // This function determines who is sending an email
    public void setData(User u) {
        System.out.println(u.getClass().toString());
        if(u.getClass().toString().equals("class application.model.Doctor")){
            this.d = (Doctor) u;
            isDoctor = true;
        }
        else if(u.getClass().toString().equals("class application.model.Nurse")){
            this.n = (Nurse) u;
            isNurse = true;
        }
        else if(u.getClass().toString().equals("class application.model.Patient")){
            this.p = (Patient) u;
            isPatient = true;
        }
    }

    // This function cancels an email being sent
    public void cancel(ActionEvent event){
        SceneUtil s = new SceneUtil();
        if(p != null){
            s.switchToPatientPortal(event, p);
        }
        if(d != null){
            s.switchToPickerScene(event, d);
        }
        if(n != null){
            s.switchToPickerScene(event, n);
        }
    }

    // This function sends an email
    public void sendEmail(ActionEvent event){
        Main main = new Main();
        main.sendEmail(to.getText(), subject.getText(), body.getText());
        SceneUtil s = new SceneUtil();
        System.out.println("We are here");
        if(isPatient){
            s.switchToPatientPortal(event, this.p);
        }
        else if(isDoctor){
            s.switchToPickerScene(event, this.d);
        }
        if(isNurse){
            s.switchToPickerScene(event, this.n);
        }
    }
}
