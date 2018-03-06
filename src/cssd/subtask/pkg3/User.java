/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

/**
 *
 * @author b4041317
 */
public class User {
    String username;
    String password;
    int id;
           
    public User(int ident, String name, String pass)
    {
        id = ident;
        username = name;
        password = pass;
    }
    int getId() {
        return id;
    }
    boolean logIn(String name, String pass)
    {
        if (username.equals(name)&&password.equals(pass))
            return true;
        else return false;
    }
    void view()
    {
        
    }
}
