/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import pi.entities.Question;
import pi.entities.User;
import pi.service.QaService;


/**
 * FXML Controller class
 *
 * @author Hrissa
 */
public class ListquestionController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private VBox vboxRow;
    @FXML
    private Label username;
    @FXML
    private Label question;
    @FXML
    private Label nbrep;
    @FXML
    private Label type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            QaService qaservice = new QaService();
          
            ArrayList<Question> quest = qaservice.getQuestions();
            for (Question q:quest){
                
                vboxRow.getChildren().add(hRowItem(q,quest.size()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListquestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public HBox hRowItem(Question u,int size){
        Font prefFont = new Font("System", 12);
        HBox hbox = new HBox();
        hbox.setPrefSize(1097, 38);
        hbox.setStyle("-fx-border-color: black;");
        
        Label usernameL = new Label(String.valueOf(u.getId_user()));
        usernameL.setFont(prefFont);
        HBox.setMargin(usernameL, new Insets(10, 0, 0, 5));
        
        Label nomL = new Label(u.getQuestion());
        nomL.setFont(prefFont);
        HBox.setMargin(nomL, new Insets(10, 0, 0, 150));
        
        Label prenomL = new Label(u.getQuestion());
        prenomL.setFont(prefFont);
        HBox.setMargin(prenomL, new Insets(10, 0, 0, 250));
        
        Label telL = new Label(u.getType());
        telL.setFont(prefFont);
        HBox.setMargin(telL, new Insets(10, 0, 0, 300));
        
        
        
        Label countl = new Label(String.valueOf(size));
        countl.setFont(prefFont);
        HBox.setMargin(countl, new Insets(10, 0, 0, 350));
        
    
        hbox.getChildren().addAll(usernameL,nomL,prenomL,telL,countl);
        
        
        return hbox;
    }

    }    
    

