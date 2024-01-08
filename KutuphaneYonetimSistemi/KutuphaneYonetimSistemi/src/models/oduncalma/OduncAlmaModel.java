
package models.oduncalma;

import java.util.Date;

public class OduncAlmaModel {
 
    private int oduncAlmaId;
    private int kitapId;
    private int kullaniciId;
    private Date oduncAlinmaTarihi;
    private Date iadeTarihi;

    public OduncAlmaModel(int oduncAlmaId, int kitapId, int kullaniciId, Date oduncAlinmaTarihi, Date iadeTarihi) {
        this.oduncAlmaId = oduncAlmaId;
        this.kitapId = kitapId;
        this.kullaniciId = kullaniciId;
        this.oduncAlinmaTarihi = oduncAlinmaTarihi;
        this.iadeTarihi = iadeTarihi;
    }

    public OduncAlmaModel(int kitapId, int kullaniciId, Date oduncAlinmaTarihi) {
        this.kitapId = kitapId;
        this.kullaniciId = kullaniciId;
        this.oduncAlinmaTarihi = oduncAlinmaTarihi;
    }

    public OduncAlmaModel(int oduncAlmaId, int kitapId, int kullaniciId, Date oduncAlinmaTarihi) {
        this.oduncAlmaId = oduncAlmaId;
        this.kitapId = kitapId;
        this.kullaniciId = kullaniciId;
        this.oduncAlinmaTarihi = oduncAlinmaTarihi;
    }
    
    

    public int getOduncAlmaId() {
        return oduncAlmaId;
    }

    public void setOduncAlmaId(int oduncAlmaId) {
        this.oduncAlmaId = oduncAlmaId;
    }

    public int getKitapId() {
        return kitapId;
    }

    public void setKitapId(int kitapId) {
        this.kitapId = kitapId;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Date getOduncAlinmaTarihi() {
        return oduncAlinmaTarihi;
    }

    public void setOduncAlinmaTarihi(Date oduncAlinmaTarihi) {
        this.oduncAlinmaTarihi = oduncAlinmaTarihi;
    }

    public Date getIadeTarihi() {
        return iadeTarihi;
    }

    public void setIadeTarihi(Date iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }
    
    
    
}
