package application.model;

import java.util.ArrayList;

public class Nurse extends User{
	private String firstName;
	private String lastName;
	private String password;
	private String phoneNumber;
	private String address;
	private ArrayList<String> patients;
	private String role;
	
	public Nurse() {}
	public Nurse(String firstName, String lastName, String password, String phoneNumber, String address,
			ArrayList<String> patients, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.patients = patients;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public ArrayList<String> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<String> patients) {
		this.patients = patients;
	}
}
