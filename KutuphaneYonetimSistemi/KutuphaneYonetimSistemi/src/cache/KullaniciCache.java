
package cache;

public class KullaniciCache {
    private static KullaniciCache kullanici;
    
    private String email;
    
    private KullaniciCache(){
    }
    
    public static KullaniciCache getKullanici(){
        if(kullanici == null){
            kullanici = new KullaniciCache();
        }
        return kullanici;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
