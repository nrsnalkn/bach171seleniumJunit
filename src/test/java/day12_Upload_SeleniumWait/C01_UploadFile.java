package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_UploadFile extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSecWE= driver.findElement(By.id("file-upload"));
       // dosyaSecWE.click();
        //"C:\Users\Administrator\Desktop\tests.txt"
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu ="C:\\Users\\Administrator\\Desktop\\tests.txt";
        dosyaSecWE.sendKeys(dosyaYolu);

        //uploadFilePath(dosyaYolu);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        String actualText=driver.findElement(By.xpath("//h3")).getText();
        String expecdetText="File Uploaded!";
        Assert.assertEquals(expecdetText,actualText);
    }

    @Test
    public void test02() {
        driver.get("https://www.ilovepdf.com/compress_pdf");
        driver.findElement(By.xpath("//*[.='Select PDF files']")).click();

        String dosyaYolu ="C:\\Users\\Administrator\\Desktop\\tests.txt";
        uploadFilePath(dosyaYolu);
         /*
            Upload file yaparken sendKeys() methodunun işlemediği durumlarda TestBase class'ında oluşturduğumuz
         uploadFilePath() methodu ile dosyayı çok rahat yükleyebiliriz. Bu methodu kullanırken manuel olarak
         mause ve klavyeyi test esnasında hiçbir şekilde kullanmamamız gerekir. Mac kullanıcıları windows'taki
         ctrl+v tuş kombinasyonunun karşılık geldiği tuş kombinasyonunu Robot class'a belirtmesi gerekir.
         TestBase deki uploadFilePath() methodu sadece windows kullanıcıları için geçerlidir.
         */
    }
}
