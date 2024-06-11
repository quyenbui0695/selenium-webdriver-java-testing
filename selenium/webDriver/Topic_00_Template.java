package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser (){
        driver = new FirefoxDriver();
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