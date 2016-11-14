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
public class DepartemenKeuangan extends User{
    
    private long idDK;
    public DepartemenKeuangan(String username, String password, String nama) {
        super(username, password, nama);
    }

    public DepartemenKeuangan(long idDK, String username, String password, String nama) {
        super(username, password, nama);
        this.idDK = idDK;
    }

    public long getIdDK() {
        return idDK;
    }

    public void setIdDK(long idDK) {
        this.idDK = idDK;
    }
    
    
    
    
}
