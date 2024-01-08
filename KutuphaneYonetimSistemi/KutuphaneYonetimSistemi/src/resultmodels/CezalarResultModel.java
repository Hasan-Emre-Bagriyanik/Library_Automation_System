
package resultmodels;

public class CezalarResultModel {
    
    private int ceza_id;
    private String ad;
    private String soyad;
    private String email;
    private int gecirdigiGun;
    private int cezaMiktari;

    public CezalarResultModel(int ceza_id, String ad, String soyad, String email, int gecirdigiGun, int cezaMiktari) {
        this.ceza_id = ceza_id;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.gecirdigiGun = gecirdigiGun;
        this.cezaMiktari = cezaMiktari;
    }

    public int getCeza_id() {
        return ceza_id;
    }

    public void setCeza_id(int ceza_id) {
        this.ceza_id = ceza_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGecirdigiGun() {
        return gecirdigiGun;
    }

    public void setGecirdigiGun(int gecirdigiGun) {
        this.gecirdigiGun = gecirdigiGun;
    }

    public int getCezaMiktari() {
        return cezaMiktari;
    }

    public void setCezaMiktari(int cezaMiktari) {
        this.cezaMiktari = cezaMiktari;
    }
    
    
    
}
