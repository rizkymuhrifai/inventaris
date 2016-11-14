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
    private long harga;
    private Pemeliharaan status;
    private Tempat lokasi;

    public Barang(long idBarang, String nama, long harga, Pemeliharaan status, Tempat lokasi) {
        this.idBarang = idBarang;
        this.nama = nama;
        this.harga = harga;
        this.status = status;
        this.lokasi = lokasi;
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

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
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
    
    
    
}
