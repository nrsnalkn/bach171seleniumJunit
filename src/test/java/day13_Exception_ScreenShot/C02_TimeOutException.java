package day13_Exception_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;


public class C02_TimeOutException extends TestBase {
    @Test
    public void test01() {
        /*
        TIMEOUTEXCETION
            Eğer TimeOutException hatası alıyorsak;
                1-Explicit wait'te kullandığımız max. süreyi kontrol etmeliyiz
                2-Explicit wait ile aldığımız locate'i kontrol etmeliyiz
                3-Explicit wait ile kullandığımız method'u kontrol etmemiz gerekir
                4-Explicit wait ile locate ettiğimiz webelement iframe içinde olabilir. Dolayısıyla
                iframe'e geçiş yapmamız gerekir.
         */
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        //-->TimeOutException almak için (Duration.ofSeconds(2)) max. süreyi 2 saniye yaptık
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));
        Assert.assertEquals("Hello World!",helloWorldWE.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("fsdfsdfs")));
        //Süre doğru fakat locate yanlış olduğu için TimeoutException aldık
        Assert.assertEquals("Hello World!",helloWorldWE.getText());
    }
}