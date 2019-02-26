/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.utils;

import pi.entities.User;
import pi.service.LoginService;
import pi.service.UserService;

/**
 *
 * @author Hrissa
 */
public class Controller {
    private static int userId;

    UserService us = new UserService();
    public static void setUserId(int id)
    {
        if(id == 0) return ;
        Controller.userId = id ;
    }
    public static int getUserId()
    {
        return Controller.userId;
    }
    
    public User getUser()
    {
        return us.getUserById(userId);
    }
    
}
