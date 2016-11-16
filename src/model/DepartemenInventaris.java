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
public class DepartemenInventaris extends User {
    
    private long idDI;
    
    
    public DepartemenInventaris(String username, String password, String nama) {
        super(username, password, nama);
    }

    public DepartemenInventaris(String username, String password, String nama,long idDI) {
        super(username, password, nama);
        this.idDI = idDI;
    }

    public long getIdDI() {
        return idDI;
    }

    public void setIdDI(long idDI) {
        this.idDI = idDI;
    }
    
    
    
}
