/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.sql.DataSource;
import pi.entities.User;
import pi.service.LoginService;
import pi.utils.Controller;
import pi.utils.MyConnection;
import utils.BCrypt;

/**
 * FXML Controller class
 *
 * @author Hrissa
 */
public class LoginController extends Controller implements Initializable {
    
    private Statement ste;
    ResultSet rs;
    Connection cn = MyConnection.getInstance().getConnection();
    int x;

    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button tfSubscribe;
    @FXML
    private Button tfLog;
    @FXML
    private Label tfForgotPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  /*  @FXML
    private void Login(ActionEvent event) throws SQLException, IOException {
        LoginService ls = new LoginService();
        
        User user = new User();
        user.setUsername(tfUsername.getText());
        user.setPassword(tfPassword.getText());
        ls.LoginAction(user);
        //------------------
        String req= "Select id from user where username=? ";
        PreparedStatement prs= cn.prepareStatement(req);
        prs.setString(1, tfUsername.getText());
        ResultSet res= prs.executeQuery();
        while (res.next()){
         x= res.getInt("id");       
        }
        User userx = new User();
        userx.setId(x);
        Controller.setUserId(x);
        //------------------
        Stage stage= new Stage();
        Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
         Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));  
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    }
  */
        @FXML
    private void Login(ActionEvent event) throws SQLException {
        LoginService ls = new LoginService();
        
        User user = new User();
        user.setUsername(tfUsername.getText());
        user.setPassword(tfPassword.getText());
        ls.LoginAction(user);
        Stage stage= new Stage();
        if("admin".equals(tfUsername.getText()) && "admin".equals(tfPassword.getText()))
        {
            Parent root = null;   
            try {
                root = FXMLLoader.load(getClass().getResource("../View_Admin/UI.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(root == null) return ;
            Scene scene = new Scene(root);
             Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
     
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            return;
        }
        
        String req= "Select * from user where username=?";
        PreparedStatement prs= cn.prepareStatement(req);
        prs.setString(1, tfUsername.getText());
        ResultSet rs = prs.executeQuery();
        if (!rs.next()){
            //msg.setText("Username incorrect");
        } 
        else {
          //  if(BCrypt.checkpw(tfPassword.getText(),rs.getString("password").substring(0,2)+"a"+rs.getString("password").substring(3)))
               if(rs.getString("password").equals(tfPassword.getText()) && rs.getString("username").equals(tfUsername.getText())) 
            {
                String req1= "Select id from user where username=? ";
                PreparedStatement prs1= cn.prepareStatement(req1);
                prs.setString(1, tfUsername.getText());
                ResultSet res= prs.executeQuery();
                while (res.next()){
                 x= res.getInt("id");       
                }
                //User user= new User();
                user.setId(x);
                Controller.setUserId(x);
                //init();
                  
                Parent root = null;        
                   try {
                       FXMLLoader loader = new FXMLLoader(getClass().getResource("/pi/view/home.fxml"));
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
            else
            {
                //msg.setText("Mot de passe incorrecte!");
            }
        }     
   }

    @FXML
    private void insc(ActionEvent event) {
        Stage stage= new Stage();
        Parent root = null;
        try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/pi/view/inscription.fxml"));
        
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
         Stage stage= new Stage();
        Parent root = null;
        try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/pi/view/ForgotPassword.fxml"));
        
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
