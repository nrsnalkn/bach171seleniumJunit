package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");

        //Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("Sayfa başlığı : " + actualTitle);

        //Sayfa basliginin "Amazon" icerdigini test edin
        System.out.println(actualTitle.contains("Amazon"));

        if (actualTitle.contains("Amazon")) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        //Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Sayfa Url'i :" + actualUrl);

        //Sayfa url'inin "amazon" icerdigini test edin.
        if (actualUrl.contains("amazon")) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        //Sayfa handle degerini yazdirin
        String amazonWindowHandleDegeri = driver.getWindowHandle();
        System.out.println("Handle Degeri : " + amazonWindowHandleDegeri);

        //Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        if (driver.getPageSource().contains("Gateway")) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        //Sayfayi kapatin.
        driver.close();
        //driver.quit();
    }
}