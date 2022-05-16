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

public class C07_YoutubeAssertions {
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


        // 1) Bir class oluşturun: YoutubeAssertions
        // 2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

        // 3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        // titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertTrue("Sayfa Basligi testi FAILED",actualTitle.contains(expectedTitle));

        // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageTest= driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));
        Assert.assertTrue("YouTube resm testi FAILED", imageTest.isDisplayed());

        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxTest=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("Search Box testi FAILED",searchBoxTest.isEnabled());

        // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedWrongTitle="youtube";
        String actualWrongTitle=driver.getTitle();
        Assert.assertFalse("Sayfa Basligi testi PASSED",actualWrongTitle.equals(expectedWrongTitle));
    }
}