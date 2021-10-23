package application.controllers;

import application.JsonUtil;
import application.Main;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Objects;

import application.model.Patient;

public class LoginController {
	@FXML
	public Text tUsername;
	@FXML
	public Text tPassword;
	@FXML 
	public TextField tfUsername;
	@FXML
	public TextField tfPassword;

	private JsonUtil util;

	public void initialize(){
		util = new JsonUtil();
	}

	public void loginUser(ActionEvent e) {
		String username = tfUsername.getText();
		String password = tfPassword.getText();
		//Get user type
//		String type = getUserType(username);
//		if(type == ""){
//			//User is not registered, give them an error and have them try again
//			System.out.println("User is not registered");
//		}else{
//			//ValidatePassword
//			boolean allGood = validatePassword(username, password, type);
//			if(allGood){
//				//Get next scene destination based on user type
//				String destinationfxml = getUserDestination(type);
//				//Switch to scene
//				switchToScene(e, destinationfxml);
//			}else{
//				System.out.println("Invalid Password");
//			}
//		}
		switchToScene(e, "doctor_evaluation.fxml");
	}

	private boolean validatePassword(String username, String password, String type){
		boolean validated = false;
		switch (type) {
			case ("doctor"): {
				break;
			}
			case ("nurse"): {
				break;
			}
			case ("patient"):{
				Patient patient = util.getPatientObjFromJson(username);
				if(Objects.equals(patient.getPassword(), password)){
					validated = true;
				}
				break;
			}
			default: {
				System.out.println("Error validating the password");
				break;
			}
		}
		//Nurse nurse = util.getNurseObjFromJson(username);
		return true;
	}

	private String getUserDestination(String type){
		String destination = "";

		switch (type) {
			case ("doctor"): {
				destination = "patient_registration.fxml";
				break;
			}
			case ("nurse"): {
				destination = "patient_registration.fxml";
				break;
			}
			case ("patient"): {
				destination = "patient_registration.fxml";
				break;
			}
			default: {
				System.out.println("User is not registerd with the system");
				destination = "patient_registration.fxml";
				break;
			}
		}
		return destination;
	}

	private String getUserType(String username){
		String type = "";
		ArrayList<String> doctorNames = util.getDoctorNames();
		ArrayList<String> nurseNames = util.getNurseNames();
		ArrayList<String> patientNames = util.getPatientNames();
		//check if present in any of the arrays
		for(int i = 0; i < doctorNames.size() - 1; i++){
			if (Objects.equals(doctorNames.get(i), username)){
				type = "doctor";
				break;
			}
		}
		for(int i = 0; i < nurseNames.size() - 1; i++){
			if (Objects.equals(nurseNames.get(i), username)){
				type = "nurse";
				break;
			}
		}
		for(int i = 0; i < patientNames.size() - 1; i++){
			if (Objects.equals(patientNames.get(i), username)){
				type = "patient";
				break;
			}
		}
		return type;
	}

	//Needs to be changed to accept a type to switch to the correct scene
	public void switchToScene(ActionEvent e, String fxmlName){
		Main main = new Main();
		main.switchToSceneX(e, fxmlName);
	}
	
	public void registerUser(ActionEvent e) {
		System.out.println("Register the User");
	}
}
