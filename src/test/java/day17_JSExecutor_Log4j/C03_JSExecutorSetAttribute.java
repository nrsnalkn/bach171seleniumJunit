package day17_JSExecutor_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutorSetAttribute extends TestBase {
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


        //arama kutusuna java yazdıralım
    /*
    Webdriver ile sendKeys() methodu kullanarak <input> tag'ına sahip bir webelemente text göndrebiliriz
    sendKeys() methodu ile gönderemediğimiz durumlarda aşağıdaki örnekteki gibi js executor ile bunu
    yapabiliriz.
    */
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='java'", aramaKutusu);
    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //arama kutusuna java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','esat')",aramaKutusu);
        driver.findElement(By.id("esat")).sendKeys("java");
    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //arama kutusuna iphone yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       jsSendKeys(aramaKutusu,"iphone");
    }
}
