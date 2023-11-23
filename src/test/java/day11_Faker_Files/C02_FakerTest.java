package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import utilities.TestBase;


public class C02_FakerTest extends TestBase {
    @Test
    public void faker() {
        Faker faker = new Faker();

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //"create new account"  butonuna basin

        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        bekle(2);

        //"firstName" giris kutusuna bir isim yazin
        //"surname" giris kutusuna bir soyisim yazin
        //"email" giris kutusuna bir email yazin
        //"email" onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        String fakerMail = faker.internet().emailAddress();
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, fakerMail);
        bekle(2);
        firstName.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, fakerMail, Keys.TAB, faker.internet().password(),
                Keys.TAB, Keys.TAB, "20", Keys.TAB, "May", Keys.TAB, "2008", Keys.TAB, Keys.TAB, Keys.SPACE, Keys.ENTER);


        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@value='1'])[1]")).isSelected());
    }
}
