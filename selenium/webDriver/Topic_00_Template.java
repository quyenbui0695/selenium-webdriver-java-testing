package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser (){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_() {


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