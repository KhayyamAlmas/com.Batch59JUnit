package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C01_handleWindows {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
       driver.quit();
    }

    @Test
    public void test() {
        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        /*
         CDwindow-BFD89C923D4AE3F5203A785F7E22C092 bu kod acilan sayfanin unique kodudur.
         Selenium sayfalar arasi geciste bu window handle degerini kullanir.
         Eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
         su anda bulundugumuz saayfaya gecmek istiyorsak
         driver.switchTo().window("CDwindow-BFD89C923D4AE3F5203A785F7E22C092");
         bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
         */

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarag acin
        WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
         Bu komutu kullandigimizda driver otomatik olarak olusturulan
         new tab'a gecer. Yeni tab'da gorevi gerceklestirmek icin
         adimlari bastan almamiz gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        // 4- yeni tab'da acilan urunun fiyatini yazdirin
        WebElement urunTitleElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getCurrentUrl());

        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());



    }
}
