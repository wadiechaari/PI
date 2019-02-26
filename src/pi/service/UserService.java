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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.entities.User;
import pi.utils.MyConnection;

/**
 *
 * @author Hrissa
 */
public class UserService {
    private Statement ste;
    
    Connection cn = MyConnection.getInstance().getConnection();
    MyConnection cnx = MyConnection.getInstance();
    
    public void addUser(User user) throws IOException {
        try {
           // String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            java.util.Date date_util = new java.util.Date();
            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
            String requete
                    = "INSERT INTO user (name, lastname, birthdate, tell, email, profile_pic, password, username) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setString(1, user.getName());
            st.setString(2, user.getLastname());
            st.setString(3, user.getBirthdate());
            
          
            
            st.setString(4,user.getTel());
            st.setString(5,user.getEmail().toLowerCase());
            st.setString(6, user.getProfile_pic());
         
            st.setString(7, user.getPassword());
            st.setString(8, user.getUsername());
            st.executeUpdate();
            System.out.println("User ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        
        
        
        
        //
    }
     public void deleteUser(User user) throws SQLException{
        String req="DELETE FROM User WHERE id=?";
        PreparedStatement ste = cn.prepareStatement(req);
        ste.setInt(1, user.getId());
        ste.executeUpdate();
    }
      public List<User> getAllUsers() {
        String req = "SELECT * FROM user where roles NOT LIKE '%ROLE_SUPER_ADMIN% '";
        List<User> users = new ArrayList<>();
        try {
            
            ResultSet rs = ste.executeQuery(req);            
            while (rs.next()){
                
                users.add(new User(String.valueOf(rs.getInt("id")), rs.getString("name"), rs.getString("lastname"), rs.getString("adress"), rs.getString("tell"), rs.getString("email"), rs.getString("profile_pic"), rs.getString("description"), rs.getString("type"), rs.getString("password"), rs.getString("username")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }
      
    
    public void modifierUser(User u) {
        try {
            String req = "update user set name=?, lastname=?, birthdate=?, adress=?, profile_pic=?, description=?, type=?, passwprd=?, username=?, tell=?, id=? ";
            PreparedStatement pre = cn.prepareStatement(req);
            pre.setString(1, u.getName());
            pre.setString(2, u.getLastname());
            pre.setString(3, (String) u.getBirthdate());
            pre.setString(4, u.getAdress());
            pre.setString(5, u.getProfile_pic());
            pre.setString(6, u.getDescription());
            pre.setString(7, u.getPassword());
            pre.setString(8, u.getUsername());
            pre.setString(9, u.getTel());

            
            pre.setInt(10, u.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public User getUserById(int id) {
        try {
            String req = "select * from user where id=?";
            User u = null;
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               // int id, String name, String lastname, String birthdate, String adress, String tel, String email, String profile_pic, String description, String type, String password, String username) {
        
                u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("birthdate"), rs.getString("tel"), rs.getString("email"), rs.getString("type"), rs.getString("password"), rs.getString("username"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       public User getUserByUsername(String username, String email) {
        try {
            String req = "select * from user where username=? AND email=?";
            User u = null;
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, username);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                //u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getBoolean("enabled"), rs.getString("salt"), rs.getDate("last_Login"), rs.getString("roles"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date_Naissance"), rs.getString("genre"), rs.getString("pays"), rs.getString("region"), rs.getString("ville"), rs.getString("tel"), rs.getString("place_Naiss"), rs.getString("religion"), rs.getString("apropos"), rs.getString("facebook"), rs.getString("twitter"), rs.getString("instagram"), rs.getString("image"), rs.getDate("updated_At"), rs.getString("occupation"));
               u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("birthdate"), rs.getString("tel"), rs.getString("email"), rs.getString("type"), rs.getString("password"), rs.getString("username"));
           
                u = new User();
                u.setEmail(rs.getString("email"));
                u.setUsername(rs.getString("username"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
