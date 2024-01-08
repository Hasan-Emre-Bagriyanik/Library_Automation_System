
package service;

import java.sql.Connection;

public class IliskiselVeritabaniBaglayicisi implements VeritabaniBaglayici {
    
    protected VeritabaniPlatformu platform;
    
    public IliskiselVeritabaniBaglayicisi(VeritabaniPlatformu platform){
        this.platform = platform;
    }
    
    @Override
    public Connection baglan(){
        platform.baglantiyiYapilandir();
        return platform.baglantiyiGetir();
    
    }
    
    
}