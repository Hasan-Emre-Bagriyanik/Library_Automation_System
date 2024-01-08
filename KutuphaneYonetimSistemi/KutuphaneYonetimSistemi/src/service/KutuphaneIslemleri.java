package service;


import ResultModels.KitapResultModel;
import ResultModels.KullaniciResultModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import models.kitap.Kitap;
import models.kullanici.KullaniciFactory;
import models.kullanici.KullaniciModel;
import models.oduncalma.OduncAlmaModel;
import models.yayinevi.YayineviModel;
import models.yazar.KitapYazari;
import models.yazar.KitapYazariFactory;
import models.yazar.Yazar;
import resultmodels.CezalarResultModel;
import resultmodels.OduncTakipResultModel;



public class KutuphaneIslemleri {
    
    private static KutuphaneIslemleri instance;
    
    private Connection con = null;
    private java.sql.Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    private KutuphaneIslemleri ()
    {
       
        VeritabaniBaglayici baglayici = new IliskiselVeritabaniBaglayicisi(new MySQLBaglantisi());
        con = baglayici.baglan();
       
    }
    
    public static KutuphaneIslemleri getInstance(){
        
        if(instance == null){
            return new KutuphaneIslemleri();
        }
        return instance;
        
    }
    
    //Kullanici Islemleri
    
