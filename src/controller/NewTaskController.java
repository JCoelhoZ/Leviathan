package controller;

import java.net.URL;
import java.sql.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import dao.RegisterComponent;
import dao.TaskDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import uteis.Sessao;

public class NewTaskController implements Initializable {
	@FXML
	private TextArea tasknameField;
	@FXML
	private DatePicker finishDateField;
	@FXML
	private TextField categoryField;
	@FXML
	private Button doneButton;
	@FXML
	private Button cancelButton;

	private TaskDAO dao;

	public static void start(){
		try{
			Parent root = FXMLLoader.load(Objects.requireNonNull(RegisterController.class.getResource("NewTask.fxml")));
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
		dao = new TaskDAO();
	}

	public void leviathanClick(MouseEvent mouseEvent){
		HomeController.start();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
	}


	public void logoutClick(MouseEvent mouseEvent) {
        Sessao.getInstance().removeCurrentUser();
        LoginController.start();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }

    public void helpClick(MouseEvent mouseEvent){

    }

	public void doneClick(MouseEvent mouseEvent){
		try{
			dao.addTask(tasknameField.getText(), (Date.valueOf(finishDateField.getValue())), categoryField.getText());
			HomeController.start();
			Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
			primaryStage.hide();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void cancelClick(MouseEvent mouseEvent){
		HomeController.start();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
	}

}
