## HBTestingProject
___

#### Test Senaryosu Adımları
* Kullanıcı hepsiburada.com sitesini ziyaret eder.
* Kullanıcı arama işlemi yapar (Örnek: “iphone” gibi popüler ve yorumu olan bir ürün)
* Kullanıcı arama sonucunda gelen ürün listesinden ürün seçer ve ürün detay sayfasına gider.
* Kullanıcı seçilen ürün için ürün detayda “Yorumlar” tabına gider.
* Kullanıcı gelen yorumlar içerisinde ilk yorumun “Evet” butonuna basar.
* Kullanıcı “Teşekkür Ederiz” yazısını görür.
* Kullanıcı eğer yorumlar tab’ında hiç yorum gelmiyorsa herhangi bir işlem yapmaz.

#### Gereksinimler: 
* Java8+
* Maven 3.6.1

#### Kullanılan test araçları:
* TestNG
* Selenium

`Kullanılan Web Driver = ChromeDriver`

`Kullanılan OS = macOS Catalina 10.15.6`

Maven paketleri kurmak için
```
mvn clean package
```
komutu kullanılabilir.
