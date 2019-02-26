/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pi.entities.Question;
import pi.entities.Reponse;
import pi.utils.MyConnection;

/**
 *
 * @author Hrissa
 */
public class QaService {
    private Statement ste;
    
    Connection cn = MyConnection.getInstance().getConnection();
    MyConnection cnx = MyConnection.getInstance();
    
     public void addQuestion(Question q) throws IOException {
        try {
           // String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            java.util.Date date_util = new java.util.Date();
            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
            String requete
                    = "INSERT INTO `q&a` (question,id_user,type) VALUES (?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setString(1, q.getQuestion());
          st.setInt(2, q.getId_user());
          st.setString(3,q.getType());
            st.executeUpdate();
            System.out.println("Question ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        
}
     
         public void addReponse(Reponse r,int id_question,int id_user) throws IOException {
        try {
           // String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            java.util.Date date_util = new java.util.Date();
            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
            String requete
                    = "INSERT INTO reponse (id_user,id_q,reponse) VALUES (?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setInt(1, r.getId_user());
            st.setInt(2, r.getId_q());
            st.setString(3, r.getReponse());
          
            st.executeUpdate();
            System.out.println("Question ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        
} 
         
         public ResultSet comptreponse(int id_q) throws SQLException{
             
             String requete
                     ="SELECT COUNT (*) FROM reponse WHERE id_q=?";
                     PreparedStatement st = cn.prepareStatement(requete);
                    st.setInt(1, id_q);
                    st.executeQuery();
                    ResultSet nbr=st.executeQuery();
                    return nbr;
             
         }
         
         
         public ArrayList<Question> getQuestions() throws SQLException{
          ArrayList<Question> questions = new ArrayList<>();
            String requete="SELECT * FROM `q&a` ";
                     PreparedStatement st = cn.prepareStatement(requete);
                   ResultSet rs= st.executeQuery();
                       while (rs.next()) {
               Question q = new Question();
               q.setId(rs.getInt("id"));
               q.setId_user(rs.getInt("id_user"));
               q.setQuestion(rs.getString("question"));
               q.setType(rs.getString("type"));
               questions.add(q);
                       }
        
             
          
          
          return questions;
         }
         
         
     
     
}