/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.kitap;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Kitap {
    private int kitapid;
    private String kitapAdi;
    private int yazarid;
    private int yayineviid;
    private int ekleyenid;
    private Date basinyili;
    private int durum;
    private int turid;
    private int kitapyerid;
    private Date eklenmetarihi;
    public Kitap KitapAdi;
  
    public Kitap(){
        
    }

    public int getKitapid() {
        return kitapid;
    }

    public void setKitapid(int kitapid) {
        this.kitapid = kitapid;
    }
    
    public String getKitapAdi(){
        return kitapAdi;
    }
    public void setKitapAdi(String kitapAdi){
        this.kitapAdi=kitapAdi;
    }
    public Date getBasinyili() {
        return basinyili;
    }
    public void setBasinyili(Date basinyili){
        this.basinyili=basinyili;
    } 
    public int getYazarid() {
        return yazarid;
    }
    public void setYazarid(int yazarid) {
        this.yazarid = yazarid;
    }
   public int getYayineviid() {
        return yayineviid;
    }
    public void setYayineviid(int yayineviid) {
        this.yayineviid = yayineviid;
    }
    public int getTurid() {
        return turid;
    }
    public void setTurid(int turid) {
        this.turid = turid;
    }   
    public int getDurum() {
        return durum;
    }
    public void setDurum(int durum) {
        this.durum = durum;
    }
    public int getEkleyenid() {
        return ekleyenid;
    }
    public void setEkleyenid(int ekleyenid) {
        this.ekleyenid = ekleyenid;
    }
    public int getKitapyerid() {
        return kitapyerid;
    }
    public void setKitapyerid(int kitapyerid) {
        this.kitapyerid = kitapyerid;
    }
    public Date getEklenmetarihi() {
        return eklenmetarihi;
    }
    public void setEklenmetarihi(Date eklenmetarihi) {
        this.eklenmetarihi = eklenmetarihi;
    }
  
  

    
}
