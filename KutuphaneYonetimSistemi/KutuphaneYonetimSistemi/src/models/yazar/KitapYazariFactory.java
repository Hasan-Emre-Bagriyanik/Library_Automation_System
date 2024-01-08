
package models.yazar;

public class KitapYazariFactory implements YazarFactory{

    @Override
    public Yazar createYazar() {
        return new KitapYazari();
    }
    
    
}
