package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //tecpro sayfasına gidelim
        driver.get("https://techproeducation.com/");
        Thread.sleep(2000);
        //Arama kutusunda java aratalım
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("java");
        Thread.sleep(2000);
        //çıkan seceneklerden full stack java developer secenegine tıklayalım
      List<WebElement> javaDeveloperListesi = driver.findElements(By.linkText("Full Stack Java Developer"));

      javaDeveloperListesi.get(4).click();
        /*
        linktext'i Full Stack Java Developer olan bütün webelementleri javaDeveloperListesi isimli liste attık.
        */
        //başlıgın java içerdiğini test edelim
        String title = driver.getTitle();
        if (title.contains("java")){
            System.out.println("başlık java içeriyor");
        }
        else{
            System.out.println("başlık java içermiyor");
        }
        //sayfada kactane link oldugunu console yazdıralım

        //sonra linkleri console yazdıralım


    }
}
