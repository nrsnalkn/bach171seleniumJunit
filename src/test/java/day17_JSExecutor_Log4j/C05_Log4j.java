package day17_JSExecutor_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Log4j extends TestBase {
    @Test
    public void test01() {
         /*
        1-Log4j kullanabilmek için öncelikle log4j-core ve log4j-api dependency'leri pom.xml dosyasına koyarız
        2-src>main>resorces altında log4j2.xml isimli dosyayı oluşturup pdf teki yada yine pdf te belirtilen
        adresten xml kodlarını bu dosyanın içine koyarız.
        3-Info bilgilerini her stepten sonra yazdırabilmek için Logger arayüzünden bir obje oluşturup
        bunu LogManager class'ından getLogger methoduna eşitler bu method içene class'ımızı belirtiriz.
         */
        Logger logger = LogManager.getLogger(C05_Log4j.class);
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        logger.info("Kullanici amazon Sayfasina gider");

        //arama kutusunda java aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("Kullanici arama kutusunu locate etti");
        aramaKutusu.sendKeys("java", Keys.ENTER);
        logger.info("Kullanici arama kutusunda java aratir");
    }
}
