package application.controllers;

import application.JsonUtil;
import application.SceneUtil;
import application.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

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
    ComboBox cbDoctor;
    @FXML
    Button btnRegister;
    @FXML
    Button btnCancel;

    ArrayList<Doctor> doctorObjs = new ArrayList();

    SceneUtil switcher;
    JsonUtil util;

    @FXML
    public void initialize(){
        util = new JsonUtil();
        switcher = new SceneUtil();
        ArrayList<String> doctors = util.getUserRegistry().getDoctors();
        for(int i = 0; i <= doctors.size() - 1; i++){
            Doctor doc = util.getDoctorObjFromJson(doctors.get(i));
            doctorObjs.add(doc);
            cbDoctor.getItems().add(doc.getFirstName() + " " + doc.getLastName());
        }
    }

    public void cancelRegistration(ActionEvent e){
        switcher.switchToLogin(e);
    }

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

        long dob = Date.from(Instant.from(pickerDob.getValue().atStartOfDay(ZoneId.systemDefault()))).getTime();

        //Get selected doctor
        Doctor preferredDoc = null;
        String doctorName = (String) cbDoctor.getValue();
        String[] names = doctorName.split(" ");
        System.out.println("Names are " + names.toString());
        for(int i = 0; i <= doctorObjs.size() - 1; i++){
            if(doctorObjs.get(i).getFirstName().equals(names[0]) && doctorObjs.get(i).getFirstName().equals(names[1])){
                preferredDoc = doctorObjs.get(i);
            }
        }
        //Assertion is fine because the only possibilities are the doctors that are being pulled in
        //Create patient obj
        assert preferredDoc != null;
        Patient patient = new Patient(tfFirstname.getText(), tfLastname.getText(), tfEmail.getText(),dob, new Evaluation(),
                preferredDoc.getEmailAddress(), tfPhoneNumber.getText(), taAddress.getText(),new ArrayList<Long>(),
                meds, insurance, pharmacy, tfPassword.getText());

        //Write patient to file
        util.writePatientToJsonFile(patient, patient.getEmailAddress());

        //Add patient to User Registry
        UserRegistry reg = util.getUserRegistry();
        ArrayList<String> patientUsernames = reg.getPatients();
        patientUsernames.add(patient.getEmailAddress());
        reg.setPatients(patientUsernames);
        util.writeUserRegistryToFile(reg);

        //Add patient to doctors list of patients
        ArrayList<String> pats = preferredDoc.getPatients();
        pats.add(patient.getEmailAddress());
        util.writeDoctorObjToJson(preferredDoc, preferredDoc.getUserName());
        switcher.switchToLogin(e);
    }
}
