package controller;

import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import uteis.Sessao;

public class HomeController {
	public static void start(){
			if(Sessao.getInstance().isUsuarioLogado()){
				try{
					Parent root = FXMLLoader.load(Objects.requireNonNull(HomeController.class.getClassLoader().getResource("Home.fxml")));
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



    public void logoutClick(MouseEvent mouseEvent) {
        Sessao.getInstance().removeCurrentUser();
        LoginController.start();
        Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
    }

}
