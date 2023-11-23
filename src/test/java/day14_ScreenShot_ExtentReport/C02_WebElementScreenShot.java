package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
         /*
             Eğer sadece bır webelementın resmını almak ıstersek
            o elementın locatını alıp WE.getScreenShotAs()
            methodu ıle webelementın resmını alabılırız.
        */
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda iphone aratalim
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("iphone", Keys.ENTER);

        //ekran resmini alalım
        screenShot();
        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/webElementEkranGoruntusu/WEscreenShot" + tarih + ".png";

        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));


    }

    @Test
    public void test02() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //ekran resmini alalım
        screenShot();

        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementScreenshot(sonucYazisi);
    }
}
