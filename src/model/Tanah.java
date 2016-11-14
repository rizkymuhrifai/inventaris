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
public class Tanah {
    private long idTanah;
    private String lokasi;
    private double luas;
    private KategoriTanah kategori;

    public Tanah(long idTanah, String lokasi, double luas, KategoriTanah kategori) {
        this.idTanah = idTanah;
        this.lokasi = lokasi;
        this.luas = luas;
        this.kategori = kategori;
    }

    public long getIdTanah() {
        return idTanah;
    }

    public void setIdTanah(long idTanah) {
        this.idTanah = idTanah;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public double getLuas() {
        return luas;
    }

    public void setLuas(double luas) {
        this.luas = luas;
    }

    public KategoriTanah getKategori() {
        return kategori;
    }

    public void setKategori(KategoriTanah kategori) {
        this.kategori = kategori;
    }
    
    
    
}
