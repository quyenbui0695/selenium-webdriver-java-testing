package webDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Practice_03_Alert {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser (){
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_acceptAlert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");
    }

    @Test
    public void TC_02_confirmAlert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");


    }

    @Test
    public void TC_03_promptAlert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS prompt");
        alert.sendKeys("automationfc");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: automationfc");
    }
    @Test
    public void TC_04_authenticationAlert(){
        String username  = "admin";
        String password  = "admin";
        driver.get("https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.cssSelector("div.example>p")).getText().contains("Congratulations! You must have the proper credentials."));



    }

    @AfterClass
    public void cleanBrowser(){driver.quit();}
}