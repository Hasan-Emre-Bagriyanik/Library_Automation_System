
package ResultModels;

import java.sql.Date;

public class KullaniciResultModel {

     private int kullanici_id;
    private String ad;
    private String soyad;
    private int cinsiyet;
    private String no;
    private String email;
    private String telefon;
    private java.sql.Date dogum_tarihi;
    private String unvan;
    private String sifre;

    public KullaniciResultModel(int kullanici_id, String ad, String soyad, int cinsiyet, String no, String email, String telefon, Date dogum_tarihi, String unvan, String sifre) {
        this.kullanici_id = kullanici_id;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.no = no;
        this.email = email;
        this.telefon = telefon;
        this.dogum_tarihi = dogum_tarihi;
        this.unvan = unvan;
        this.sifre = sifre;
    }

    

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(int cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public java.util.Date getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(java.sql.Date dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
   
    
}
