package models.kitap;

import java.util.Date;

public class Kitaplik {
    private KitapBuilder kitapBuilder;
    private Date basinyili;
    public void setKitapBuilder (KitapBuilder kitapBuilder){
        this.kitapBuilder=kitapBuilder;
    }
    public Kitap getKitap(){
        return kitapBuilder.getKitap();
    }
    public void buildKitap(String kitapAdi, int yazarId, int yayinEviId,int ekleyenId,Date basinYili,  int durum,int turId,  int kitapYerId,Date eklenmetarihi){
        kitapBuilder.buildKitapAdi(kitapAdi);
        kitapBuilder.buildYazarId(yazarId);
        kitapBuilder.buildYayineviId(yayinEviId);
        kitapBuilder.buildEkleyenId(ekleyenId);
        kitapBuilder.buildBasinYili(basinYili);
        kitapBuilder.buildDurum(durum);
        kitapBuilder.buildTurId(turId);
        kitapBuilder.buildKitapYerId(kitapYerId);
       kitapBuilder.buildEklenmeTarihi(eklenmetarihi);
        
    }
    
    public void updateKitap(int kitapid,String kitapAdi, int yazarId, int yayinEviId ,Date basinYili,  int durum, int turId,  int kitapYerId){
        kitapBuilder.buildKitapId(kitapid);
        kitapBuilder.buildKitapAdi(kitapAdi);
        kitapBuilder.buildYazarId(yazarId);
        kitapBuilder.buildYayineviId(yayinEviId);
        kitapBuilder.buildBasinYili(basinYili);
        kitapBuilder.buildDurum(durum);
        kitapBuilder.buildTurId(turId);
        kitapBuilder.buildKitapYerId(kitapYerId);        
    }
    
}
