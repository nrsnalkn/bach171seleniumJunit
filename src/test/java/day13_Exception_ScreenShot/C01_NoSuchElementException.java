package day13_Exception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NOSUCHELEMENTEXCEPTION
            Eğer bu exception'ı alıyorsak;
                1-Yanlış locate almış olabiliriz, dolayısıyla locate'i kontrol etmemiz gerekir
                2-Locate'ini aldığımız webelement iframe içindeyse ve iframe'e geçiş yapmazsak bu hatayı alırız
                3-Bazi sayfalarda locate etmek istediğimiz webelement sayfanın altında olabilir ve driver bunu
                göremeyebilir. Dolayısıyla scroll yaparak driver'a elementi göstererek bu hatayı handle ederiz
                4-Sayfadaki bir webelemente click yapma sonucunda yeni bir sayfa yada sekme açıldıysa ve yeni açılan
                sekmede yada pencerede driver'i yeni açılan bu sayfaya taşımazsak yeni açılan sayfadan bir webelementi
                locate ettiğimizde de bu hatayı alırız
         */
        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@id='sdasd']"));
        //Yukarıdaki örnekte yanlış locator kullanırsak --> InvalidSelectorException(yanlış locator) hatası alırız
        aramaKutusu.sendKeys("iphone");
    }

    @Test
    public void test02() {
        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("dfgdfgdfg"));//Bilerek yanliş locate aldık
        //Locate yanlış olduğu için NoSuchElementException hatası aldık
        //Bunu handle etmek için locate'in doğruluğunu kontrol ederiz
        aramaKutusu.sendKeys("iphone");
    }
}