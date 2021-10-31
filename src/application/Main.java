package application;
	
import application.controllers.PickPatientController;
import application.model.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class Main extends Application {
		public static Main instance;

		@Override
		public void start(Stage primaryStage) {
			try {
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/login.fxml"));
				 Parent root = loader.load();
				 Scene loginScene = new Scene(root);
				 primaryStage.setScene(loginScene);
				 primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * This function is used to switch to a specific Scene and pass along some user data with it
	 * @param event event passed in from an event listener like a Button
	 * @param fxmlName name of the file to be switched to, ie patient_registration.fxml
	 * @param user User object passed to the scene
	 */
	public void switchToSceneWithUser(ActionEvent event, String fxmlName, User user){
		Stage stage;
		Parent root;
		FXMLLoader loader;
		Scene scene;
		try{
			loader = new FXMLLoader(getClass().getResource("ui/" + fxmlName));
			root = loader.load();
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setUserData(user);
			stage.show();
		} catch(IOException e) {
			System.out.println("switchToSceneWithUser(): Could not transfer to scene " + fxmlName);
			e.printStackTrace();
		}
	}

	/**
	 * Switches to a scene without requiring user data to be set, called from other classes
	 * @param e actionEvent passed from FXML widget
	 */
	public void switchToPickerScene(ActionEvent e, User user){
		JsonUtil util = new JsonUtil();
		Stage stage;
		Parent root;
		FXMLLoader loader;
		Scene scene;
		try{
			loader = new FXMLLoader(getClass().getResource("ui/pick_patient.fxml"));
			root = loader.load();
			//Pass data to controller
			PickPatientController controller = loader.getController();
			controller.setUser(user);
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setUserData(user);
			stage.show();
		} catch(IOException ex) {
			System.out.println("switchToSceneWithUser(): Could not transfer to scene pick_patient.fxml");
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			launch(args);
	}
}
