package application.controllers;

import application.JsonUtil;
import application.SceneUtil;
import application.model.*;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Objects;

public class LoginController {
	@FXML
	public Text tUsername;
	@FXML
	public Text tPassword;
	@FXML 
	public TextField tfUsername;
	@FXML
	public TextField tfPassword;

	private User user;

	private JsonUtil util;

	/**
	 * Called after the constructor, can be used to manipulate FXML widgets
	 * In this case just initializes the JSONUtil class
	 */
	public void initialize(){
		util = new JsonUtil();
	}

	/**
	 * Called when btnLogin is clicked, see @login.fxml, begins the process of validating the user
	 * and determining the correct destination
	 * @param e
	 */
	public void loginUser(ActionEvent e) {
		//Retrieve user input
		String username = tfUsername.getText();
		String password = tfPassword.getText();

		//Get user role
		String type = getUserType(username);

		if(Objects.equals(type, "")){
			//User is not registered, give them an error and have them try again
			System.out.println("User is not registered");
		}else{
			//ValidatePassword
			boolean allGood = validatePassword(username, password, type);
			if(allGood){
				//Get next scene
				String destinationfxml = getUserDestination(type);
				//Switch to scene
				if(Objects.equals(destinationfxml, "pick_patient.fxml")){
					switchToPickerScene(e, user);
				}else{
					//switchToPatientScene
				}
			}else{
				System.out.println("Invalid Password");
			}
		}
	}

	/**
	 * Given a username, it will retrieve that users object from the filesystem, then compare the user objects password with
	 * login password given, if successful, it will return true
	 * @param username username entered
	 * @param password password entered
	 * @param type type of user, doctor, patient, or nurse
	 * @return true, false depending whether or not password was correct
	 */
	private boolean validatePassword(String username, String password, String type){
		boolean validated = false;
		switch (type) {
			case ("patient"):{
				Patient patient = util.getPatientObjFromJson(username);
				user = patient;
				if(Objects.equals(patient.getPassword(), password)){
					validated = true;
				}
				break;
			}
			case ("doctor"): {
				Doctor doctor = util.getDoctorObjFromJson(username);
				user = doctor;
				if(Objects.equals(doctor.getPassword(), password)){
					validated = true;
				}
				break;
			}
			case ("nurse"): {
				Nurse nurse = util.getNurseObjFromJson(username);
				user = nurse;
				if(Objects.equals(nurse.getPassword(), password)){
					validated = true;
				}
				break;
			}

			default: {
				System.out.println("Error validating the password");
				break;
			}
		}
		return validated;
	}

	/**
	 * For doctors and nurses, it will take them to the pick_patient screen
	 * for patients, it will take them to their own patient portal, to edit information or schedule and appt
	 * @param type doctor, nurse, or patient strings
	 * @return fxml file name
	 */
	private String getUserDestination(String type){
		String destination = "";

		switch (type) {
			case ("doctor"): {}
			case ("nurse"): {
				destination = "pick_patient.fxml";
				break;
			}
			case ("patient"): {
				destination = "patient_portal.fxml";
				break;
			}
			default: {
				System.out.println("User is not registerd with the system");
				destination = "patient_portal.fxml";
				break;
			}
		}
		return destination;
	}

	/**
	 * Gets the different user types from the user_registration.fxml and if the username(email) is found within these lists
	 * it returns the type of user. For example, if in the doctor list there is a LoganPatterson@gmail.com, and i have passed that in as
	 * a username, it will return "doctor"
	 * @param username user input
	 * @return type of user, "nurse, doctor, or patient"
	 */
	private String getUserType(String username){
		UserRegistry registry = util.getUserRegistry();
		String type = "";
		ArrayList<String> doctorNames = registry.getDoctors();
		ArrayList<String> nurseNames = registry.getNurses();
		ArrayList<String> patientNames = registry.getPatients();

		//check if present in any of the arrays
		for(int i = 0; i <= doctorNames.size() - 1; i++){
			if (Objects.equals(doctorNames.get(i), username)){
				type = "doctor";
				break;
			}
		}
		for(int i = 0; i <= nurseNames.size() - 1; i++){
			if (Objects.equals(nurseNames.get(i), username)){
				type = "nurse";
				break;
			}
		}
		for(int i = 0; i <= patientNames.size() - 1; i++){
			if (Objects.equals(patientNames.get(i), username)){
				type = "patient";
				break;
			}
		}
		return type;
	}

	/**
	 *
	 * @param event Action event passed in from widget onClick Listener, see LoginUser()
	 * @param user user object that will be used to populate data in the destination scene
	 */
	public void switchToPickerScene(ActionEvent event, User user){
		SceneUtil switcher = new SceneUtil();
		switcher.switchToPickerScene(event, user);
	}

	/**
	 * Switch to the register user screen, no data required
	 * @param e
	 */
	public void registerUser(ActionEvent e) {
		SceneUtil switcher = new SceneUtil();
		switcher.switchToRegistrationScene(e);
	}
}
