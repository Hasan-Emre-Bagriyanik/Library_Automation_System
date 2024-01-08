
package models.yayinevi;

import java.util.Date;

public class YayineviModel {
    int yayineviId;
    String yayineviAdi;
    Date yayineviKurulusTarihi;
    String yayineviTelNo;
    String yayineviAdresi;
    String yayineviMail;

    public YayineviModel(String yayineviAdi, Date yayineviKurulusTarihi, String yayineviTelNo, String yayineviAdresi, String yayineviMail) {
        this.yayineviAdi = yayineviAdi;
        this.yayineviKurulusTarihi = yayineviKurulusTarihi;
        this.yayineviTelNo = yayineviTelNo;
        this.yayineviAdresi = yayineviAdresi;
        this.yayineviMail = yayineviMail;
    }

    public YayineviModel(int yayineviId, String yayineviAdi, Date yayineviKurulusTarihi, String yayineviTelNo, String yayineviAdresi, String yayineviMail) {
        this.yayineviId = yayineviId;
        this.yayineviAdi = yayineviAdi;
        this.yayineviKurulusTarihi = yayineviKurulusTarihi;
        this.yayineviTelNo = yayineviTelNo;
        this.yayineviAdresi = yayineviAdresi;
        this.yayineviMail = yayineviMail;
    }

    
    
    
    
    public int getYayineviId() {
        return yayineviId;
    }

    public void setYayineviId(int yayineviId) {
        this.yayineviId = yayineviId;
    }
    
    public String getYayineviAdi() {
        return yayineviAdi;
    }

    public void setYayineviAdi(String yayineviAdi) {
        this.yayineviAdi = yayineviAdi;
    }

    public Date getYayineviKurulusTarihi() {
        return yayineviKurulusTarihi;
    }

    public void setYayineviKurulusTarihi(Date yayineviKurulusTarihi) {
        this.yayineviKurulusTarihi = yayineviKurulusTarihi;
    }

    public String getYayineviTelNo() {
        return yayineviTelNo;
    }

    public void setYayineviTelNo(String yayineviTelNo) {
        this.yayineviTelNo = yayineviTelNo;
    }

    public String getYayineviAdresi() {
        return yayineviAdresi;
    }

    public void setYayineviAdresi(String yayineviAdresi) {
        this.yayineviAdresi = yayineviAdresi;
    }

    public String getYayineviMail() {
        return yayineviMail;
    }

    public void setYayineviMail(String yayineviMail) {
        this.yayineviMail = yayineviMail;
    }

    
    
        
    
}
