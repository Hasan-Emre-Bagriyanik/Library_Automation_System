
package ResultModels;

import java.sql.Date;

public class KitapResultModel {
    
    int kitapId;
    String kitap;
    String yazar;
    java.sql.Date basinYili;
    String yayinevi;
    String tur;
    java.sql.Date eklenmeTarihi;
    String ekleyenPersonel;
    String kitaplik;
    String raf;
    String kat;
    String durum;

    public KitapResultModel(int kitapId, String kitap, String yazar, Date basinYili, String yayinevi, String tur, Date eklenmeTarihi, String ekleyenPersonel, String kitaplik, String raf, String kat, String durum) {
        this.kitapId = kitapId;
        this.kitap = kitap;
        this.yazar = yazar;
        this.basinYili = basinYili;
        this.yayinevi = yayinevi;
        this.tur = tur;
        this.eklenmeTarihi = eklenmeTarihi;
        this.ekleyenPersonel = ekleyenPersonel;
        this.kitaplik = kitaplik;
        this.raf = raf;
        this.kat = kat;
        this.durum = durum;
    }

    public int getKitapId() {
        return kitapId;
    }

    public void setKitapId(int kitapId) {
        this.kitapId = kitapId;
    }

    public String getKitap() {
        return kitap;
    }

    public void setKitap(String kitap) {
        this.kitap = kitap;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public Date getBasinYili() {
        return basinYili;
    }

    public void setBasinYili(Date basinYili) {
        this.basinYili = basinYili;
    }

    public String getYayinevi() {
        return yayinevi;
    }

    public void setYayinevi(String yayinevi) {
        this.yayinevi = yayinevi;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public Date getEklenmeTarihi() {
        return eklenmeTarihi;
    }

    public void setEklenmeTarihi(Date eklenmeTarihi) {
        this.eklenmeTarihi = eklenmeTarihi;
    }

    public String getEkleyenPersonel() {
        return ekleyenPersonel;
    }

    public void setEkleyenPersonel(String ekleyenPersonel) {
        this.ekleyenPersonel = ekleyenPersonel;
    }

    public String getKitaplik() {
        return kitaplik;
    }

    public void setKitaplik(String kitaplik) {
        this.kitaplik = kitaplik;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public String getKat() {
        return kat;
    }

    public void setKat(String kat) {
        this.kat = kat;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    

    
            
}
