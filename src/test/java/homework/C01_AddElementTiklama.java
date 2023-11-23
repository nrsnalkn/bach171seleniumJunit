package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_AddElementTiklama {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //  https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //Add Element butonuna basin 100 kez basınız
        WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 1; i < 101; i++) {
            addElement.click();

        }
        Thread.sleep(2000);
        // Delete butonuna 90 kez basınız
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));
        int count = 0;

        for (int i = 1; i < 91; i++) {

            deleteButton.click();
            count++;

        }
        //Ve 90 kez basıldığını doğrulayınız
        if (count == 90) {
            System.out.println("Delete buttonu 90 kere tıklandı ");
        } else {
            System.out.println("Delete buttonu 90 kere tıklanmadı ");
        }
        //sayfayı kapat
        driver.close();

    }
}
