package day17_JSExecutor_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutorClick extends TestBase {
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);
        //sayfadaki sell linkine tıklayalım
        WebElement sellWE=driver.findElement(By.xpath("//*[.='Sell']"));
        sellWE.click();
                /*
        ElementClickInterceptedException: Locate'ini aldığımız bir elementin önünde başka pencere çıkarsa
        elemente click yapamadığı için bu hatayı fırlatır
         */
    }

    @Test
    public void test02() {
        /*
    JavaScriptExecutor arayüzünü kullanabilmek için önce bu arayüzden obje oluşturup driver'a eşitleriz.
    Oluşturduğumuz obje ile executeScript() methodunu kullanarak method içine script kodunu yazarız.
    Yukarıdaki örnekte sell linkine önüne bir pencere çıktığı için click yapamadı ama js executor direk
    DOM yapısına müdehale edebildiği için sell linki webelementine click yapabilir.
     */
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //sayfadaki sell linkine tıklayalım
        WebElement sellLinki=driver.findElement(By.xpath("//*[.='Sell']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);
    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //sayfadaki sell linkine tıklayalım
        WebElement sellLinki=driver.findElement(By.xpath("//*[.='Sell']"));
        jsClick(sellLinki);
    }
}
