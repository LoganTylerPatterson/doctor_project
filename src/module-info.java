module doctor_project {
	requires javafx.controls;
	requires com.google.gson;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
	
	exports application to javafx.graphics, javafx.fxml, com.google.gson;
	exports application.model to com.google.gson;
	exports application.controllers to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml, com.google.gson;
	opens application.model to com.google.gson;
	opens application.controllers to javafx.fxml;
}
