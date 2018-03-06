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
public class Admin extends User {
    boolean RootAdmin;
    public Admin(int ident, String name, String password, boolean Root) {
         super(ident, name, password);
    }
    
    void AcknowledgeAlert()
    {
        
    }
}
