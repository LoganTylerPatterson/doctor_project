package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class Main extends Application {
	//Note to know this is the good one

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

	public void switchToSceneX(ActionEvent event, String fxmlName){
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
			stage.show();
		} catch(IOException e) {
			System.out.println("Could not transfer to scene " + fxmlName);
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
//ArrayList<Long> visits= new ArrayList<Long>();
//ArrayList<Medication> medications = new ArrayList<Medication>();
//medications.add(new Medication("Advil", 500, "mg"));
//Insurance insurance = new Insurance("Logan Patterson", "Blue Cross Blue Shield", 92929292L,"1345 N Jefferson Phoenix AZ 849383" );
//Pharmacy pharmacy = new Pharmacy("CVS", "502 S Address here AZ ######", "9483838383");
//visits.add(232323232323l);
//long dob = 9080238028932l;
//String phoneNumber = "9283928392";
//String address = "1345 N Jefferson Phoenix AZ 849383";
//Patient test = new Patient("Logan", "Patterson", 84848348383l,"9493939292","1350 S Higley Mesa AZ 85306", visits, medications, insurance, pharmacy);
//
//util.writePatientToJsonFile(test, "test");
