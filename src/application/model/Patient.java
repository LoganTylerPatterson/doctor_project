package application.model;
import java.util.*;
//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

public class Patient extends User{
	private java.lang.String firstName;
	private java.lang.String lastName;

	public java.lang.String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(java.lang.String emailAddress) {
		this.emailAddress = emailAddress;
	}

	private java.lang.String emailAddress;
	private long dateOfBirth;
	private Evaluation evaluation;
	private String assignedDoctor;
	private String phoneNumber;
	private String address;
	private ArrayList<Long> previousVisits;
	private ArrayList<Medication> currentMedications;
	private Insurance insurance;
	private Pharmacy pharmacy;
	private String password;

	public Patient() {}
	public Patient(String firstName, String lastName,String emailAddress, long dateOfBirth, Evaluation evaluation, String doctor, String phoneNumber, String address,
			ArrayList<Long> previousVisits, ArrayList<Medication> currentMedications, Insurance insurance,
			Pharmacy pharmacy, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
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

	public String getAssignedDoctor() {
		return assignedDoctor;
	}

	public void setAssignedDoctor(String assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	public java.lang.String getFirstName() {
		return firstName;
	}
	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}
	public java.lang.String getLastName() {
		return lastName;
	}
	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}
	public long getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public java.lang.String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
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

	public java.lang.String getPassword() {
		return this.password;
	}
}
