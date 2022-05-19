package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test() throws InterruptedException {





        // facebook anasyafaya gidip
        driver.get("https://www.facebook.com");

        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate edip
       WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun

        Actions actions = new Actions(driver);
        actions.click(isimKutusu).
                sendKeys("Khayyam").
                sendKeys(Keys.TAB).
                sendKeys("Almas").
                sendKeys(Keys.TAB).
                sendKeys("0123456987").
                sendKeys(Keys.TAB).
                sendKeys("123456789ax").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("26").
                sendKeys(Keys.TAB).
                sendKeys("Ara").
                sendKeys(Keys.TAB).
                sendKeys("1988").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                perform();




        Thread.sleep(5000);
    }
}
