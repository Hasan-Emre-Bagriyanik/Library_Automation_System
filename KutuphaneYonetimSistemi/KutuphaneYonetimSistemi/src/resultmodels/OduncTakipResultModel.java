
package resultmodels;

import java.util.Date;

public class OduncTakipResultModel {
   
    private int oduncAlmaId;
    private int kitapid;
    private int kullaniciid;
    private String kitapAdi;
    private String kullaniciAdi;
    private String kullaniciSoyadi;
    private String kullaniciEposta;
    private Date oduncAlinmaTarihi;

    public OduncTakipResultModel(int oduncAlmaId, int kitapid, int kullaniciid, String kitapAdi, String kullaniciAdi, String kullaniciSoyadi, String kullaniciEposta, Date oduncAlinmaTarihi) {
        this.oduncAlmaId = oduncAlmaId;
        this.kitapid = kitapid;
        this.kullaniciid = kullaniciid;
        this.kitapAdi = kitapAdi;
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSoyadi = kullaniciSoyadi;
        this.kullaniciEposta = kullaniciEposta;
        this.oduncAlinmaTarihi = oduncAlinmaTarihi;
    }

    public int getOduncAlmaId() {
        return oduncAlmaId;
    }

    public void setOduncAlmaId(int oduncAlmaId) {
        this.oduncAlmaId = oduncAlmaId;
    }

    public int getKitapid() {
        return kitapid;
    }

    public void setKitapid(int kitapid) {
        this.kitapid = kitapid;
    }

    public int getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(int kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSoyadi() {
        return kullaniciSoyadi;
    }

    public void setKullaniciSoyadi(String kullaniciSoyadi) {
        this.kullaniciSoyadi = kullaniciSoyadi;
    }

    public String getKullaniciEposta() {
        return kullaniciEposta;
    }

    public void setKullaniciEposta(String kullaniciEposta) {
        this.kullaniciEposta = kullaniciEposta;
    }

    public Date getOduncAlinmaTarihi() {
        return oduncAlinmaTarihi;
    }

    public void setOduncAlinmaTarihi(Date oduncAlinmaTarihi) {
        this.oduncAlinmaTarihi = oduncAlinmaTarihi;
    }

   

   
    
}
