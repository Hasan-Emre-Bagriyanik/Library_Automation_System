# Proje Başlığı

:information_source: **Dersin Kodu:** [16303](https://ebp.klu.edu.tr/Ders/dersDetay/YAZ16303/716026/tr)  
:information_source: **Dersin Adı:** [YAZILIM MİMARİSİ VE TASARIMI](https://ebp.klu.edu.tr/Ders/dersDetay/YAZ16303/716026/tr)  
:information_source: **Dersin Öğretim Elemanı:** Öğr. Gör. Dr. Fatih BAL  [Github](https://github.com/balfatih)   |    [Web Sayfası](https://balfatih.github.io/)
   
---

## Grup Bilgileri

| Öğrenci No  | Adı Soyadı            | Bölüm          		     | Proje Grup No | Grup Üyelerinin Github Profilleri                 |
|-------------|-----------------------|--------------------------|---------------|---------------------------------------------------|
| 1210505023  | Hasan Emre Bağrıyanık | Yazılım Mühendisliği     | PROJE_3       | [Github](https://github.com/Hasan-Emre-Bagriyanik)|
| 1210505037  | Veysel Uğurlu         | Yazılım Mühendisliği     | PROJE_3       | [Github](https://github.com/Veyselugurlu)         |
| 1210505072  | Duygu Teker           | Yazılım Mühendisliği     | PROJE_3       | [Github](https://github.com/Duygu14)              |
| 1210505007  | Mehmet Ali Sivri      | Yazılım Mühendisliği     | PROJE_3       | [Github](https://github.com/MehmetAliSivriDev)    |
---

## Proje Açıklaması

Buraya proje ile ilgili genel bir açıklama ekleyin. Projenizin amacı, kapsamı, kullanılan teknolojiler ve belki de projenin nasıl çalıştırılacağı gibi önemli bilgileri içermelidir.

Personellerin, akademisyenlerin ve öğrencilerin bulunduğu bir kutuphane otomasyonu uygulamasıdır.
Java Swing teknolojisi ile arayüzü geliştirilmiş ve mysql veritabanı kullanılmıştır.
Kutuphane otomasyonumuzda kitap ödünç alma, iade etme, kitapları ve yayınevlerini görüntüleme gibi işlevlere sahiptir daha fazla detaya inmek için projenin içeriğini inceleyebilirsiniz.
---

## Proje Dosya Yapısı

- **/src**
  - **/cache**
	- `KullaniciCache.java`
  - **/images**
    - `aramaIcon.png`
	- `cezaIcon.png`
	- `iadeIslemleriIcon.png`
	- `kitapEkleIcon.png`
	- `kitaplariGoruntuleIcon.png`
	- `kitapYeri.png`
	- `kitapYeriIcon.png`
	- `kullanici_ekle.png`
	- `kullaniciIslemleriIcon.png`
	- `oduncAlmaIcon.png`
	- `oduncTakipIcon.png`
	- `oduncVermekIcon.png`
	- `Pprofil.jpg`
	- `profil.png`
	- `profileIcon2.png`
	- `profilIcon.png`
	- `yayineviEkle.png`
	- `yayineviGoruntule.png`
	- `yayınEviIcon.png`
	- `yazarEkleIcon.png`
	- `yazarGoruntule.png`
	- `yazarIcon.png`
  - **/models**
	- **/kitap**
	  -`Kitap.java`
	  -`KitapBuilder.java`
	  -`Kitaplik.java`
	  -`KitapSecBuilder.java`
	- **/kullanici**
	  -`AkademisyenModel.java`
	  -`IKullanici.java`
	  -`KullaniciFactory.java`
	  -`KullaniciModel.java`
	  -`OgrenciModel.java`
	  -`PersonelModel.java`
	- **/oduncalma**
	  -`OduncAlmaModel.java`
	- **/yayinevi**
	  -`YayineviModel.java`
	- **/yazar**
	  -`KitapYazari.java`
	  -`KitapYazariFactory.java`
	  -`Yazar.java`
	  -`YazarFactory.java`
  -**/resultmodels**
	-`CezalarResultModel.java`
	-`KitapResultModel.java`
	-`KullaniciResultModel.java`
	-`OduncTakipResultModel.java`
  -**/service**
	-`IliskiselVeritabaniBaglayicisi.java`
	-`KutuphaneIslemleri.java`
	-`MySQLBaglantisi.java`
	-`VeritabaniBaglayici.java`
	-`VeritabaniBilgileri.java`
	-`VeritabaniPlatformu.java`
  -**/views**
	-`AAnasyfa.form`
	-`AAnasyfa.java`
	-`ACeza.form`
	-`ACeza.java`
	-`AIadeIslemleri.form`
	-`AIadeIslemleri.java`
	-`AKitapGoruntule.form`
	-`AKitapGoruntule.java`
	-`AOduncAlma.form`
	-`AOduncAlma.java`
	-`AProfil.form`
	-`AProfil.java`
	-`Login.form`
	-`Login.java`
	-`OCeza.form`
	-`OCeza.java`
	-`OgrenciAnasayfa.form`
	-`OgrenciAnasayfa.java`
	-`OIadeIslemleri.form`
	-`OIadeIslemleri.java`
	-`OKitapGoruntule.form`
	-`OKitapGoruntule.java`
	-`OOduncAlma.form`
	-`OOduncAlma.java`
	-`OProfil.form`
	-`OProfil.java`
	-`PersonelAnasayfa.form`
	-`PersonelAnasayfa.java`
	-`PKitapEkle.form`
	-`PKitapEkle.java`
	-`PKitapGoruntule.form`
	-`PKitapGoruntule.java`
	-`PKitapYer.form`
	-`PKitapYer.java`
	-`PKullaniciIslemleri.form`
	-`PKullaniciIslemleri.java`
	-`POduncTakip.form`
	-`POduncTakip.java`
	-`POduncVerme.form`
	-`POduncVerme.java`
	-`PProfil.form`
	-`PProfil.java`
	-`PYayineviEkle.form`
	-`PYayineviEkle.java`
	-`PYayineviGoruntule.form`
	-`PYayineviGoruntule.java`
	-`PYayineviIslemleri.form`
	-`PYayineviIslemleri.java`
	-`PYazarEkle.form`
	-`PYazarEkle.java`
	-`PYazarGoruntule.form`
	-`PYazarGoruntule.java`
	-`PYazarIslemleri.form`
	-`PYazarIslemleri.java`
	-`Register.form`
	-`Register.java`
	
---

## Kurulum

Kutuphane Otomasyonu için gereksinimler:
	-Java SDK
	-XAMPP
	-library.sql
	-Netbeans v18
	-mysql-connector-java-8.0.29.jar
	-jcalendar-1.4.jar
	
Java ve Netbeans teknolojilerini bilgisayarınıza kurduktan sonra projeyi açın ve libraries kısmında "mysql-connector-java-8.0.29.jar" ve "jcalendar-1.4.jar"'ı ekleyin
ve ardından projeyi çalıştırın.

---

## Kullanım

Gereksinimleri kurduktan sonra "library" veritabanına gidip "kullanicilar" tablosuna giderek oradan kendinize unvanına göre bir kullanici seçip o kullanıcının bilgileriyle girerek
deneyebilirsiniz ya da uygulama üzerinden kayıt olup uygulamada gezebilirsiniz lakin personel sayfasına ulaşmak istiyorsanız veritabanına bakmanız gerek çünkü personel olarak
kendinizi kayıt edemezsiniz.

---

## Katkılar

Internet :smile:

---

## İletişim

Projeyi geliştirenler ve github linkleri.

Hasan Emre Bağrıyanık -> [Github](https://github.com/Hasan-Emre-Bagriyanik)
Veysel Uğurlu         -> [Github](https://github.com/Veyselugurlu)         
Duygu Teker           -> [Github](https://github.com/Duygu14)              
Mehmet Ali Sivri      -> [Github](https://github.com/MehmetAliSivriDev)    
