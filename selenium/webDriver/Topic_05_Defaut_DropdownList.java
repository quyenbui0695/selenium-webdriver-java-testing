package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Topic_05_Defaut_DropdownList {
    WebDriver driver;
    Select select;
    Random rand;
    String firstName, lastName, day, month, year, email, company, password;
    private Object If;


    @BeforeClass
    public void initialBrowser (){
        driver = new ChromeDriver();
        rand = new Random();
        firstName = "John";
        lastName = "Gorden";
        day = "22";
        month = "May";
        year = "1995";
        email = firstName + rand.nextInt(99999) + "@gmail.com";
        company = "Hutech Inc";
        password = "abc@123";
    }



    @Test
    public void TC_01_nopcommerce() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        select = new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
        select.selectByVisibleText(day);
        Assert.assertEquals(select.getOptions().size(), 32);
        select = new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
        select.selectByVisibleText(month);
        Assert.assertEquals(select.getOptions().size(), 13);
        select = new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
        select.selectByVisibleText(year);
        Assert.assertEquals(select.getOptions().size(), 112);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(company);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-body>div.result")).getText(), "Your registration completed");
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), email);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), company);

        Assert.assertEquals(new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(), year);


    }

    @Test
    public void TC_02_rode() throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");
        select = new Select (driver.findElement(By.cssSelector("select#country")));
        Assert.assertFalse(select.isMultiple());
        select.selectByVisibleText("Vietnam");
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("Ho Chi Minh");
        driver.findElement(By.cssSelector("button.btn-default")).click();
        Thread.sleep(5000);
        List <WebElement> dealer = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(dealer.size(), 16);
        for (WebElement element : dealer ) {
            System.out.println(element.getText());

        }

    }



    @AfterClass
    public void cleanBrowser(){driver.quit();}
}