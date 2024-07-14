package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_10_Fixed_Popup {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser (){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_fixedPopupInDOM() throws InterruptedException {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");
        Assert.assertTrue(driver.findElement(By.className("right")).isDisplayed());
        driver.findElement(By.id("user-login")).sendKeys("automation@gmail.com");
        driver.findElement(By.id("user-password")).sendKeys("123456");
        driver.findElement(By.id("btn-submit-login")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
    }

    @Test
    public void TC_02_fixedPopupNotInDOM() {
    driver.get("https://tiki.vn/");

    By popup = By.cssSelector("div.ReactModal__Content");

    driver.findElement(By.cssSelector("img[alt='close-icon']")).click();
    driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
    Assert.assertTrue(driver.findElement(popup).isDisplayed());
    driver.findElement(By.className("login-with-email")).click();
    driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")).getText(), "Email không được để trống");
    Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][2]")).getText(), "Mật khẩu không được để trống");
    driver.findElement(By.cssSelector("img.close-img")).click();
    Assert.assertEquals(driver.findElements(popup).size(), 0);

    }

    @Test
    public void TC_03_() {


    }

    @AfterClass
    public void cleanBrowser(){driver.quit();}
}