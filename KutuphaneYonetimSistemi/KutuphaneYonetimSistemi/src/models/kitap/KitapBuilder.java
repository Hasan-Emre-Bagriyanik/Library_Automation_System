
package models.kitap;

import java.util.Date;

public interface KitapBuilder {

    void buildKitapId(int kitapid);
    void buildKitapAdi(String kitapAdi);
    void buildYazarId(int yazarid);
    void buildBasinYili(Date basinyili);
    void buildYayineviId(int yayineviid);
    void buildTurId(int turid);
    void buildDurum(int durum);
    void buildEkleyenId(int ekleyenid);
    void buildKitapYerId(int kitapyerid);
    void buildEklenmeTarihi(Date eklenmetarihi);
   
    Kitap getKitap();

   
}
