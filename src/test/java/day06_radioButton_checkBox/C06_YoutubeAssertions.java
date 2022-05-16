package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_YoutubeAssertions {
  static  WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {


        // 1) Bir class oluşturun: YoutubeAssertions
        // 2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    public void test02() {

        // 3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        // titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    public void test03() {

        // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageTest = driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));
        Assert.assertTrue(imageTest.isDisplayed());
    }
    public void test04() {

        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxTest = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBoxTest.isEnabled());
    }
    public void test05() {

        // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedWrongTitle="youtube";
        String actualWrongTitle=driver.getTitle();
        Assert.assertFalse(actualWrongTitle.equals(expectedWrongTitle));
    }
}