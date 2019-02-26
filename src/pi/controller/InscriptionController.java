/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pi.entities.User;
import pi.service.UserService;

/**
 * FXML Controller class
 *
 * @author Hrissa
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfLastname;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfTell;
    @FXML
    private TextField tfProf;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnAnnuler;
    @FXML
    private DatePicker tfBithdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnAjouter.setOnAction((ActionEvent event) -> {
            Stage stage= new Stage();
        Parent root = null;
            UserService us = new UserService();       
            try {
                
                        LocalDate x = tfBithdate.getValue();
        java.sql.Date dat = java.sql.Date.valueOf(x);
        
        
                
                User u= new User();
                
                u.setUsername(tfUsername.getText());
                u.setBirthdate(dat.toString());
                u.setEmail(tfEmail.getText());
                u.setLastname(tfLastname.getText());
                u.setName(tfName.getText());
                u.setPassword(tfPassword.getText());
                u.setProfile_pic(tfProf.getText());
                u.setTel(tfTell.getText());
                
                
          us.addUser(u);
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
               
            } catch (IOException ex) {
                Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    //String name, String lastname, String birthdate, String adress, String tel, String email, String profile_pic, String password, String username

    @FXML
    private void annuler(ActionEvent event) {
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

    @FXML
    private void forgotClicked(MouseEvent event) {
    }
    }

