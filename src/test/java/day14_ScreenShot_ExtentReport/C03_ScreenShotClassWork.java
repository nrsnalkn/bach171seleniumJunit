package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://Techproeducation.com");

        //Events linkine tıklayalım
        WebElement eventsWE = driver.findElement(By.xpath("(//a[text()='Events'])[1]"));
        eventsWE.click();
        //Basliğin Events içerdiğini doğrulayalım
        Assert.assertTrue(driver.getTitle().contains("Events"));
        //Ve sayfanın resmini alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ekranGoruntusu/ekranGoruntusu" + tarih + ".jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");

        //Ve sayfanın resmini alalım
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String path = "target/ekranGoruntusu/ekranGoruntusu" + date + ".jpeg";
        FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(path));

        //Arama kutusunda iphone aratalım
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("iphone", Keys.ENTER);
        //Çıkan sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        String zaman = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String yol = "target/webElementEkranGoruntusu/ekranGoruntusu" + zaman + ".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(yol));
        //Techpro sayfasına geri dönelim
        window(0);
        //ve sayfanın resmini alalım
        TakesScreenshot takesScreenshotTecphro = (TakesScreenshot) driver;
        String date1 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String path1 = "target/ekranGoruntusu/ekranGoruntusu" + date1 + ".jpeg";
        FileUtils.copyFile(takesScreenshotTecphro.getScreenshotAs(OutputType.FILE), new File(path1));

    }

    @Test
    public void test02() {
        //Techproeducation sayfasına gidelim
        driver.get("https://Techproeducation.com");

        //Events linkine tıklayalım
        WebElement eventsWE = driver.findElement(By.xpath("(//a[text()='Events'])[1]"));
        eventsWE.click();
        //Basliğin Events içerdiğini doğrulayalım
        Assert.assertTrue(driver.getTitle().contains("Events"));
        //Ve sayfanın resmini alalım
        screenShot();

        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");

        //Ve sayfanın resmini alalım
        screenShot();
        //Arama kutusunda iphone aratalım
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("iphone", Keys.ENTER);
        //Çıkan sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        webElementScreenshot(sonucYazisi);
        //Techpro sayfasına geri dönelim
        window(0);
        //ve sayfanın resmini alalım
        screenShot();
    }
}
