package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_04_Textbox_Textarea_01 {
    WebDriver driver;
    String firstName, lastName, fullName, emailAddress, password;
    Random rand;

    @BeforeClass
    public void initialBrowser (){
        driver = new FirefoxDriver();
        rand = new Random();

    firstName = "auto";
    lastName = "testing";
    fullName = firstName + " " + lastName;
    emailAddress  = firstName + lastName + rand.nextInt(99999) + "@gmail.com";
    password = "123456789@";
    }

    @Test
    public void TC_01_liveTechpanda/() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']/a[text()='My Account']")).click();
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.xpath("//span[text()='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']//parent::div//following-sibling::div/p")).getText().contains(fullName) && driver.findElement(By.xpath("//h3[text()='Contact Information']//parent::div//following-sibling::div/p")).getText().contains(emailAddress));
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.xpath("//input[@id='Quality 1_5']")).click();
        driver.findElement(By.id("review_field")).sendKeys("Good application\n" +
                "Pretty easy to navigate.");
        driver.findElement(By.id("summary_field")).sendKeys("Good Phone");
        driver.findElement(By.id("nickname_field")).clear();
        driver.findElement(By.id("nickname_field")).sendKeys("Mint");
        driver.findElement(By.xpath("//span[text()='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Your review has been accepted for moderation.");
        driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//li[@class=' last']/a[text()='Log Out']")).click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }



    //@AfterClass
    //public void cleanBrowser(){driver.quit();}
}