package application.controllers;

import application.JsonUtil;
import application.SceneUtil;
import application.model.Doctor;
import application.model.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduleAppointmentController {

    Doctor doc;
    Patient pat;

    @FXML
    Label lbSchedule;
    @FXML
    ComboBox<String> cbSelectDoctor;
    @FXML
    ComboBox<String> cbSelectDate;
    @FXML
    ComboBox<String> cbSelectTime;
    @FXML
    ComboBox<String> cbSelectReason;
    @FXML
    Button btnSchedule;

    JsonUtil util;
    SceneUtil switcher;

    ArrayList<Doctor> doctorObjs = new ArrayList();

    @FXML
    public void initialize(){
        util = new JsonUtil();
        switcher = new SceneUtil();

        ArrayList<String> doctors = util.getUserRegistry().getDoctors();
        for(int i = 0; i <= doctors.size() - 1; i++) {
            Doctor doc = util.getDoctorObjFromJson(doctors.get(i));
            doctorObjs.add(doc);
            cbSelectDoctor.getItems().add(doc.getFirstName() + " " + doc.getLastName());
        }


    }


}
