
package models.kullanici;

public class AkademisyenModel extends KullaniciModel implements IKullanici{
    
    private final int ODUNC_HAFTA_SAYISI = 4;
    private final int CEZA_MIKTARI_TL = 10;


    public int getODUNC_HAFTA_SAYISI() {
        return ODUNC_HAFTA_SAYISI;
    }
    
    public int getCEZA_MIKTARI_TL() {
        return CEZA_MIKTARI_TL;
    }

}
