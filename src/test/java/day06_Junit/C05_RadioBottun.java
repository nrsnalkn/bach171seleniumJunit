package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioBottun {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void radioButton() {
        //https://www.facebook.com adresine gidin
        //Cookies'i kabul edin
        //"Create an Account" button'una basin
        WebElement newCreate = driver.findElement(By.xpath("(//*[@role='button'])[2]"));
        newCreate.click();
        //"radio buttons" elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement male = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement costum = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));
        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!female.isSelected()) {
            female.click();
        }
    }
}
