/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Barang;
import model.DepartemenInventaris;
import model.KategoriBarang;
import model.Pemeliharaan;
import model.Tempat;

/**
 *
 * @author ASUS
 */
public class MysqlCon {
    
    private Connection con;
    public void createConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/inventaris";
            String hostname = "root";
            String password = "yu";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,hostname,password);
            
            
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            Logger.getLogger(MysqlCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<DepartemenInventaris> selectDataUserDI(){
        
        ArrayList<DepartemenInventaris> lisDI = new ArrayList<>();
        Statement stmt;
        try {
            createConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from departemeninventaris");
            while(rs.next()){
                lisDI.add(new DepartemenInventaris(rs.getString("Username"), 
                        rs.getString("password"), rs.getString("nama"),rs.getLong("idDI")));
            }
            con.close();
            return lisDI;
        } catch (SQLException ex) {
            return null;
        } 
        
    }
    
    public ArrayList<KategoriBarang> selectDataKategoriBarang(){
        ArrayList<KategoriBarang> listKategoriBarang = new ArrayList<>();
        Statement st;
        try{
            createConnection();
            st = con.createStatement();
            String query = "select * from kategoribarang";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                listKategoriBarang.add(new KategoriBarang(rs.getString("namaKategori")));
            }
        }
        catch(SQLException ex){
            return null;
        }
        return listKategoriBarang;
    }
    
    public ArrayList<Tempat> selectDataTempat(){
          ArrayList<Tempat> listtempat = new ArrayList<>();
        Statement st;
        try{
            createConnection();
            st = con.createStatement();
            String query = "select * from tempat";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                listtempat.add(new Tempat(rs.getString("namaTempat")));
            }
        }
        catch(SQLException ex){
            return null;
        }
        return listtempat;
    }
    
    public ArrayList<Pemeliharaan> selectDataPemeliharaan(){
        ArrayList<Pemeliharaan> listPemeliharaan = new ArrayList<>();
           Statement st;
        try{
            createConnection();
            st = con.createStatement();
            String query = "select * from pemeliharaan";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                listPemeliharaan.add(new Pemeliharaan(rs.getString("namaPemeliharaan"), rs.getDouble("biaya")));
            }
        }
        catch(SQLException ex){
            return null;
        }
        return listPemeliharaan;
        
    }
    
    public ArrayList<Barang> selectDataBarang(ArrayList<KategoriBarang> kategori, ArrayList<Tempat> tempat
            , ArrayList<Pemeliharaan> pemeliharaan){
        
        ArrayList<Barang> listBarang = new ArrayList<>();
        Statement stmt;
        try {
            createConnection();
            stmt = con.createStatement();
            String query = "select * from Barang,datapemeliharaan,pemeliharaan,kategoriBarang " +
                    "where barang.idBarang = datapemeliharaan.idbarang " +
                    " and pemeliharaan.namaPemeliharaan = datapemeliharaan.nama";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String pem = rs.getString("namaPemeliharaan");
                String kategoriBarang = rs.getString("Kategori");
                System.out.println("Success until Here");
                String lokasi = rs.getString("lokasi");
                System.out.println(pem + kategoriBarang + lokasi);
                int idxKB = 0;
                int idxTempat = 0;
                int idxPemeliharaan = 0;
                int i =0;
                
                for(KategoriBarang kb: kategori){
                    if(kb.getName().equals(kategoriBarang)){
                        idxKB = i;
                        break;
                    }
                    i++;
                }
                
               
                i = 0;
                
                for(Tempat t: tempat){
                    if(t.getNama().equals(lokasi)){
                        idxTempat = i;
                        break;
                    }
                    i++;
                }
                
                i = 0;
                for(Pemeliharaan p : pemeliharaan){
                    if(p.getJenis().equals(pem)){
                        idxPemeliharaan = i;
                        break;
                    }
                    i++;
                }
                
                long idBarang =  rs.getLong("idBarang");
                String nama = rs.getString("namabarang");
                double harga = rs.getDouble("hargabarang");
                listBarang.add(new Barang(idBarang, nama, harga, kategori.get(idxKB) 
                        , tempat.get(idxTempat), pemeliharaan.get(idxPemeliharaan)));   
            }
            con.close();
            return listBarang;
        } catch (SQLException ex) {
            return null;
        } 
        
        
    }
    
}
