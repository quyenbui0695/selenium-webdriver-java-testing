package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_07_Practice_02_Custom_Dropdownlist {
    WebDriver driver;
    WebDriverWait wait;



    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInCustomDropdown("span#speed-button", "ul#speed-menu>li>div", "Slow");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Slow");

        selectItemInCustomDropdown("span#speed-button", "ul#speed-menu>li>div", "Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Faster");
    }
    @Test
    public void TC_02() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInCustomDropdown("span#number-button", "ul#number-menu>li>div", "19");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "19");

    }

    @Test
    public void TC_03() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInCustomDropdown("i.dropdown", "div.item>span", "Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui>div[role='alert']")).getText(), "Justen Kitsune");
        Thread.sleep(3000);
    }

    @Test
    public void TC_04() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInCustomDropdown("span.caret", "ul.dropdown-menu>li>a", "Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
        Thread.sleep(3000);
    }
    @Test
    public void TC_05() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInCustomDropdown("input.search", "div.visible>div>span", "Benin");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), "Benin");
        Thread.sleep(3000);
    }

    public void selectItemInCustomDropdown(String parentLocator, String childLocator, String clickedItem) {

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(parentLocator)))).click();
        List<WebElement> allItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
        for (WebElement item : allItems) {

            if (item.getText().equals(clickedItem)) {
                wait.until(ExpectedConditions.elementToBeClickable(item));
                item.click();
                break;

            }
        }
    }
        public void selectItemInEditableDropdown (String parentCss, String childCss, String slectedItem) {

            wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(parentCss)))).sendKeys(slectedItem);
            List<WebElement> allItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
            for (WebElement item : allItems) {

                if (item.getText().equals(slectedItem)) {
                    wait.until(ExpectedConditions.elementToBeClickable(item));
                    item.click();
                    break;

                }
            }

    }
    @AfterClass
    public void cleanBrowser(){driver.quit();}
}
