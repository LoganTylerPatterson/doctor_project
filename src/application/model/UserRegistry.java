package application.model;

import javafx.collections.ArrayChangeListener;

import java.util.ArrayList;

public class UserRegistry {
    private ArrayList<String> doctors;
    private ArrayList<String> patients;
    private ArrayList<String> nurses;

    public UserRegistry(){}

    public UserRegistry(ArrayList<String> doctors, ArrayList<String> patients, ArrayList<String> nurses) {
        this.doctors = doctors;
        this.patients = patients;
        this.nurses = nurses;
    }

    public ArrayList<String> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<String> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<String> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<String> patients) {
        this.patients = patients;
    }

    public ArrayList<String> getNurses() {
        return nurses;
    }

    public void setNurses(ArrayList<String> nurses) {
        this.nurses = nurses;
    }
}
