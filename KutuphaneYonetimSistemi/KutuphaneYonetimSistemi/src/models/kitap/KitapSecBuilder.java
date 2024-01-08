
package models.kitap;

public class KitapSecBuilder implements KitapBuilder{
    
    private Kitap kitap;
    
    @Override
    public void buildKitapId(int kitapid) {
        kitap.setKitapid(kitapid);
    }
    
    
    @Override
    public void buildKitapAdi(String kitapAdi) {
      kitap.setKitapAdi(kitapAdi);
        
    }

    @Override
    public void buildYazarId(int yazarid) {
     kitap.setYazarid(yazarid);
    }

    @Override
    public void buildBasinYili(java.util.Date basinyili) {
        java.sql.Date donusturulmusTarih = new java.sql.Date(basinyili.getTime());

        
       kitap.setBasinyili( donusturulmusTarih);
    }

    @Override
    public void buildYayineviId(int yayineviid) {
        kitap.setYayineviid(yayineviid);
    }

    @Override
    public void buildTurId(int turid) {
        kitap.setTurid(turid);
    }

    @Override
    public void buildDurum(int durum) {
        kitap.setDurum(durum);
    }

    @Override
    public void buildEkleyenId(int ekleyenid) {
       kitap.setEkleyenid(ekleyenid);
    }

    @Override
    public void buildKitapYerId(int kitapyerid) {
        kitap.setKitapyerid(kitapyerid);
    }

    @Override
    public Kitap getKitap() {
        return this.kitap;
    }
    
    public KitapSecBuilder(){
        this.kitap=new Kitap();
    }

    @Override
    public void buildEklenmeTarihi(java.util.Date eklenmetarihi) {
        java.sql.Date donusturulmusTarih = new java.sql.Date(eklenmetarihi.getTime());

        
        kitap.setEklenmetarihi(donusturulmusTarih);
    }

}
