package day17_JSExecutor_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecutorScroll extends TestBase {
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);


        //Back To School Webelementine kadar scroll yapalım
        WebElement backToScholl = driver.findElement(By.xpath("//*[text()='Back to school']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", backToScholl);

    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        bekle(2);


        //Back To School Webelementine kadar scroll yapalım
        WebElement backToScholl = driver.findElement(By.xpath("//*[text()='Back to school']"));
        jsScroll(backToScholl);
    }

    @Test
    public void test03() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        //sayfanın en altına scroll yapalım
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        /*
    Yukarıdaki method js executor ile sayfanın en altına scroll yapar. Spesifik olarak bir webelemente
    scroll yapmadığımız için sayfayı scroll yaptığımız için script kodu window ile başlar scrollTo
    methodu ile x ve y kordinatı belirtmemiz gerekir. x'e 0 y'ye bir değer verirsek verdiğimiz değer
    kadar aşağıya doğru scroll yapar. Ama sayfanın en altına scroll yapmasını istersek y değeri yerine
    'document.body.scrollHeight' script kodunu kullanırız.
     */
        bekle(3);
        //Sayfanın en üstüne scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    @Test
    public void test04() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalım
        jsScrollEnd();
        bekle(3);

        //Sayfanın en üstüne scroll yapalım
        jsScrollHome();
    }
}
