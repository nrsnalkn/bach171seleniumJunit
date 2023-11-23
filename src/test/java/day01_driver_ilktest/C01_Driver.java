package day01_driver_ilktest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Driver {
    public static void main(String[] args) {
        /*
    Ilk olarak class'ımıza drivers package'ı altındaki driver'ın fiziki yolu tanımlamamız gerekiyor
    Bunun için javadan System.setProperty() methodu ile driver'ın yolunu(chromeDriver.exe dosyasına sağ klik
    yapıp copy/path sekmesine tıklayıp path from content root ile yolunu alırız) kopyalarız.
    System.setProperty() java uygulamalarında sistem özelliklerini ayarlamak için kullanılır
 */
        System.setProperty("chromeDriver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr");
    }
}
