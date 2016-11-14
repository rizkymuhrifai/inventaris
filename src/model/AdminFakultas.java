/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author apple
 */
public class AdminFakultas extends User{
    
    private long idAdmin;
    
    public AdminFakultas(String username, String password, String nama) {
        super(username, password, nama);
    }

    public AdminFakultas(long idAdmin, String username, String password, String nama) {
        super(username, password, nama);
        this.idAdmin = idAdmin;
    }
    
    

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    
    
    
    
    
    
}