    public KullaniciModel kullaniciModelGetir(String email) {
            
    String query = "SELECT * FROM kullanicilar WHERE email = ?";
    String ad = "";
    String soyad = "";
    int cinsiyet = -1;
    String no = "";
    String eposta = "";
    String telefon = "";
    java.sql.Date dogumTarihi = null;
    String unvan = "";
    String sifre = "";
    
    try {
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, email);
        
        ResultSet rs = preparedStatement.executeQuery();
        
        if (rs.next()) {
            int kullaniciID = rs.getInt("kullanici_id");
            ad = rs.getString("ad");
            soyad = rs.getString("soyad");
            cinsiyet = rs.getInt("cinsiyet");
            no = rs.getString("no");
            eposta = rs.getString("email");
            telefon = rs.getString("telefon");
            dogumTarihi = rs.getDate("dogum_tarihi");
            unvan = rs.getString("unvan");
            sifre = rs.getString("sifre");
            
                   
        }
            
        
        rs.close();
      
        KullaniciFactory factory = new KullaniciFactory();
        KullaniciModel yeniKullanici = (KullaniciModel) factory.kullaniciOlustur(unvan);
        yeniKullanici.bilgileriDuzenle(ad, soyad, cinsiyet, no, eposta, telefon, dogumTarihi, unvan, sifre);
        
        return yeniKullanici;
    } catch (SQLException ex) {
        Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }
    
    }
    
    public int kullaniciIDGetir(String email) {
    
    int kullaniciID = -1;    
        
    String query = "SELECT kullanici_id FROM kullanicilar WHERE email = ?";
    
    try {
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, email);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            kullaniciID = resultSet.getInt("kullanici_id");
        }
        
        resultSet.close();
        
        return kullaniciID;
    } catch (SQLException ex) {
        Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return-1;
    }
    
    }
    
    public ArrayList<KullaniciResultModel> kullanicilariGoruntule(){
        ArrayList<KullaniciResultModel> output = new ArrayList<KullaniciResultModel>();
        
        String query = "SELECT * FROM kullanicilar";
        
         try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("kullanici_id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                int cinsiyet = rs.getInt("cinsiyet");
                String no = rs.getString("no");
                String email = rs.getString("email");
                String tel = rs.getString("telefon");
                java.sql.Date dogumTarihi = rs.getDate("dogum_tarihi");
                String unvan = rs.getString("unvan");
                String sifre = "*****";
           
               
                output.add(new KullaniciResultModel(id, ad, soyad, cinsiyet, no, email, tel, dogumTarihi, unvan, sifre));
                        
        
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
    }
    
     public ArrayList<CezalarResultModel> kullaniciCezalariGetir(int kullaniciId){
        ArrayList<CezalarResultModel> output = new ArrayList<CezalarResultModel>();
        
        String query = "Select c.ceza_id,k.ad,k.soyad,k.email,c.gun,c.cezaMiktari "
                + "from cezalar c, kullanicilar k where c.kullanici_id = k.kullanici_id and c.kullanici_id = ?";
        
         try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, kullaniciId);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("ceza_id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String email = rs.getString("email");
                int gun = rs.getInt("gun");
                int cezaMiktari = rs.getInt("cezaMiktari");
           
               
                output.add(new CezalarResultModel(id, ad, soyad, email, gun, cezaMiktari));
                        
        
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
    }
     
     public int kullaniciSifreveTelefonGuncelle (String email, String yeniSifre,String yeniTelefon)
    {
        String query = "Update kullanicilar set telefon = ? , sifre = ? where email = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, yeniTelefon);
            preparedStatement.setString(2, yeniSifre);
            preparedStatement.setString(3, email);
            
            return preparedStatement.executeUpdate();
                 
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
        
    }
     
     
            
         
    //***********************************************************************************************************
    
    //Kullanici Giris ve Kayit Islemleri
    
    public boolean loginControl (String email, String sifre)
    {
        
        String query = "Select * From kullanicilar where email = ? and sifre = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, sifre);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }  
    
    public int register(KullaniciModel kullanici)
    {
        String query = "Insert into kullanicilar (ad,soyad,cinsiyet,no,email,telefon,dogum_tarihi,unvan,sifre) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, kullanici.getAd());
            preparedStatement.setString(2, kullanici.getSoyad());
            preparedStatement.setInt(3, kullanici.getCinsiyet());
            preparedStatement.setString(4, kullanici.getNo());
            preparedStatement.setString(5, kullanici.getEmail());
            preparedStatement.setString(6, kullanici.getTelefon());
            preparedStatement.setDate(7, new java.sql.Date(kullanici.getDogum_tarihi().getTime()));
            preparedStatement.setString(8, kullanici.getUnvan());
            preparedStatement.setString(9, kullanici.getSifre());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
        
    }
    
    //***********************************************************************************************************
    
    //Kitap Islemleri
    
    public ArrayList<KitapResultModel> kitaplariGoruntule()
    {
       
        
        ArrayList<KitapResultModel> output = new ArrayList<KitapResultModel>();
        
        String query = "SELECT k.kitap_id,k.kitap_adi AS \"Kitap\", CONCAT(y.yazar_adi , \" \" ,y.yazar_soyadi) AS \"Yazar\", k.basin_yili AS \"Basın Yılı\",ye.yayinevi_adi AS \"Yayınevi\", t.tur_adi AS \"Tür\", k.eklenme_tarihi AS \"Eklenme Tarihi\",CONCAT(ku.ad , \" \" , ku.soyad) AS \"Ekleyen Personel\", ki.kitaplik_adi AS \"Kitaplık\" , r.raf_adi AS \"Raf\", kt.kat_adi AS \"Kat\", k.durum AS \"Durum\"\n" +
"FROM kitap k, yazar y, yayinevi ye, tur t, kullanicilar ku, kitap_yer ky, kitaplik ki, raf r ,kat kt\n" +
"WHERE k.yazar_id = y.yazar_id AND k.yayinevi_id = ye.yayinevi_id AND k.tur_id = t.tur_id AND k.ekleyen_id = ku.kullanici_id\n" +
"AND k.kitap_yer_id = ky.kitap_yer_id AND ky.kat_id = kt.kat_id AND ky.kitaplik_id = ki.kitaplik_id AND ky.raf_id = r.raf_id;";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("kitap_id");
                String kitapAdi = rs.getString("Kitap");
                String yazar = rs.getString("Yazar");
                java.sql.Date basinYili = rs.getDate("Basın Yılı");
                String yayinevi = rs.getString("Yayınevi");
                String tur = rs.getString("Tür");
                java.sql.Date eklenmeTarihi = rs.getDate("Eklenme Tarihi");
                String ekleyenPersonel = rs.getString("Ekleyen Personel");
                String kitaplik = rs.getString("Kitaplık");
                String raf = rs.getString("Raf");
                String kat = rs.getString("Kat");
                int gelenDurumInt = rs.getInt("Durum");
                
                String durum = "";
                
                
                if(gelenDurumInt == 0){
                    durum = "Ödünç Alındı";
                }
                else if (gelenDurumInt == 1){
                    durum = "Mevcut";
                }
                else if(gelenDurumInt == -1){
                    durum = "Kayıp";
                }
                

                output.add(new KitapResultModel(id, kitapAdi, yazar, basinYili, yayinevi, tur, eklenmeTarihi, ekleyenPersonel, kitaplik, raf, kat,durum));
        
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
      
    }
   
    

    public int addBook(Kitap kitap)
    {
        String query = "Insert into kitap (kitap_adi,yazar_id,basin_yili,yayinevi_id,tur_id,durum,ekleyen_id,eklenme_tarihi,kitap_yer_id) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, kitap.getKitapAdi());
            preparedStatement.setInt(2, kitap.getYazarid());
            preparedStatement.setDate(3, kitap.getBasinyili());
            preparedStatement.setInt(4, kitap.getYayineviid());
            preparedStatement.setInt(5, kitap.getTurid());
            preparedStatement.setInt(6, kitap.getDurum());
            preparedStatement.setInt(7, kitap.getEkleyenid());
            preparedStatement.setDate(8, kitap.getEklenmetarihi());
            preparedStatement.setInt(9, kitap.getKitapyerid());
            
            return preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public int deleteBook (int id)
    {
        String query = "Delete From kitap where kitap_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setInt(1, id);
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
       
    public int updateBook (Kitap kitap)
    {
        String query = "Update kitap set kitap_adi = ?, yazar_id = ? ,basin_yili = ?, yayinevi_id = ?, "
                + "tur_id = ?, durum = ?, kitap_yer_id = ? where kitap_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, kitap.getKitapAdi());
            preparedStatement.setInt(2, kitap.getYazarid());
            preparedStatement.setDate(3, new java.sql.Date(kitap.getBasinyili().getTime()));
            preparedStatement.setInt(4, kitap.getYayineviid());
            preparedStatement.setInt(5, kitap.getTurid());
            preparedStatement.setInt(6, kitap.getDurum());
            preparedStatement.setInt(7, kitap.getKitapyerid());

            preparedStatement.setInt(8,kitap.getKitapid());
            
            return preparedStatement.executeUpdate();
                 
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
        
    }
    
    //***********************************************************************************************************
    
    //Yayinevi Islemleri
    
    public ArrayList<YayineviModel> yayinevleriniGoruntule()
    {
       
        
        ArrayList<YayineviModel> output = new ArrayList<YayineviModel>();
        
        String query = "Select * from yayinevi";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("yayinevi_id");
                String yayineviAdi = rs.getString("yayinevi_adi");
                java.sql.Date kurulusTarihi = rs.getDate("yayinevi_kurulus_tarihi");
                String tel = rs.getString("yayinevi_tel_no");
                String adres = rs.getString("yayinevi_adresi");
                String mail = rs.getString("yayinevi_mail");
                
                output.add(new YayineviModel(id,yayineviAdi, kurulusTarihi, tel, adres, mail));
        
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
      
    }
    
    public int yayinEviEkle(YayineviModel yayinevi) {

        String query = "insert into yayinevi (yayinevi_adi,yayinevi_kurulus_tarihi,yayinevi_tel_no,yayinevi_adresi,yayinevi_mail) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, yayinevi.getYayineviAdi());
            preparedStatement.setDate(2, new java.sql.Date(yayinevi.getYayineviKurulusTarihi().getTime()));
            preparedStatement.setString(3, yayinevi.getYayineviTelNo());
            preparedStatement.setString(4, yayinevi.getYayineviAdresi());
            preparedStatement.setString(5, yayinevi.getYayineviMail());
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int yayineviSil(int id)
    {
        String query = "Delete From yayinevi where yayinevi_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setInt(1, id);
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
       
    public int yayineviGuncelle (YayineviModel yayinevi)
    {
        String query = "Update yayinevi set yayinevi_adi = ?, yayinevi_kurulus_tarihi = ? ,yayinevi_tel_no = ?, yayinevi_adresi = ?, "
                + "yayinevi_mail = ? where yayinevi_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, yayinevi.getYayineviAdi());
            preparedStatement.setDate(2, new java.sql.Date(yayinevi.getYayineviKurulusTarihi().getTime()));
            preparedStatement.setString(3, yayinevi.getYayineviTelNo());
            preparedStatement.setString(4, yayinevi.getYayineviAdresi());
            preparedStatement.setString(5, yayinevi.getYayineviMail());
            preparedStatement.setInt(6,yayinevi.getYayineviId());
            
            return preparedStatement.executeUpdate();
                 
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
        
    }
    
    
    
    
    //***********************************************************************************************************

    
    
    //Yazar İşlemleri
    
    public ArrayList<KitapYazari> yazarGoruntule()
    {
       
        
        ArrayList<KitapYazari> output = new ArrayList<KitapYazari>();
        
        String query = "Select * from yazar";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("yazar_id");
                String yazarAdi = rs.getString("yazar_adi");
                String yazarSoyad = rs.getString("yazar_soyadi");
                int cinsiyet = rs.getInt("cinsiyet");
                java.sql.Date dogumTarihi = rs.getDate("yazar_dogum_tarihi");
                String dogumYeri = rs.getString("yazar_dogum_yeri");
                String yazarAciklama = rs.getString("yazar_aciklama");      
                
                KitapYazariFactory kitapYazariFactory = new KitapYazariFactory();
                KitapYazari kitapYazari = (KitapYazari) kitapYazariFactory.createYazar();
                kitapYazari.YazarBilgileriniDuzenleIDli(id,yazarAdi, yazarSoyad, dogumTarihi, dogumYeri, cinsiyet, yazarAciklama);
                
                output.add(kitapYazari);
        
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
      
    }
    
     public int yazarEkle(KitapYazari yazar){

            String query = "insert into yazar (yazar_adi,yazar_soyadi,cinsiyet,yazar_dogum_tarihi,yazar_dogum_yeri,yazar_aciklama) values(?,?,?,?,?,?)";
            try 
            {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, yazar.getYazarAdi());
                preparedStatement.setString(2, yazar.getYazarSoyadi());
                preparedStatement.setInt(3, yazar.getYazarCinsiyet());
                preparedStatement.setDate(4, new java.sql.Date(yazar.getYazarDogumTarihi().getTime()));
                preparedStatement.setString(5, yazar.getYazarDogumYeri());
                preparedStatement.setString(6, yazar.getYazarAciklama()); 
               return preparedStatement.executeUpdate();
            }
        
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return -1;
        }
   
    }
     
     public int yazarSil(int id)
    {
        String query = "Delete From yazar where yazar_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setInt(1, id);
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
       
    public int yazarGuncelle (KitapYazari yazar)
    {
        String query = "Update yazar set yazar_adi = ?, yazar_soyadi = ? ,cinsiyet = ?, yazar_dogum_tarihi = ?, "
                + "yazar_dogum_yeri = ?, yazar_aciklama = ? where yazar_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, yazar.getYazarAdi());
            preparedStatement.setString(2, yazar.getYazarSoyadi());
            preparedStatement.setInt(3, yazar.getYazarCinsiyet());
            preparedStatement.setDate(4, new java.sql.Date(yazar.getYazarDogumTarihi().getTime()));
            preparedStatement.setString(5, yazar.getYazarDogumYeri());
            preparedStatement.setString(6,yazar.getYazarAciklama());
            preparedStatement.setInt(7,yazar.getYazarid());

            return preparedStatement.executeUpdate();
                 
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
        
    }
     
     
    //***********************************************************************************************************
    
    //Kitap Yer Islemleri
     
     public ArrayList<String> kat_adi_getir(){
        ArrayList<String> katAdi = new ArrayList<String>();
        
        String query = "SELECT kat_adi from kat  ";

         try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                String kat = rs.getString("kat_adi");
                katAdi.add(kat);
            }
            return katAdi;
            
        }catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
      }
    }
    
  public ArrayList<String> kitaplik_adi_getir(String selectedKatAdi) {
        ArrayList<String> kitaplikAdi = new ArrayList<String>();

        String query = "SELECT DISTINCT  kitaplik_adi FROM kitap_yer ky "
                     + "INNER JOIN kitaplik k ON k.kitaplik_id = ky.kitaplik_id "
                     + "INNER JOIN kat ON ky.kat_id = kat.kat_id "
                     + "WHERE kat_adi = ?";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, selectedKatAdi);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                String kitaplik = rs.getString("kitaplik_adi");
                kitaplikAdi.add(kitaplik);
            }
            return kitaplikAdi;
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<String> raf_adi_getir(String selectedKitaplikAdi) {
        ArrayList<String> rafAdi = new ArrayList<String>();

        String query = "SELECT raf_adi FROM kitap_yer ky "
                     + "INNER JOIN raf ON raf.raf_id = ky.raf_id "
                     + "INNER JOIN kitaplik k ON k.kitaplik_id = ky.kitaplik_id "
                     + "WHERE kitaplik_adi = ?";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, selectedKitaplikAdi);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                String raf = rs.getString("raf_adi");
                rafAdi.add(raf);
            }
            return rafAdi;
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    
    public ArrayList<Object[]> getKitapOzellikleri(String selectedRafAdi) {
        ArrayList<Object[]> kitapOzellikleri = new ArrayList<>();

                String query = "SELECT kitap_id, kitap_adi, yazar_id, basin_yili, yayinevi_id, tur_id, durum, ekleyen_id, eklenme_tarihi, k.kitap_yer_id FROM kitap k INNER JOIN kitap_yer ky ON k.kitap_yer_id = ky.kitap_yer_id INNER JOIN raf r ON r.raf_id = ky.raf_id WHERE r.raf_adi = ?";


        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, selectedRafAdi);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[10];
                for (int i = 0; i < 10; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                kitapOzellikleri.add(row);
            }

            return kitapOzellikleri;
        } catch (SQLException ex) {
            // Hata durumunda loglama
            ex.printStackTrace(); // Hatanın detayını yazdır
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //***********************************************************************************************************
    
    //Odunc Verme Islemleri
    
    public int oduncAlma(OduncAlmaModel oduncModel,int kitapid,int durum){

            String query = "insert into odunc_alma (kitap_id,kullanici_id,odunc_alinma_tarihi) values(?,?,?)";
            String query2 = "Update kitap set durum = ? where kitap_id = ?";
            try 
            {
            
                preparedStatement = con.prepareStatement(query2);

                preparedStatement.setInt(1, durum);
                preparedStatement.setInt(2, kitapid);

                int sonuc = preparedStatement.executeUpdate();
                
                if(sonuc > 0){
                    preparedStatement = con.prepareStatement(query);

                    preparedStatement = con.prepareStatement(query);
                    preparedStatement.setInt(1, oduncModel.getKitapId());
                    preparedStatement.setInt(2, oduncModel.getKullaniciId());
                    preparedStatement.setDate(3, new java.sql.Date(oduncModel.getOduncAlinmaTarihi().getTime()));
                   return preparedStatement.executeUpdate();
                }
                else{
                    return -1;
                }               
            }
        
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return -1;
        }
   
    }
    
    public ArrayList<OduncTakipResultModel> oduncTakip(){
        ArrayList<OduncTakipResultModel> output = new ArrayList<OduncTakipResultModel>();
        
        String query = "Select o.odunc_alma_id,o.kitap_id,o.kullanici_id,ki.kitap_adi, ku.ad,ku.soyad,ku.email,o.odunc_alinma_tarihi "
                + "from odunc_alma o , kitap ki , kullanicilar ku where o.kitap_id = ki.kitap_id and o.kullanici_id = ku.kullanici_id and o.iade_tarihi is null";

         try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("odunc_alma_id");
                int kitapId = rs.getInt("kitap_id");
                int kullaniciId = rs.getInt("kullanici_id");
                String kitapAd = rs.getString("kitap_adi");
                String kAd = rs.getString("ad");
                String kSoyad = rs.getString("soyad");
                String email = rs.getString("email");
                java.sql.Date oduncAlinmaTarihi = rs.getDate("odunc_alinma_tarihi");
                
                output.add(new OduncTakipResultModel(id, kitapId,kullaniciId ,kitapAd, kAd, kSoyad, email, oduncAlinmaTarihi));
            }
            return output;
            
        }catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
      }
    }
    
   public int oduncTeslimEtme(KullaniciModel kullanici ,OduncAlmaModel oduncModel,int kitapId){

            String query = "insert into cezalar (kullanici_id,gun,cezaMiktari) values(?,?,?)";
            String query2 = "Update odunc_alma set iade_tarihi = ? where odunc_alma_id = ?";
            String query3 = "Update kitap set durum = ? where kitap_id = ?";
            try 
            {
                
                LocalDate today =  LocalDate.now();
                LocalDate teslimEtmesiGerekTarih =  new java.sql.Date(oduncModel.getOduncAlinmaTarihi().getTime()).toLocalDate().plus(kullanici.getODUNC_HAFTA_SAYISI(), ChronoUnit.WEEKS);
                long haftaFarki = ChronoUnit.WEEKS.between(today, teslimEtmesiGerekTarih);
                
                java.sql.Date sqlBugununTarihi = java.sql.Date.valueOf(today);
                
                if(Math.abs(haftaFarki) > kullanici.getODUNC_HAFTA_SAYISI()){
                    int gunSayisi = (int) Math.abs((haftaFarki - kullanici.getODUNC_HAFTA_SAYISI())) * 7;
                    int cezaMiktari = Math.abs(gunSayisi * kullanici.getCEZA_MIKTARI_TL());
                    int kullaniciID = kullaniciIDGetir(kullanici.getEmail());
                    
                    preparedStatement = con.prepareStatement(query3);
                    preparedStatement.setInt(1, 1);
                    preparedStatement.setInt(2, kitapId);
                    preparedStatement.executeUpdate();
                    
                    preparedStatement = con.prepareStatement(query2);
                    preparedStatement.setDate(1, sqlBugununTarihi);
                    preparedStatement.setInt(2, oduncModel.getOduncAlmaId());
                    preparedStatement.executeUpdate();
                        
                    preparedStatement = con.prepareStatement(query);
                    preparedStatement.setInt(1,kullaniciID);
                    preparedStatement.setInt(2, gunSayisi);
                    preparedStatement.setInt(3, cezaMiktari);
                    return preparedStatement.executeUpdate();
                }
                else{
                    
                    preparedStatement = con.prepareStatement(query3);
                    preparedStatement.setInt(1, 1);
                    preparedStatement.setInt(2, kitapId);
                    preparedStatement.executeUpdate();
                    
                    preparedStatement = con.prepareStatement(query2);
                    preparedStatement.setDate(1, sqlBugununTarihi);
                    preparedStatement.setInt(2, oduncModel.getOduncAlmaId());
                    return preparedStatement.executeUpdate();
                }
                
                
                             
            }
        
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return -1;
        }
   
    }
    
    
    
    
    //***********************************************************************************************************
    //ComboBox Veri Getirme Islemleri
    
    
    public ArrayList<String> yayineviComboBoxGetir()
    {
       
        
        ArrayList<String> output = new ArrayList<String>();
        
        String query = "SELECT yayinevi_adi from yayinevi";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                
                String yayinevi = rs.getString("yayinevi_adi");
                output.add(yayinevi);
        
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
      
    }
    
    public ArrayList<String> yazarComboBoxGetir()
    {
       
        
        ArrayList<String> output = new ArrayList<String>();
        
        String query = "SELECT CONCAT(yazar_adi, \" \", yazar_soyadi) AS 'adsoyad' from yazar;";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                
                String yazar = rs.getString("adsoyad");
                output.add(yazar);
        
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
      
    }
    
    public ArrayList<String> turComboBoxGetir()
    {
       
        
        ArrayList<String> output = new ArrayList<String>();
        
        String query = "SELECT tur_adi from tur";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                
                String turAdi = rs.getString("tur_adi");
                output.add(turAdi);
        
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
      
    }
    
    public ArrayList<String> yerBilgisiComboBoxGetir()
    {
       
        
        ArrayList<String> output = new ArrayList<String>();
        
        String query = "SELECT CONCAT(k.kat_adi, \".KAT\") AS 'KAT', ki.kitaplik_adi AS 'Kitaplık', r.raf_adi AS 'RAF' \n" +
"FROM kitap_yer ky , kat k, kitaplik ki, raf r WHERE ky.kat_id = k.kat_id AND ky.kitaplik_id = ki.kitaplik_id AND ky.raf_id = r.raf_id;";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                
                String kat = rs.getString("KAT");
                String kitaplik = rs.getString("Kitaplık");
                String raf = rs.getString("RAF");
                
                String topluYerBilgisi = kat + " " + kitaplik + " " + raf;
                
                
                output.add(topluYerBilgisi);
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(KutuphaneIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
                    
        }
      
    }
}
