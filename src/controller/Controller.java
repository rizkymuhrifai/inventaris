/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.MysqlCon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.AdminFakultas;
import model.Barang;
import model.DepartemenInventaris;
import model.DepartemenKeuangan;
import model.KategoriBarang;
import model.Pemeliharaan;
import model.Tanah;
import model.Tempat;
import model.User;
import view.LoginView;
import view.MenuKelolaBarangView;
import view.MenuUtamaView;
import view.View;

/**
 *
 * @author apple
 */
public class Controller implements ActionListener{

    private View v;
    private ArrayList<Barang> listBarang;
    private ArrayList<Tanah> listTanah;
    private ArrayList<DepartemenInventaris> listDI;
    private ArrayList<AdminFakultas> listAdmin;
    private ArrayList<DepartemenKeuangan> listDK;
    private ArrayList<KategoriBarang> listKategoriBarang;
    private ArrayList<Tempat> listTempat;
    private ArrayList<Pemeliharaan> listPemeliharaan;
    private MysqlCon database;
   
    private User currentUser;
    

    public Controller() {
        currentUser = null;
        listAdmin = new ArrayList<>();
        //listDI = new ArrayList<>();
        listDK = new ArrayList<>();
        listBarang = new ArrayList<>();
        listAdmin.add(new AdminFakultas("rmk", "rmk", "rmk"));
        listDK.add(new DepartemenKeuangan("rmk", "rmk", "rmk"));
        
        database = new MysqlCon();
        listDI = database.selectDataUserDI();
        listPemeliharaan  = database.selectDataPemeliharaan();
        listKategoriBarang = database.selectDataKategoriBarang();
        listTempat = database.selectDataTempat();
        listBarang = database.selectDataBarang(listKategoriBarang, listTempat, listPemeliharaan);
      
        
        toLoginMenu();
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent en) {
        Object e = en.getSource();
        if(v instanceof LoginView){
            LoginView l = (LoginView) v;
            
            if(e.equals(l.getBtnLogin())){
                validateForm(l);
                if(currentUser!=null){
                    l.showMessage("Anda Berhasil Login");
                    l.setVisible(false);
                    l.dispose();
                    toMenuUtama(currentUser);
                    
                }
                else{
                    l.showMessage("Username dan Password Tidak Cocok");
                }
            }
            
        }
        else if(v instanceof MenuUtamaView){
            MenuUtamaView l = (MenuUtamaView) v;
            if(e.equals(l.getBtnLogout())){
                l.setVisible(false);
                l.dispose();
                currentUser = null;
                toLoginMenu();
            }
            else if(e.equals(l.getBtnKeBarang())){
                l.setVisible(false);
                l.dispose();
                toMenuKelolaBarang();
            }
        }
        else if(v instanceof MenuKelolaBarangView){
            MenuKelolaBarangView l = (MenuKelolaBarangView) v;
            if(e.equals(l.getBtnKembali())){
                l.setVisible(false);
                l.dispose();
                toMenuUtama(currentUser);
            }
            
        }
    }
    
    private void toLoginMenu(){
        
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        loginView.AddListener(this);
        v = loginView;
        
    }
    
    private void toMenuUtama(User user){
            
        MenuUtamaView menuUtamaView = new MenuUtamaView();
        if(user instanceof DepartemenInventaris){
            menuUtamaView.getBtnKePengguna().setEnabled(false);
            menuUtamaView.getBtnkeLaporan().setEnabled(false);
            menuUtamaView.getBtnkeLaporan().setVisible(false);
            menuUtamaView.getBtnKePengguna().setVisible(false);
        }
        else if(user instanceof DepartemenKeuangan){    
            menuUtamaView.getBtnKePengguna().setEnabled(false);
            menuUtamaView.getBtnKeBarang().setEnabled(false);
            menuUtamaView.getBtnKeMutasi().setEnabled(false);
            menuUtamaView.getBtnKeTanah().setEnabled(false);
            
            menuUtamaView.getBtnKePengguna().setVisible(false);
            menuUtamaView.getBtnKeBarang().setVisible(false);
            menuUtamaView.getBtnKeTanah().setVisible(false);
            menuUtamaView.getBtnKeMutasi().setVisible(false);
            
        }
            menuUtamaView.setVisible(true);
            menuUtamaView.AddListener(this);
            v = menuUtamaView;      
    }
    
    private void toMenuKelolaBarang(){
        MenuKelolaBarangView menuKelolaBarangView = new MenuKelolaBarangView();
        menuKelolaBarangView.fillData(listBarang);
        menuKelolaBarangView.setVisible(true);
        menuKelolaBarangView.AddListener(this);
        v = menuKelolaBarangView;
    }
    
    private void validateForm(LoginView v){
        
        String username,password;
        username = v.getTfUsername().getText();
        password = v.getTfPassword().getText();
        
        if(username.isEmpty()||password.isEmpty()){
            currentUser = null;
        }
        else{
        
            if(v.getrAdmin().isSelected()){
                currentUser  = searchUserAdminFakultas(username, password);
            }
            else if(v.getrDI().isSelected()){
                currentUser = searchDI(username, password);
            }
            else if(v.getrDK().isSelected()){
                currentUser = searchUserDK(username, password);
            }
            
            else{
                currentUser = null;
            }
        }
        
    }
    
    private AdminFakultas searchUserAdminFakultas(String username , String password){
       for(AdminFakultas f: listAdmin){
           if(f.getUsername().equals(username)&&f.getPassword().equals(password)){
               return f;
           }
       }
       return null;
    }
    
    private DepartemenInventaris searchDI(String username , String password){
       for(DepartemenInventaris f: listDI){
           if(f.getUsername().equals(username)&&f.getPassword().equals(password)){
               return f;
           }
       }
       return null;
    }
    
    private DepartemenKeuangan searchUserDK(String username , String password){
       for(DepartemenKeuangan f: listDK){
           if(f.getUsername().equals(username)&&f.getPassword().equals(password)){
               return f;
           }
       }
       return null;
    }
    
}
