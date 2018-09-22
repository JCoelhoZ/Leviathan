package controller;

import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField emailField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button loginButton;

	public static void start(){
		try{
			Parent root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getClassLoader().getResource("Login.fxml")));
			Stage stage = new Stage();
			stage.setTitle("Leviathan");
			stage.setScene(new Scene(root));
			stage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
