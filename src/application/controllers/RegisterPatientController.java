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
import java.util.Objects;

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
    public void getMedications(ArrayList<Medication> meds){
        Medication med;
        if(tfMedName1.getText() != null){
            if(tfDosage1.getText() != null){
                if(tfUnit1.getText() != null){
                    med = new Medication(tfMedName1.getText(), tfDosage1.getText(), tfUnit1.getText());
                    meds.add(med);
                }
            }
        }
        if(tfMedName2.getText() != null){
            if(tfDosage2.getText() != null){
                if(tfUnit2.getText() != null){
                    med = new Medication(tfMedName2.getText(), tfDosage2.getText(), tfUnit2.getText());
                    meds.add(med);
                }
            }
        }
        if(tfMedName3.getText() != null){
            if(tfDosage3.getText() != null){
                if(tfUnit3.getText() != null){
                    med = new Medication(tfMedName3.getText(), tfDosage3.getText(), tfUnit3.getText());
                    meds.add(med);
                }
            }
        }
        if(tfMedName4.getText() != null){
            if(tfDosage4.getText() != null){
                if(tfUnit4.getText() != null){
                    med = new Medication(tfMedName4.getText(), tfDosage4.getText(), tfUnit4.getText());
                    meds.add(med);
                }
            }
        }
        if(tfMedName5.getText() != null){
            if(tfDosage5.getText() != null){
                if(tfUnit5.getText() != null){
                    med = new Medication(tfMedName5.getText(), tfDosage5.getText(), tfUnit5.getText());
                    meds.add(med);
                }
            }
        }
    }

    public boolean checkString(String str){
        boolean verified = true;
        for(int i = 0; i <= str.length() - 1 ;i++){
            if(!Character.isDigit(str.charAt(i))){
                verified = false;
            }
        }
        if(str == null){
            verified = true;
        }
        return verified;
    }

    public boolean validateFields(){
        boolean isGood = true;
        if(!checkString(tfPharmacyNumber.getText())){
            isGood = false;
        }
        if(!checkString(tfInsuranceNumber.getText())){
            isGood = false;
        }
        if(!checkString(tfDosage1.getText())){
            isGood = false;
        }
        if(!checkString(tfDosage2.getText())){
            isGood = false;
        }
        if(!checkString(tfDosage3.getText())){
            isGood = false;
        }
        if(!checkString(tfDosage4.getText())){
            isGood = false;
        }
        if(!checkString(tfDosage5.getText())){
            isGood = false;
        }
        return isGood;
    }

    public Doctor getPreferredDoctor(){
        Doctor preferredDoc = null;
        String doctorName = (String) cbDoctor.getValue();
        String[] names = doctorName.split(" ");
        for(int i = 0; i <= doctorObjs.size() - 1; i++){
            String fn = doctorObjs.get(i).getFirstName();
            String ln = doctorObjs.get(i).getLastName();
            if(Objects.equals(fn, names[0]) && Objects.equals(ln, names[1])){
                preferredDoc = doctorObjs.get(i);
            }
        }
        return preferredDoc;
    }

    public void registerPatient(ActionEvent e){
        boolean isGood = validateFields();
        if(isGood){
            Patient patient = getPatient();
            //Write patient to file
            util.writePatientToJsonFile(patient, patient.getEmailAddress());
            addPatientToRegistry(patient);
            addPatientToDoctorList(patient, getPreferredDoctor());
            switcher.switchToLogin(e);
        } else {
            System.out.println("You suck, enter better data");
        }
    }

    public Patient getPatient(){
        //Create pharmacy, insurance, and medication objects
        Pharmacy pharmacy = new Pharmacy(tfPharmacyName.getText(),taPharmacyAddress.getText(), tfPharmacyNumber.getText());
        Insurance insurance = new Insurance(tfPrimaryHolder.getText(), tfInsuranceName.getText(),
                tfInsuranceNumber.getText(), taInsuranceAddress.getText());

        //Add medications to list
        ArrayList<Medication> meds = new ArrayList<>();
        getMedications(meds);

        long dob = Date.from(Instant.from(pickerDob.getValue().atStartOfDay(ZoneId.systemDefault()))).getTime();

        //Get selected doctor
        Doctor preferredDoc = getPreferredDoctor();

        //Create patient obj
        Patient patient = new Patient(tfFirstname.getText(), tfLastname.getText(), tfEmail.getText(),dob, new Evaluation(),
                preferredDoc.getEmailAddress(), tfPhoneNumber.getText(), taAddress.getText(),new ArrayList<Long>(),
                meds, insurance, pharmacy, tfPassword.getText(), new ArrayList<String>(), "");

        return patient;
    }
    public void addPatientToDoctorList(Patient patient, Doctor d){
        //Add patient to doctors list of patients
        ArrayList<String> pats = d.getPatients();
        pats.add(patient.getEmailAddress());
        util.writeDoctorObjToJson(d, d.getUserName());
    }

    public void addPatientToRegistry(Patient patient){
        //Add patient to User Registry
        UserRegistry reg = util.getUserRegistry();
        ArrayList<String> patientUsernames = reg.getPatients();
        patientUsernames.add(patient.getEmailAddress());
        reg.setPatients(patientUsernames);
        util.writeUserRegistryToFile(reg);
    }
}