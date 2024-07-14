package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_Frame_Iframe {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser (){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void TC_01_iFrame() {
    driver.get("https://toidicodedao.com/");
    driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[data-testid='fb:page Facebook Social Plugin']")));
        Assert.assertEquals(driver.findElement(By.cssSelector("div._1drq")).getText(), "405,993 followers");
    }

    @Test
    public void TC_02_iFrame() throws InterruptedException {
    driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
    driver.findElement(By.cssSelector("li#iFrame")).click();
    driver.switchTo().frame("globalSqa");
    driver.findElement(By.name("s")).sendKeys("abc");
    driver.findElement(By.cssSelector("button.button_search")).click();
    Assert.assertEquals(driver.findElements(By.cssSelector("div.post_item h3")).size(), 2);





    }



    @AfterClass
    public void cleanBrowser(){driver.quit();}
}