package application.controllers;

import application.JsonUtil;
import application.SceneUtil;
import application.model.Evaluation;
import application.model.Nurse;
import application.model.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Objects;

public class NurseEvaluationController {

    Patient p;
    Nurse n;

    @FXML
    private TextField tfSys;
    @FXML
    private TextField tfDia;
    @FXML
    private TextField tfTemp;
    @FXML
    private TextField tfRespiration;
    @FXML
    private TextField tfPulse;
    @FXML
    private Button btnSubmit;

    public void setPatient(Patient p, Nurse n){
        this.p = p;
        this.n = n;
        populateFields();
    }

    public void populateFields(){
        Evaluation eval = p.getEvaluation();
        //SetBloodPressure
        splitBP(eval);
        //SetRespiration
        tfRespiration.setText(eval.getRespirationRate());
        tfPulse.setText(eval.getPulse());
        tfTemp.setText(eval.getTemperature());
    }

    public void splitBP(Evaluation eval){
        String dias = eval.getBloodPressure();
        if(!Objects.equals(dias, "")){
            dias = dias.substring(0, dias.length() - 4 );
            int mid = dias.indexOf("/");
            String sys = dias.substring(0, mid);
            dias = dias.substring(mid+1);
            System.out.println("sys is " + sys + "dias is " + dias);
            tfSys.setText(sys);
            tfDia.setText(dias);
        }
    }

    public void submitEvaluation(ActionEvent e){
        String bp = buildBp(tfSys.getText(), tfDia.getText());
        Evaluation eval = p.getEvaluation();
        eval.setRespirationRate(tfRespiration.getText());
        eval.setPulse(tfPulse.getText());
        eval.setTemperature(tfTemp.getText());
        eval.setBloodPressure(bp);
        p.setEvaluation(eval);
        JsonUtil util = new JsonUtil();
        util.writePatientToJsonFile(p, p.getEmailAddress());
        SceneUtil switcher = new SceneUtil();
        switcher.switchToPickerScene(e, this.n);
    }

    public String buildBp(String sys, String dias){
        return sys + "/" + dias +" mmHg";
    }
}
