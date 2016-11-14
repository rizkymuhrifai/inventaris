/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;
import view.View;

/**
 *
 * @author apple
 */
public class Controller implements ActionListener{

    private View v;

    public Controller() {
        toLoginMenu();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent en) {
        Object e = en.getSource();
        if(v instanceof LoginView){
            LoginView l = (LoginView) v;
            
            if(e.equals(l.getBtnLogin())){
                if(validateForm()){
                    
                    l.showMessage("Anda Berhasil Login");
                }
                else{
                    l.showMessage("Username dan Password Tidak Cocok");
                }
            }
            
        }
        else if(true){
        
        }
    }
    
    private void toLoginMenu(){
        
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        loginView.AddListener(this);
        v = loginView;
        
    }
    
    private boolean validateForm(){
        return true;
    }
    
}
