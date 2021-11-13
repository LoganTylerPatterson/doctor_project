package application.controllers;

import application.JsonUtil;
import application.SceneUtil;
import application.model.Doctor;
import application.model.Evaluation;
import application.model.Medication;
import application.model.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

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

    JsonUtil util;
    SceneUtil switcher;

    @FXML
    public void initialize(){
        util = new JsonUtil();
        switcher = new SceneUtil();
    }

    public void addMedication(ActionEvent e){
        String dosage = tfMedAmount.getText();
        String unit = tfMedUnit.getText();
        String name = tfMedicationName.getText();
        Medication med = new Medication(name, dosage, unit);
        lvCurrentMedications.getItems().add(med.toString());
        ArrayList<Medication> meds = pat.getCurrentMedications();
        meds.add(med);
        pat.setCurrentMedications(meds);
        util.writePatientToJsonFile(pat, pat.getEmailAddress());
        tfMedAmount.clear();
        tfMedicationName.clear();
        tfMedUnit.clear();
    }

    public void setData(Doctor doctor, Patient patient){
        this.doc = doctor;
        this.pat = patient;
        populateFields(this.pat);
    }

    public void submitEvaluation(ActionEvent e){
        //Fill evaluation fields
        Evaluation eval = new Evaluation();
        eval.setEyesAbnormal(cbEyes.isSelected());
        eval.setEarsAbnormal(cbEars.isSelected());
        eval.setNoseAbnormal(cbNose.isSelected());
        eval.setHeartAbnormal(cbHeart.isSelected());
        eval.setBreathingAbnormal(cbBreathing.isSelected());
        eval.setThroatAbnormal(cbThroat.isSelected());
        eval.setReflexesAbnormal(cbReflexes.isSelected());

        eval.setEyesNotes(taEyesNotes.getText());
        eval.setEarsNotes(taEarNotes.getText());
        eval.setNoseNotes(taNoseNotes.getText());
        eval.setHeartNotes(taHeartNotes.getText());
        eval.setThroatNotes(taThroatNotes.getText());
        eval.setBreathingNotes(taBreathingNotes.getText());
        eval.setReflexesNotes(taBreathingNotes.getText());

        //setEval to patient
        Evaluation nurseEval = pat.getEvaluation();
        eval.setRespirationRate(nurseEval.getRespirationRate());
        eval.setTemperature(nurseEval.getTemperature());
        eval.setBloodPressure(nurseEval.getBloodPressure());
        eval.setPulse(nurseEval.getPulse());

        pat.setEvaluation(eval);

        //Set Notes to patient
        pat.setNote(taNotes.getText());

        util.writePatientToJsonFile(pat, pat.getEmailAddress());

        //Go to pickPatient screen again
        switcher.switchToPickerScene(e, this.doc);
    }

    public void viewNurseEvaluation(){
        //TODO Switch to nurse evaluation scene
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

        //Populate the evaluation history
        taEyesNotes.setText(pat.getEvaluation().getEyesNotes());
        taEarNotes.setText(pat.getEvaluation().getEarsNotes());
        taNoseNotes.setText(pat.getEvaluation().getNoseNotes());
        taThroatNotes.setText(pat.getEvaluation().getThroatNotes());
        taHeartNotes.setText(pat.getEvaluation().getHeartNotes());
        taReflexesNotes.setText(pat.getEvaluation().getReflexesNotes());
        taBreathingNotes.setText(pat.getEvaluation().getBreathingNotes());

        cbEyes.setSelected(pat.getEvaluation().isEyesAbnormal());
        cbEars.setSelected(pat.getEvaluation().isEarsAbnormal());
        cbNose.setSelected(pat.getEvaluation().isNoseAbnormal());
        cbThroat.setSelected(pat.getEvaluation().isThroatAbnormal());
        cbBreathing.setSelected(pat.getEvaluation().isBreathingAbnormal());
        cbReflexes.setSelected(pat.getEvaluation().isReflexesAbnormal());
    }
}
