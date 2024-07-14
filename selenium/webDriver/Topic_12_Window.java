package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_12_Window {
    WebDriver driver;




    @BeforeClass
    public void initialBrowser (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_switchWindowByID() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        String parentID = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();

        Set<String> allWindowID = driver.getWindowHandles();

        for (String windowID : allWindowID) {
            if (!windowID.equals(parentID)) {
                driver.switchTo().window(windowID);
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(), "Google");


    }
    @Test
    public void TC_02_switchWindowByTittle () {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        String parentID = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
        switchWindowByTitle("Google");
        Assert.assertEquals(driver.getTitle(), "Google");
        switchWindowByTitle("Selenium WebDriver");
        driver.findElement(By.xpath("//a[text() = 'FACEBOOK']")).click();
        switchWindowByTitle("Facebook – log in or sign up");
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
        switchWindowByTitle("Selenium WebDriver");
        driver.findElement(By.xpath("//a[text() = 'TIKI']")).click();
        switchWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
        Assert.assertEquals(driver.getTitle(), "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
        closeAllWindowExceptParent(parentID);
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");

    }
    @Test
    public void TC_03_switchWindowByTittle () {
     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//a[text()='Mobile']")).click();
     driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
     Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");
     driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
     Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");
     driver.findElement(By.xpath("//button[@title='Compare']")).click();
     switchWindowByTitle ("Products Comparison List - Magento Commerce");
     Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
     driver.close();
     switchWindowByTitle ("Mobile");
     driver.findElement(By.xpath("//a[text()='Clear All']")).click();
     driver.switchTo().alert().accept();
     Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The comparison list was cleared.");


    }



public void switchWindowByTitle(String title) {
        Set<String> allWindowID = driver.getWindowHandles();
        for (String runWindow : allWindowID) {
            driver.switchTo().window(runWindow);
            String currentTitle = driver.getTitle();
            if (currentTitle.equals(title)) {
                break;
            }
        }
    }
public void closeAllWindowExceptParent (String parentID) {
                Set<String> allWindowID = driver.getWindowHandles();
                for (String runWindow : allWindowID) {
                    if (!runWindow.equals(parentID)) {
                        driver.switchTo().window(runWindow);
                        driver.close();

                    }

            }

    driver.switchTo().window(parentID);

}


    @AfterClass
    public void cleanBrowser(){driver.quit();}

}