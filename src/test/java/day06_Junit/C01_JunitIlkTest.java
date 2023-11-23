package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JunitIlkTest {
    /*
    Projemizde Junit framework'u kullanmak istiyorsak oncelikle
    mvnrepository.com adresinde Junit dependency'sini pomp.xml dosyamiza koymamiz gerekiyor.
    Bu dependency'i sayesinde artik main method kullanamadan notasyonlar
    sayesinde text scriplerimizi yazacagiz. Notasyonlar @ isarei ile baslar
    @Test notasyonu icinde olusturacagimiz test methodunda kodlarimizi yazar ve calistiririz.
    @Test notosyonuna sahip bir methodu hızlı brsekilde yazmak için istersek alt+insert tuşlarına
    basarak test methodunu oluşturabilriz yada sağ tıkla genarete tıkla ve method tıkla
    Junit framework ümüzde testlerimizi istediğimiz bir sıralamada çalıştırmak istiyorsak
    test isimlerini alfabetik ve numaretik olarak belirtmemiz gerekir

    */
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
        driver.close();

    }

    @Test
    public void test02() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        driver.close();
    }

    @Test
    public void test03() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");
        driver.close();
    }
}
