package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import dao.HomeDAO;
import dao.TaskDAO;
import entity.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import uteis.Sessao;
import uteis.TaskAdapter;
import uteis.TaskViewer;

public class HomeController implements Initializable{

	@FXML
	public TableView<TaskViewer> backlogTableView;
	@FXML
	public TableColumn<Task, String> coltarefa;
	@FXML
	public TableColumn<Task,Date> coldata;

	@Override
	public void initialize(URL location, ResourceBundle resources){
		HomeDAO dao = new HomeDAO();
		TaskAdapter adaptaTask = new TaskAdapter();
		backlogTableView.setItems(FXCollections.observableArrayList(adaptaTask.adaptarTodosParaView(dao.buscaTarefa("Backlog"))));


		TableColumn colunaNome = (TableColumn) backlogTableView.getColumns().get(0);
        colunaNome.setCellValueFactory(new PropertyValueFactory<TaskViewer, String>("nometarefa"));

	}

	public static void start(){
			if(Sessao.getInstance().isUsuarioLogado()){
				try{
					Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getResource("Home.fxml")));
					Stage stage = new Stage();
					stage.setTitle("Leviathan");
					stage.setScene(new Scene(root));
				    stage.setResizable(false);
					stage.show();
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				System.out.println("Usuário não está logado");
				LoginController.start();
			}
	}

    public void logoutClick(MouseEvent mouseEvent) {
        Sessao.getInstance().removeCurrentUser();
        LoginController.start();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }

    public void helpClick(MouseEvent mouseEvent){
    	//implementação futura
    }

    public void newTaskClick(MouseEvent mouseEvent){
    	NewTaskController.start();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
    	primaryStage.hide();
    }

}
