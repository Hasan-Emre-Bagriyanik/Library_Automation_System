
package models.yazar;

import java.util.Date;

public class KitapYazari implements Yazar{
    
    private int yazarid;
    private String yazarAdi;
    private String yazarSoyadi;
    private Date yazarDogumTarihi;
    private String yazarDogumYeri;
    private int yazarCinsiyet;
    private String yazarAciklama;

    public int getYazarid() {
        return yazarid;
    }

    public void setYazarid(int yazarid) {
        this.yazarid = yazarid;
    }

    

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public String getYazarSoyadi() {
        return yazarSoyadi;
    }

    public void setYazarSoyadi(String yazarSoyadi) {
        this.yazarSoyadi = yazarSoyadi;
    }

    public Date getYazarDogumTarihi() {
        return yazarDogumTarihi;
    }

    public void setYazarDogumTarihi(Date yazarDogumTarihi) {
        this.yazarDogumTarihi = yazarDogumTarihi;
    }

    public String getYazarDogumYeri() {
        return yazarDogumYeri;
    }

    public void setYazarDogumYeri(String yazarDogumYeri) {
        this.yazarDogumYeri = yazarDogumYeri;
    }

    public int getYazarCinsiyet() {
        return yazarCinsiyet;
    }

    public void setYazarCinsiyet(int yazarCinsiyet) {
        this.yazarCinsiyet = yazarCinsiyet;
    }

    public String getYazarAciklama() {
        return yazarAciklama;
    }

    public void setYazarAciklama(String yazarAciklama) {
        this.yazarAciklama = yazarAciklama;
    }

    
   

    @Override
    public void YazarBilgileriniDuzenle(String yazarAdi, String yazarSoyadi, Date yazarDogumTarihi, String yazarDogumYeri,int yazarCinsiyet ,String yazarAciklama) {
        this.yazarAdi=yazarAdi;
        this.yazarSoyadi=yazarSoyadi;
        this.yazarDogumTarihi=yazarDogumTarihi;
        this.yazarDogumYeri=yazarDogumYeri;
        this.yazarCinsiyet = yazarCinsiyet;
        this.yazarAciklama=yazarAciklama;
    }

    @Override
    public void YazarBilgileriniDuzenleIDli(int yazarid, String yazarAdi, String yazarSoyadi, Date yazarDogumTarihi, String yazarDogumYeri, int yazarCinsiyet, String yazarAciklama) {
        this.yazarid = yazarid;
        this.yazarAdi=yazarAdi;
        this.yazarSoyadi=yazarSoyadi;
        this.yazarDogumTarihi=yazarDogumTarihi;
        this.yazarDogumYeri=yazarDogumYeri;
        this.yazarCinsiyet = yazarCinsiyet;
        this.yazarAciklama=yazarAciklama;
    }
    
   
    
    
}
