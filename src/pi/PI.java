/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Hrissa
 */
public class PI extends Application {
    
    @Override
   public void start(Stage stage) throws Exception{
        
       //Parent root = FXMLLoader.load(getClass().getResource("view/inscription.fxml"));
     // Parent root = FXMLLoader.load(getClass().getResource("view/Ajoutquestion.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("view/profile.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("view/Home.fxml"));
       //Parent root = FXMLLoader.load(getClass().getResource("view/Item.fxml"));
       Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("view/Listquestion.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        /*primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
       */
    }
        
      
        
      
  
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
