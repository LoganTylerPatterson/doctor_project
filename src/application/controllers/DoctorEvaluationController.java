package application.controllers;

import application.model.Doctor;
import application.model.Medication;
import application.model.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DoctorEvaluationController {
    Doctor doc;
    Patient pat;

    @FXML
    ListView<String> lvHistory;
    @FXML
    ListView<String> lvCurrentMedications;
    @FXML
    TextField tfMedicationName;
    @FXML
    TextField tfMedAmount;
    @FXML
    TextField tfMedUnit;
    @FXML
    TextField tfPharmacyName;
    @FXML
    TextField tfPharmacyNumber;
    @FXML
    Button btnPrescribe;
    @FXML
    TextArea taNotes;
    @FXML
    CheckBox cbEyes;
    @FXML
    CheckBox cbEars;
    @FXML
    CheckBox cbNose;
    @FXML
    CheckBox cbHeart;
    @FXML
    CheckBox cbThroat;
    @FXML
    CheckBox cbReflexes;
    @FXML
    CheckBox cbBreathing;
    @FXML
    TextArea taEyesNotes;
    @FXML
    TextArea taEarNotes;
    @FXML
    TextArea taNoseNotes;
    @FXML
    TextArea taHeartNotes;
    @FXML
    TextArea taThroatNotes;
    @FXML
    TextArea taReflexesNotes;
    @FXML
    TextArea taBreathingNotes;
    @FXML
    Button btnSubmit;
    @FXML
    Button btnViewNurseEval;


    public void addMedication(ActionEvent e){
        String dosage = tfMedAmount.getText();
        String unit = tfMedUnit.getText();
        String name = tfMedicationName.getText();
        Medication med = new Medication(name, dosage, unit);
        lvCurrentMedications.getItems().add(med.toString());
        pat.getCurrentMedications().add(med);
    }

    public void setData(Doctor doctor, Patient patient){
        this.doc = doctor;
        this.pat = patient;
        populateFields(this.pat);
    }

    public void submitEvaluation(){

    }

    public void viewNurseEvaluation(){

    }

    public void populateFields(Patient pat){
        //Populate patient history
        for(int i = 0; i <= pat.getHistory().size() - 1; i++){
            lvHistory.getItems().add(pat.getHistory().get(i));
        }
        //Populate medical history
        for(int i = 0; i <= pat.getCurrentMedications().size() - 1; i++){
            lvCurrentMedications.getItems().add(pat.getCurrentMedications().get(i).toString());
        }
        //Populate the note
        taNotes.setText(pat.getNote());

        //Populate the pharmacy field
        String name = pat.getPharmacy().getName();
        String num = pat.getPharmacy().getPhoneNumber();
        if(!name.isBlank() || name.isEmpty()){
            tfPharmacyName.setText(name);
        }
        if(!num.isEmpty() || name.isBlank()){
            tfPharmacyNumber.setText(num);
        }
    }
}
