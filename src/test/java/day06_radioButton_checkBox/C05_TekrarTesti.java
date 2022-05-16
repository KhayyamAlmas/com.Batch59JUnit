package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_TekrarTesti {
    WebDriver driver;

    @Before
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
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
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));

        // 5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella", Keys.ENTER);

        // 6- Bulunan sonuc sayisini yazdirin
        WebElement bulunanSonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String []arr=bulunanSonuc.getText().split(" ");
        System.out.println("Nutella aramasindan bulunan sonuc: "+arr[1]);

        // 7- Sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int actualNumber= Integer.parseInt(arr[1].replace(".",""));
        int expectedNumber= 10000000;
        Assert.assertTrue(actualNumber>expectedNumber);
        // 8- Sayfayi kapatin
    }
}
