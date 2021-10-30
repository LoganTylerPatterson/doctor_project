package application.model;

import java.util.ArrayList;

public class Doctor {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String emailAddress;
	private String phoneNumber;
	private String address;
	private ArrayList<Long> upcomingAppts;
	private ArrayList<Patient> patients;
	
	public Doctor(String firstName, String lastName, String userName, String password, String emailAddress, String phoneNumber, String address,
			ArrayList<Long> upcomingAppts, ArrayList<Patient> patients) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.upcomingAppts = upcomingAppts;
		this.patients = patients;
	}

	public Doctor() {
		
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName(){
		return this.userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public ArrayList<Long> getUpcomingAppts() {
		return upcomingAppts;
	}
	public void setUpcomingAppts(ArrayList<Long> upcomingAppts) {
		this.upcomingAppts = upcomingAppts;
	}
	public ArrayList<Patient> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
}