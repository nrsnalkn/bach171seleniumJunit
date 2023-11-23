package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Bike {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
//        b.Search(ara) “city bike”
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("city bike", Keys.ENTER);
//        c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[text()='1-16 of 481 results for']"));
        System.out.println("aramaSonucu = " + aramaSonucu.getText());
        String aramaSonucSayisi[] = aramaSonucu.getText().split(" ");
        System.out.println("aramaSonucSayisi = " + aramaSonucSayisi[2]);

//        d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        WebElement firstImage = driver.findElement(By.className("s-image"));
        firstImage.click();
        driver.close();
    }
}
