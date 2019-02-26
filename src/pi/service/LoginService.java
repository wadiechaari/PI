/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pi.entities.User;
import pi.utils.MyConnection;

/**
 *
 * @author Hrissa
 */
public class LoginService {
    
     private Statement ste;
    ResultSet rs;
    Connection cn = MyConnection.getInstance().getConnection();
    MyConnection cnx = MyConnection.getInstance();
    
     public String LoginAction(User user) throws SQLException{
        String req= "Select * from user where username=? and password=?";
        PreparedStatement prs= cn.prepareStatement(req);
        prs.setString(1, user.getUsername());
        prs.setString(2, user.getPassword());
        rs = prs.executeQuery();
        return "good job u made it here";
    }
    
}
