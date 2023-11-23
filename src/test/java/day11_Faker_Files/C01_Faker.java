package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {
    @Test
    public void name() {
        /*
            Faker class'ı ile sahte datalar oluşturabilmek için öncelikle mvnrepository.com adresinden github-javafaker
        dependency'i pom.xml dosyasına koymamız gerekiyor. Sonra Faker class'ından bir obje oluşturup fake datalar
        üretebiliriz.
        */

        Faker faker = new Faker();
        //faker objesi ile faker isim yazdırın
        System.out.println(faker.name().firstName());

        //faker objesi ile faker soyisim yazdırın
        System.out.println(faker.name().lastName());

        //faker objesi ile faker adres yazdırın
        System.out.println(faker.address().fullAddress());

        //faker objesi ile faker telefon no yazdırın
        System.out.println(faker.phoneNumber().phoneNumber());

        //faker objesi ile faker mail yazdırın
        System.out.println(faker.internet().emailAddress());

        //faker objesi ile 15 haneli bir sayı  yazdırın
        System.out.println(faker.number().digits(15));

    }
}
