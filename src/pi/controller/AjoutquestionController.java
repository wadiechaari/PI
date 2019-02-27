/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pi.entities.Question;
import pi.entities.User;
import pi.service.QaService;
import pi.service.UserService;
import pi.utils.Controller;

/**
 * FXML Controller class
 *
 * @author Hrissa
 */
public class AjoutquestionController implements Initializable {

    
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnAnnuler;
    @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfQuestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnAjouter.setOnAction((ActionEvent event) -> {
            QaService qs = null;
             qs = new QaService();       
            try {
                Question question = new Question();
                question.setQuestion(tfQuestion.getText());
                question.setType(tfSujet.getText());
                question.setId_user(Controller.getUserId());
              
                qs.addQuestion(question);
            } catch (IOException ex) {
                Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }    
    
}
