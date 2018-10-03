package controller;

//import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Leviathan");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


//public class Main{
//public static void main(String[] args){
//File f = new File("resources/fxml/Login.fxml");
//if(f.exists()) {
//    System.out.println("File exists");
//    System.out.println(f.getAbsoluteFile());
//}
//else{
//	System.out.println("File not found");
//}
//}
//}
