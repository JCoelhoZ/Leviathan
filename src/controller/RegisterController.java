package controller;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import dao.RegisterComponent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterController implements Initializable{

	@FXML
	private TextField emailField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField passwordconfirmField;
	@FXML
	private Button registerButton;

	private RegisterComponent component;

	public static void start(){
		try{
			Parent root = FXMLLoader.load(Objects.requireNonNull(RegisterController.class.getClassLoader().getResource("Register.fxml")));
			Stage stage = new Stage();
			stage.setTitle("Leviathan");
			stage.setScene(new Scene(root));
			stage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources){
		component = new RegisterComponent();
	}

	public void registerClick(MouseEvent mouseEvent){
		try{
			component.realizarRegistro(emailField.getText(), passwordField.getText(), passwordconfirmField.getText());
			LoginController.start();
			Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            primaryStage.hide();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void backClick(MouseEvent mouseEvent){
		LoginController.start();
		Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();

	}

}
