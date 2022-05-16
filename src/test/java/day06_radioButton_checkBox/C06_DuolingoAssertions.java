package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DuolingoAssertions {
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


        // 1) Bir class oluşturun: BestBuyAssertions
        // 2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.duolingo.com/");

        // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl="https://www.duolingo.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("Url beklenenden farkli",expectedUrl,actualUrl);

        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse("Sayfa Basligi testi PASSED",actualTitle.contains(expectedTitle));

        // logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoTest= driver.findElement(By.xpath("//img[@class='_1Iy-H']"));
        Assert.assertTrue("Duolingo logosu FAILED", logoTest.isDisplayed());


        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement linkTest=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue("Fransizca linki FAILED",linkTest.isDisplayed());
    }
}
