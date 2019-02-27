/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;


import APIs.UploadAPI;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    @FXML
    private void ajouterPhotoAction(ActionEvent event) throws IOException {
        File file = saveFileChooser.showOpenDialog(null);
        String nameF = "";
        try {
            //-------
            nameF = UploadAPI.upload(file);
        } catch (Exception ex) {
        }
    }
    
    
    
    
    
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
                String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
                Pattern pattern = Pattern.compile(regex);
                
                Matcher matcher = pattern.matcher(tfEmail.getText());
                //System.out.println(email +" : "+ matcher.matches());
                if(!matcher.matches()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong Email format");
                alert.setHeaderText("please use a proper email");
                

                alert.showAndWait();
                    System.out.println("Wrong mail");
                    return;
                }
                
                
               u.setEmail(tfEmail.getText());
                u.setLastname(tfLastname.getText());
                u.setName(tfName.getText());
                String rege = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";
                 Pattern patter = Pattern.compile(rege);
                 Matcher matche = patter.matcher(tfPassword.getText());
                 if(!matche.matches()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("wrong password formation");
                alert.setHeaderText("password must but 6 to 16 characters");
                

                alert.showAndWait();
                    return;
                }
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

