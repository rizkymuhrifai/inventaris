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
public class Barang {
    private long idBarang;
    private String nama;
    private double harga;
    private Pemeliharaan status;
    private Tempat lokasi;
    private KategoriBarang kategoriBarang;

    public Barang(long idBarang, String nama, double harga,KategoriBarang k , Tempat lokasi, Pemeliharaan status) {
        this.idBarang = idBarang;
        this.nama = nama;
        this.harga = harga;
        this.kategoriBarang = k;
        this.lokasi = lokasi;
        this.status = status;
    }

    public long getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(long idBarang) {
        this.idBarang = idBarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public Pemeliharaan getStatus() {
        return status;
    }

    public void setStatus(Pemeliharaan status) {
        this.status = status;
    }

    public Tempat getLokasi() {
        return lokasi;
    }

    public void setLokasi(Tempat lokasi) {
        this.lokasi = lokasi;
    }

    public KategoriBarang getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(KategoriBarang kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }
    
    
    
    
    
}
