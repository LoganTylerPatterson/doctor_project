package application.controllers;

import application.JsonUtil;
import application.SceneUtil;
import application.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Timestamp;
import java.util.ArrayList;

public class RegisterPatientController {

    @FXML
    TextField tfFirstname;
    @FXML
    TextField tfLastname;
    @FXML
    TextField tfEmail;
    @FXML
    TextField tfPassword;
    @FXML
    TextField tfPhoneNumber;
    @FXML
    TextArea taAddress;
    @FXML
    DatePicker pickerDob;
    @FXML
    TextField tfPrimaryHolder;
    @FXML
    TextField tfInsuranceName;
    @FXML
    TextField tfInsuranceNumber;
    @FXML
    TextArea taInsuranceAddress;
    @FXML
    TextField tfPharmacyName;
    @FXML
    TextField tfPharmacyNumber;
    @FXML
    TextArea taPharmacyAddress;
    @FXML
    TextField tfMedName1;
    @FXML
    TextField tfDosage1;
    @FXML
    TextField tfUnit1;
    @FXML
    TextField tfMedName2;
    @FXML
    TextField tfDosage2;
    @FXML
    TextField tfUnit2;
    @FXML
    TextField tfMedName3;
    @FXML
    TextField tfDosage3;
    @FXML
    TextField tfUnit3;
    @FXML
    TextField tfMedName4;
    @FXML
    TextField tfDosage4;
    @FXML
    TextField tfUnit4;
    @FXML
    TextField tfMedName5;
    @FXML
    TextField tfDosage5;
    @FXML
    TextField tfUnit5;
    @FXML
    Button btnRegister;
    @FXML
    Button btnCancel;

    SceneUtil switcher;
    JsonUtil util;

    @FXML
    public void initialize(){
        util = new JsonUtil();
        switcher = new SceneUtil();
    }


    public void cancelRegistration(ActionEvent e){
        switcher.switchToLogin(e);
    }
    //TODO get selected doctor

    public void registerPatient(ActionEvent e){
        //Create pharmacy, insurance, and medication objects
        Pharmacy pharmacy = new Pharmacy(tfPharmacyName.getText(),taPharmacyAddress.getText(), tfPharmacyNumber.getText());
        Insurance insurance = new Insurance(tfPrimaryHolder.getText(), tfInsuranceName.getText(),
                tfInsuranceNumber.getText(), taInsuranceAddress.getText());
        Medication med1 = new Medication(tfMedName1.getText(), Integer.parseInt(tfDosage1.getText()), tfUnit1.getText());
        Medication med2 = new Medication(tfMedName2.getText(), 0, tfUnit2.getText());
        Medication med3 = new Medication(tfMedName3.getText(), 0, tfUnit3.getText());
        Medication med4 = new Medication(tfMedName4.getText(), 0, tfUnit4.getText());
        Medication med5 = new Medication(tfMedName5.getText(), 0, tfUnit5.getText());

        //Add medications to list
        ArrayList<Medication> meds = new ArrayList<>();
        meds.add(med1);
        meds.add(med2);
        meds.add(med3);
        meds.add(med4);
        meds.add(med5);

        String dob = Timestamp.valueOf(pickerDob.getValue().atTime(0,0)).toString();

        //Create patient obj
        Patient patient = new Patient(tfFirstname.getText(), tfLastname.getText(), tfEmail.getText(),1910191019L, new Evaluation(),
                "DonAdams@gmail.com", tfPhoneNumber.getText(), taAddress.getText(),new ArrayList<Long>(),
                meds, insurance, pharmacy, tfPassword.getText());

        //Write patient to file
        util.writePatientToJsonFile(patient, patient.getEmailAddress());

        //Add patient to User Registry
        UserRegistry reg = util.getUserRegistry();
        ArrayList<String> patientUsernames = reg.getPatients();
        patientUsernames.add(patient.getEmailAddress());
        reg.setPatients(patientUsernames);
        util.writeUserRegistryToFile(reg);

        switcher.switchToLogin(e);
    }
}
