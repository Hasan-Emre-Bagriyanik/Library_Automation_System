
package models.kullanici;

import java.util.Date;

public abstract class KullaniciModel {
    
    private String ad;
    private String soyad;
    private int cinsiyet;
    private String no;
    private String email;
    private String telefon;
    private Date dogum_tarihi;
    private String unvan;
    private String sifre;
    
    private int ODUNC_HAFTA_SAYISI;
    private int CEZA_MIKTARI_TL;
    
    public void setODUNC_HAFTA_SAYISI(int hafta){
        this.ODUNC_HAFTA_SAYISI = hafta;
    }
    public void setCEZA_MIKTARI_TL(int miktar){
        this.CEZA_MIKTARI_TL = miktar;
    }
    
    public void bilgileriDuzenle(String ad,String soyad,int cinsiyet,String no,String email,
            String telefon,Date dogum_tarihi,String unvan,String sifre){
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

    public Date getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(Date dogum_tarihi) {
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

    public int getODUNC_HAFTA_SAYISI() {
        return ODUNC_HAFTA_SAYISI;
    }

    public int getCEZA_MIKTARI_TL() {
        return CEZA_MIKTARI_TL;
    }
    
}
