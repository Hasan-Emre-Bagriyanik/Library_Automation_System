
package models.kullanici;

import java.util.Date;
import service.KutuphaneIslemleri;

public interface IKullanici {
    KutuphaneIslemleri kutuphaneIslemleri = KutuphaneIslemleri.getInstance();  
    
    void bilgileriDuzenle(String ad,String soyad,int cinsiyet,String no,String email,String telefon,Date dogum_tarihi,String unvan,String sifre);
    
    //void sifreDegistir(KullaniciModel kullanici);
}
