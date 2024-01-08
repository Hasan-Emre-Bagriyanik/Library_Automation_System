/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models.yazar;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public interface Yazar {
    
    void YazarBilgileriniDuzenle(String yazarAdi, String yazarSoyadi, Date yazarDogumTarihi, String yazarDogumYeri,int yazarCinsiyet ,String yazarAciklama);
    void YazarBilgileriniDuzenleIDli(int yazarid,String yazarAdi, String yazarSoyadi, Date yazarDogumTarihi, String yazarDogumYeri,int yazarCinsiyet ,String yazarAciklama);

}
