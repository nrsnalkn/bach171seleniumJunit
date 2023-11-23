package day14_ScreenShot_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtentReport extends TestBase {
    ExtentReports extentReport;//raporlamayı başlatır
    ExtentHtmlReporter extentHtmlReporter; // html formatında rapor oluşturur
    ExtentTest extentTest;//test adımlarına bilgi ekler

    @Test
    public void test1() {
        /*
        EXTENTREPORT
    1-ExtentReport kullanabilmek için öncelikle mvn repository adresinden extentReport araması yapıp
    com.aventstack » extentreports seçip, 4.0.9 uncu versiyonu alıp pom.xml dosyamıza koymalıyız.
    2-ExtentReport class'ından raporlamayı başlatması için bir obje oluşturmamız gerekir.
    3-ExtentHtmlReporter class'ından raporları html formatında oluşturması için bir obje oluşturmalıyız
    4-ExtentTest class'ından test adımlarına bilgi ekleyebilmemiz için bir obje oluştururuz
    */
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report" + tarih + ".html";

        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester", "Nursen");
        extentReport.setSystemInfo("Browser", "Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName("Smoke Test");

        extentTest = extentReport.createTest("AmazonTest", "Test Raporu");

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanıcı amazon sayfasına gider");
        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Kullanıcı arama kutusunun locet ini alır");
        aramaKutusu.sendKeys("iphone",Keys.ENTER);
        extentTest.info("Kullanıcı arama kutusunda iphone aratır");
        //ekran resmini alalım
        screenShot();
        extentTest.info("Kullanıcı kullanıcı ekran görüntüsünü alır");
        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        extentTest.info("Kullanıcı sonuc yazısının locet ini alır");
        webElementScreenshot(sonucYazisi);
        extentTest.pass("Kullanıcı sonuc yazısının ekran resmini alır");
        extentReport.flush();// extent report u oluşturmak için flush() methodu ile bitirmek gerekiyor




    }
}
