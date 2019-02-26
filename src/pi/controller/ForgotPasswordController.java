/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pi.entities.User;
import pi.service.UpdateService;
import pi.service.UserService;

/**
 * FXML Controller class
 *
 * @author Hrissa
 */
public class ForgotPasswordController implements Initializable {

    UpdateService updateService;
    UserService userService;
    
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button tfConfirm;
    @FXML
    private Button Annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateService= new UpdateService();
        userService = new UserService();
    }    

    @FXML
    private void UpdatePassword(ActionEvent event) {
        
        if(tfUsername.getText().equals("")||tfEmail.getText().equals("")||tfPassword.getText().equals(""))
        {
            Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Alter Password");
                alert.setHeaderText("Remplire vos champs!!");
                

                alert.showAndWait();
            return;
        }
        
        
        User u = null;
          
            Stage stage= new Stage();
        Parent root = null;
            UserService us = new UserService();       
            u = userService.getUserByUsername(tfUsername.getText(), tfEmail.getText());
            if(u != null){
                u.setPassword(tfPassword.getText());
                updateService.modifierUser(u);
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Alter Password");
                alert.setHeaderText("Mot de Pass modifier");
                

                alert.showAndWait();
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Alter Password");
                alert.setHeaderText("Username ou Email invalide");
                

                alert.showAndWait();
            }
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/pi/view/Login.fxml"));
                
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            Node node =(Node)event.getSource();
            stage = (Stage)node.getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
       

    }    
        
        
        
         
    

    @FXML
    private void Retour(ActionEvent event) {
 Stage stage= new Stage();
        Parent root = null;
        try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/pi/view/Login.fxml"));
        
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Scene scene = new Scene(root);
                Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
     
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);
    }
    
}
