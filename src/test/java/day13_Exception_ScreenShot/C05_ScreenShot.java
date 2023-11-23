package day13_Exception_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        /*
    Bir sayfanın ekran görüntüsünü almak istersek;
    1-TakeScreenShot arayüsünden obje oluşturup bunu driver'a eşitleriz
    TakeScreenShot ts =(TakeScreenShot) driver;
    2-Almak istediğimiz ekran görüntüsünü kaydetmek istediğimiz yolu belirleriz
    3-FileUtils class'ından copyFile() methoduna parametre olarak oluşturmuş olduğumuz ts objesi ile
    getScreenShotAs() methonu kullanarak getScreenShotAs() methoduna da parametre olarak OutPutType.FILE
    seçerek bunu yeni bir dosyaya kaydetmesi için new File() diyerek almış olduğumuz dosyanın yolunu belirtiriz.
 */
        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        //Sayfanın ekran görüntüsünü alınız
        String dosyaYolu = "src/test/java/utilities/EkranGörüntüleri/amazonScreenShot.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;//cast 'ing yaptık
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {
        //techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");


        //Sayfanın resmini alınız
        String dosyaYolu = "target/screenShot/techproEducationScreenShot.png";
        TakesScreenshot ts = (TakesScreenshot) driver;//cast 'ing yaptık
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }


    @Test
    public void test03() throws IOException {
        //facebook sayfasına gidiniz
        driver.get("https://facebook.com");

        //Tüm sayfanın ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu = "target/screenShot/facebookScreenShot.png";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        //  screenShot(dosyaYolu);


    }
}
