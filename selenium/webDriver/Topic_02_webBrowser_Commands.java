package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_webBrowser_Commands {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser (){
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_verifyUrl() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']/a[text()='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");



    }

    @Test
    public void TC_02_verifyTitle() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']/a[text()='My Account']")).click();
        Assert.assertEquals(driver.getTitle(), "Customer Login");
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");


    }

    @Test
    public void TC_03_navigateFunction() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']/a[text()='My Account']")).click();
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }
    @Test
    public void TC_04_getPageSource() {
            driver.get("http://live.techpanda.org/");
            driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']/a[text()='My Account']")).click();

            Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
            driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
            Assert.assertTrue(driver.getPageSource().contains("Create an Account"));




        }



    @AfterClass
    public void cleanBrowser(){driver.quit();}
}