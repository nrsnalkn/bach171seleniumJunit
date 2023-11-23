package homework;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel01 {
    @Test
    public void test01() throws IOException {
    //        odev1
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
    //-1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));
    //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1Sutun2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(satir1Sutun2);
    //-2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim
        String afganistanBaskenti = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil",afganistanBaskenti);

    //-Satir sayisini bulalim
        System.out.println("Satir sayisi : " + workbook.getSheet("Sayfa1").getLastRowNum());

        //-Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Fiziki olarak kullanilan satir sayisi : " + workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ingilizceUlkeBaskent = new HashMap<>();
        for (int i = 0; i <workbook.getSheet("Sayfa1").getPhysicalNumberOfRows() ; i++) {
            String ingilizceUlke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String ingilizceBaskent = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ingilizceUlkeBaskent.put(ingilizceUlke,ingilizceBaskent +"\n");
        }
        System.out.println(ingilizceUlkeBaskent);
    }
}
