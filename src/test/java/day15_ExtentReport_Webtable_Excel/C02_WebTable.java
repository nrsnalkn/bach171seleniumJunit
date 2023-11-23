package day15_ExtentReport_Webtable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Table1’i print edin
        WebElement tablo1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo1 : " + tablo1.getText());
        //Task 2 : 3. Row' datalarını print edin
        WebElement ucuncuRowData = driver.findElement(By.xpath("(//tbody)[1]/tr[3]"));
        System.out.println("3. Row : " + ucuncuRowData.getText());
        //Task 3 : Son row daki dataları print edin
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]/tr[last()]"));
        /*
        xpath kullanımında eğer b,r webtable da son satır istenrse yukarıdaki
        örnekteki gibi satır içindeki index yerine last() kullanabilirsiniz
        */
        System.out.println("son satır : " + sonSatir.getText());
        //Task 4 : 5. Column datalarini print edin
        WebElement besinciColum = driver.findElement(By.xpath("(//thead)[1]//tr/th[5]"));
        System.out.println("beşinci sütun : " + besinciColum.getText());

        List<WebElement> besinciSutunData = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutunData.forEach(e -> System.out.println("besinci Sutun Data : " + e.getText())); // lambda ile çözümü
//        for (WebElement w : besinciSutunData){
//            System.out.println("besinci Sutun Data : " + w.getText());
//        }


        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin
        printData(2, 3);
    }

    private void printData(int row, int column) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[" + row + "]//td[" + column + "]"));
        System.out.println("2. satır 3. data : " + satirSutun.getText());
    }
     /*
    ÖDEV:
    3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız. //-->position()>=1 and position()<=2
    */


}
