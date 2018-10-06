package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.ResourceBundle;

import dao.HomeDAO;
import entity.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import uteis.Sessao;

public class HomeController implements Initializable{

	@FXML
	public TableView tableView;
	@FXML
	public TableView backlogTableView;

	public static void start(){
			if(Sessao.getInstance().isUsuarioLogado()){
				try{
					Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("Home.fxml")));
					Stage stage = new Stage();
					stage.setTitle("Leviathan");
					stage.setScene(new Scene(root));
					stage.show();
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				System.out.println("Usuário não está logado");
				LoginController.start();
			}

	}
	@Override
	public void initialize(URL location, ResourceBundle resources){
		HomeDAO dao = new HomeDAO();
		try {
			backlogTableView.setItems(FXCollections.observableArrayList(dao.buscaTarefa("Backlog")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public void logoutClick(MouseEvent mouseEvent) {
        Sessao.getInstance().removeCurrentUser();
        LoginController.start();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }

    public void helpClick(MouseEvent mouseEvent){

    }

    public void newTaskClick(MouseEvent mouseEvent){
    	NewTaskController.start();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
    	primaryStage.hide();
    }

}
