package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_11_Random_Popup {
    WebDriver driver;


    @BeforeClass
    public void initialBrowser (){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_randomPopup_inDOM() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");
        By popup = By.cssSelector("div.pum-container");

        if (driver.findElements(popup).size() > 0 && driver.findElements(popup).get(0).isDisplayed()) {
            System.out.println("qua case 1");

            WebElement closeElement = driver.findElement(By.xpath("//button[@class='pum-close popmake-close']"));
           JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
           jsExcutor.executeScript("arguments[0].click();",closeElement);
            Thread.sleep(3000);

            Assert.assertFalse(driver.findElement(popup).isDisplayed());
        }
        System.out.println("qua case 2");
        driver.findElement(By.xpath("//li[@id='mega-menu-item-37434']/a[text()='Liên hệ']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.title-content h1")).getText(), "Liên Hệ");


    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {


    }

    @AfterClass
    public void cleanBrowser(){driver.quit();}
}