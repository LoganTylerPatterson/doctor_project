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
	
	public static void main(String[] args) {
			launch(args);
	}
}
