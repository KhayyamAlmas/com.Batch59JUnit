package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DuolingoAssertions {
  static WebDriver driver;


    @BeforeClass
    public static void setUp() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.duolingo.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {


        // 1) Bir class oluşturun: DuolingoAssertions
        // 2) https://www.duolingo.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        // Sayfa URL’inin https://www.duolingo.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.duolingo.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @Test
    public void test02() {
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test03() {
        // logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoTest = driver.findElement(By.xpath("//img[@class='_1Iy-H']"));
        Assert.assertTrue(logoTest.isDisplayed());

    }
    @Test
    public void test04() {
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement linkTest=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(linkTest.isDisplayed());
    }
}
