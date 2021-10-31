package application.model;

import java.util.ArrayList;

public class Doctor extends User{
	private java.lang.String firstName;
	private java.lang.String lastName;
	private java.lang.String userName;
	private java.lang.String password;
	private java.lang.String emailAddress;
	private java.lang.String phoneNumber;
	private java.lang.String address;
	private ArrayList<Long> upcomingAppts;
	private ArrayList<java.lang.String> patients;
	private java.lang.String role;
	
	public Doctor(java.lang.String firstName, java.lang.String lastName, java.lang.String userName, java.lang.String password, java.lang.String emailAddress, java.lang.String phoneNumber, java.lang.String address,
				  ArrayList<Long> upcomingAppts, ArrayList<java.lang.String> patients, java.lang.String role) {
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
		this.role = role;
	}

	public Doctor() {
		
	}

	public java.lang.String getRole(){
		return role;
	}
	public void setRole(java.lang.String role){
		this.role = role;
	}
	public java.lang.String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(java.lang.String emailAddress) {
		this.emailAddress = emailAddress;
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
	public void setUserName(java.lang.String userName){
		this.userName = userName;
	}
	public java.lang.String getUserName(){
		return this.userName;
	}
	public java.lang.String getPassword() {
		return password;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
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
	public ArrayList<Long> getUpcomingAppts() {
		return upcomingAppts;
	}
	public void setUpcomingAppts(ArrayList<Long> upcomingAppts) {
		this.upcomingAppts = upcomingAppts;
	}
	public ArrayList<java.lang.String> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<java.lang.String> patients) {
		this.patients = patients;
	}
}
