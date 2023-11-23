package day13_Exception_ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NullPointerException {
    WebDriver driver;
    @Test
    public void test01() {
  /*
NULLPOINTEREXCEPTION
    Eğer bir obje yada değişken oluşturup bu oluşturduğumuz obje yada değişkene atama yapmadan
kullanmak istersek bu exception'ı alırız
 */
        WebDriverManager.chromedriver().setup();
/*
Eğer driver ayarları için WebDriverManager.chromedriver().setup(); bu kodu kullanmazsak
SESSIONNOTCREATEEXCEPTION hatasını alırız. Kullandığımız halde eğer versiyondan kaynaklı bir sorun olursa
yine bu hatayı alırız.
 */
        driver = new ChromeDriver();
        driver.get("https://amazon.com");
    }

}
