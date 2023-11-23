package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @After
    public void tearDown() throws Exception {
           driver.close();
    }

    @Test
    public void checkBox() {

//    Verilen web sayfasına gidin.
//        https://the-internet.herokuapp.com/checkboxes

//        Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
//        Checkbox1 seçili değilse onay kutusunu tıklayın

        if (!checkBox1.isSelected()) {
            checkBox1.click(); //seçili değilse
        }


//        Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()) {

            checkBox2.click();
        }


    }
}
