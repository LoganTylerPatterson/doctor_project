package application.controllers;

import application.JsonUtil;
import application.SceneUtil;
import application.model.Medication;
import application.model.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class PatientGUIController {
    Patient p = null;
    @FXML
    Label tfFirst;
    @FXML
    Label tfLast;
    @FXML
    Label email;
    @FXML
    Label dob;
    @FXML
    Label tfPhone;
    @FXML
    Label tfAddress;
    @FXML
    ListView<String> lvPrevAppts;
    @FXML
    ListView<String> lvHistory;
    @FXML
    ListView<String> lvMeds;
    @FXML
    TextField tfPharmName;
    @FXML
    TextField tfPharmNumber;
    @FXML
    TextField tfPharmAddress;
    @FXML
    DatePicker dpSchedule;
    @FXML
    Button btnSchedule;
    @FXML
    Button btnDone;
    @FXML
    Button btnCancel;
    @FXML
    Label textSched;

    SceneUtil switcher;

    @FXML
    public void initialize(){
        switcher = new SceneUtil();
        textSched.setVisible(false);
    }

    public void done(ActionEvent e){
        switcher.switchToLogin(e);
    }
    public void cancel(ActionEvent e){
        switcher.switchToLogin(e);
    }

    public void scheduleAppt(ActionEvent e){
        long dob = Date.from(Instant.from(dpSchedule.getValue().atStartOfDay(ZoneId.systemDefault()))).getTime();
        textSched.setVisible(true);

        ArrayList<Long> pv = p.getPreviousVisits();
        pv.add(dob);
        p.setPreviousVisits(pv);
        JsonUtil j = new JsonUtil();
        j.writePatientToJsonFile(p, p.getEmailAddress());
    }

    public void setData(Patient p){
        this.p = p;
        populateWidgets();
    }

    public void populateWidgets(){
        tfFirst.setText(p.getFirstName());
        tfLast.setText(p.getLastName());
        tfAddress.setText(p.getAddress());
        tfPhone.setText(p.getPhoneNumber());
        dob.setText(getDateString(p.getDateOfBirth()));
        email.setText(p.getEmailAddress());
        tfPharmAddress.setText(p.getPharmacy().getAddress());
        tfPharmName.setText(p.getPharmacy().getName());
        tfPharmNumber.setText(p.getPharmacy().getPhoneNumber());
        ArrayList<Long> prevs = p.getPreviousVisits();
        for(int i = 0; i < prevs.size() - 1; i++){
            lvPrevAppts.getItems().add(getDateString(prevs.get(i)));
        }
        ArrayList<Medication> meds = p.getCurrentMedications();
        for(int i = 0; i < meds.size() - 1; i++){
            lvMeds.getItems().add(meds.get(i).toString());
        }
        lvHistory.getItems().addAll(p.getHistory());
    }

    public void sendEmail(ActionEvent e){
        switcher.switchToSendEmail(e, this.p);
    }

    private String getDateString(long d){
        //creating Date from millisecond
        Date date = new Date(d);
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        return df.format(date);
    }

}
