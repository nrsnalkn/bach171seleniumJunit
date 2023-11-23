package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {

        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        /*
            Cell değişkenini String ile casting yaparsak belittiğimiz satır ve sütunda boş bir veri varsa null değer
        döndürür. Ama Cell değişkeninde toString() methodu kullanırsak boş bir veri varsa nullpointerException fırlatır.
         */
        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3Sutun1);

        Assert.assertEquals("France", satir3Sutun1);

        //Kullanılan satır sayısın bulun
        /*
        getPhysicalNumberOfRows() methodu içi dolu olan satirlarin sayısını verir. Index 1 den başlar
         */
        System.out.println("Kullanilan Satir Sayisi : "+workbook.getSheet("sheet1").getPhysicalNumberOfRows());

        //Sayfadaki satır sayısını yazdırınız
        System.out.println("Sayfadaki Satir Sayisi : " + workbook.getSheet("Sheet1").getLastRowNum());
        /*
        getLastRowNum() methodu sayfadaki dolu boş farketmeksizin en son kullanılan satıra kadar olan satırların sayısını verir
         */
        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {//satir icin
            for (int j = 0; j <workbook.getSheet("sheet1").getRow(0).getPhysicalNumberOfCells() ; j++) {//kullanilan hucreleri aldik
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j) + "\t");

            }
            System.out.println(); //alt alta yzdirmak icin yazildi

        }


    }

    @Test
    public void test02() throws IOException {
        //Ülke-Başkent şeklinde verileri yazdırın (map ile)
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx"); //akisa aldik
        Workbook workbook =WorkbookFactory.create(fis); // Excele cevirdik
        Map<String, String> ulkeBaskent = new HashMap<>();
        for (int i = 0; i <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {
            String ulke = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir =workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir + "\n");
        }
        System.out.println(ulkeBaskent);
        }

    }

