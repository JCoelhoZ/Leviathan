package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import dao.LoginComponent;
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

public class LoginController implements Initializable {


	@FXML
	private TextField emailField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button loginButton;

	private LoginComponent component;


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

	@Override
    public void initialize(URL location, ResourceBundle resources) {
        component = new LoginComponent();
    }

	public void loginClick(MouseEvent mouseEvent){
		try{
			component.realizarLogin(emailField.getText(), passwordField.getText());
			HomeController.start();
			Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            primaryStage.hide();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

//	public void registerClick(MouseEvent mouseEvent){
//		 try {
//	            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("Register.fxml")));
//	            Parent root = loader.load();
//	            RegisterController controller = loader.getController();
//	            Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//	            controller.setPreviousScene(primaryStage.getScene());
//	            primaryStage.setScene(new Scene(root));
//
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	}
}
