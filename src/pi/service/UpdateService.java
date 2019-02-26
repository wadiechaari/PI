/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.entities.User;
import pi.utils.MyConnection;

/**
 *
 * @author Hrissa
 */
public class UpdateService {
    
    Connection cn = MyConnection.getInstance().getConnection();
    MyConnection cnx = MyConnection.getInstance();
    
    
    public void modifierUser(User u) {
        try {
            String req = "update user set password=? where username=? AND email=? ";
            PreparedStatement pre = cn.prepareStatement(req);
            pre.setString(1, u.getPassword()); 
            pre.setString(2, u.getUsername());
            pre.setString(3, u.getEmail());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
