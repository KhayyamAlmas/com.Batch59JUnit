package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_TekrarTesti {
    WebDriver driver;

    @BeforeClass
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {

        // 1- C05_TekrarTesti isimli bir class olusturun
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        // 3- cookies uyarisini kabul ederek kapatin
        // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        // 5- Arama cubuguna “Nutella” yazip aratin
        // 6- Bulunan sonuc sayisini yazdirin
        // 7- Sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        // 8- Sayfayi kapatin
    }
}
