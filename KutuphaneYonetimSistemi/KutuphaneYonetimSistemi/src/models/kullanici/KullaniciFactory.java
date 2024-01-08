
package models.kullanici;

public class KullaniciFactory {
    
    public IKullanici kullaniciOlustur(String kullaniciTuru){
        
        if (kullaniciTuru.equalsIgnoreCase("Personel")) {
            return new PersonelModel();
        } else if (kullaniciTuru.equalsIgnoreCase("Ogrenci")) {
            return new OgrenciModel();
        }
        else {
            return kullaniciTuru.equalsIgnoreCase("Akademisyen") ? new AkademisyenModel() : null;
        }
    }
}
