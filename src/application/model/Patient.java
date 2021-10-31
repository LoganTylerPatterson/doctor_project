package application.model;
import java.util.*;
//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

public class Patient extends User{
	private String firstName;
	private String lastName;
	private long dateOfBirth;
	private Evaluation evaluation;
	private Doctor assignedDoctor;
	private String phoneNumber;
	private String address;
	private ArrayList<Long> previousVisits;
	private ArrayList<Medication> currentMedications;
	private Insurance insurance;
	private Pharmacy pharmacy;
	private String password;

	public Patient() {}
	public Patient(String firstName, String lastName, long dateOfBirth, Evaluation evaluation, Doctor doctor, String phoneNumber, String address,
			ArrayList<Long> previousVisits, ArrayList<Medication> currentMedications, Insurance insurance,
			Pharmacy pharmacy, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.evaluation = evaluation;
		this.assignedDoctor = doctor;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.previousVisits = previousVisits;
		this.currentMedications = currentMedications;
		this.insurance = insurance;
		this.pharmacy = pharmacy;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public Doctor getAssignedDoctor() {
		return assignedDoctor;
	}

	public void setAssignedDoctor(Doctor assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Long> getPreviousVisits() {
		return previousVisits;
	}
	public void setPreviousVisits(ArrayList<Long> previousVisits) {
		this.previousVisits = previousVisits;
	}
	public ArrayList<Medication> getCurrentMedications() {
		return currentMedications;
	}
	public void setCurrentMedications(ArrayList<Medication> currentMedications) {
		this.currentMedications = currentMedications;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassowrd(String password) {
		this.password = password;
	}
}
