package controller;

//import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

//	private static Stage stage;
//
//	private static Scene loginScene;
//	private static Scene registerScene;
//	private static Scene homeScene;
//	private static Scene newTaskScene;

	@Override
    public void start(Stage primaryStage) throws Exception{

		Parent screen = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Scene scene = new Scene(screen);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Leviathan");
	    primaryStage.setResizable(false);
	    primaryStage.show();


		/*stage = primaryStage;
    	primaryStage.setTitle("Leviathan");

    	Parent fxmlLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	loginScene = new Scene(fxmlLogin);

    	Parent fxmlRegister = FXMLLoader.load(getClass().getResource("Register.fxml"));
    	registerScene = new Scene(fxmlRegister);

    	Parent fxmlHome = FXMLLoader.load(getClass().getResource("Home.fxml"));
    	homeScene = new Scene(fxmlHome);

    	Parent fxmlnewTask = FXMLLoader.load(getClass().getResource("newTask.fxml"));
    	newTaskScene = new Scene(fxmlnewTask);

    	primaryStage.setScene(loginScene);
    	primaryStage.show();
    	primaryStage.setResizable(false);

    	public static void changeScreen(String scr){
            switch (scr){
                case "login":
                    stage.setScene(loginScene);
                    break;
                case "register":
                    stage.setScene(registerScene);
                    break;
                case "home":
                    stage.setScene(homeScene);
                    break;
                case "newTask":
                	stage.setScene(newTaskScene);
                	break;
            }
    	}*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
