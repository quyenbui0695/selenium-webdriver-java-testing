package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_06_Practice_01 {
    WebDriver driver;
    Actions action;
    Random rand;
    Select select;
    String name, email, website, experience, comment;

    @BeforeClass
    public void initialBrowser (){
        driver = new ChromeDriver();
        action  = new Actions(driver);

        rand = new Random();
        name = "Automation";
        email = name + rand.nextInt(99999)+"@gmail.com";
        website = "http://automation.com";
        experience = "10+";
        comment = "nothing \n to comment";



    }

    @Test
    public void TC_01_completeSampleTestPage() {

        driver.get("https://www.globalsqa.com/");
        WebElement testerHub = driver.findElement(By.cssSelector("li#menu-item-2822"));
        action.moveToElement(testerHub).perform();
        driver.findElement(By.xpath("//span[text()='Sample Page Test']")).click();
        driver.findElement(By.cssSelector("input#g2599-name")).sendKeys(name);
        driver.findElement(By.cssSelector("input#g2599-email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#g2599-website")).sendKeys(website);
        //handle dropdown list
        select = new Select(driver.findElement(By.cssSelector("select.select")));
        select.selectByVisibleText(experience);
        Assert.assertEquals(select.getOptions().size(), 6);

        //handle checkbox
        WebElement expertise = driver.findElement(By.xpath("//input[@value= 'Functional Testing']"));

            expertise.click();

        Assert.assertTrue(expertise.isSelected());

        //handle radio button

        WebElement education = driver.findElement(By.xpath("//input[@value= 'Other']"));

        education.click();

       Assert.assertTrue(education.isSelected());

        //handle radio area textbox

        driver.findElement(By.cssSelector("textarea.textarea")).sendKeys(comment);
        driver.findElement(By.cssSelector("button.pushbutton-wide")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//blockquote[@class='contact-form-submission']/p[1]")).getText(), "Name: " + name);

    }






@AfterClass
public void cleanBrowser(){driver.quit();}
}
