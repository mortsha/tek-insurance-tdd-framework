package tek.tdd.utility;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tek.tdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtilities extends BaseSetup {

    private static final Logger LOG = LogManager.getLogger(SeleniumUtilities.class);

    public void extentInfo(String string) {
        ExtentTestManager.getTest().info(string);
    }
    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public WebElement waitTillVisible(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitTillClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getElementText(WebElement element) {
        return waitTillVisible(element).getText();
    }

    public void click(WebElement element) {
        waitTillClickable(element).click();
    }

    public void sendText(WebElement element, String text) {
        waitTillVisible(element).sendKeys(text);
    }

    public boolean isElementDisplayed(WebElement element) {
        return waitTillVisible(element).isDisplayed();
    }

    public void waitTime(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    public void assertEqual(String actual, String expected, String message) {
        reportAndLog("Asserting actual " + actual + " expected " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    public void assertEqual(int actual, int expected, String message) {
        reportAndLog("Asserting actual " + actual + " expected " + expected);
        Assert.assertEquals(actual, expected, message);

    }

    public void reportAndLog(String text) {
        LOG.info(text);
        ExtentTestManager.getTest().info(text);
    }

    public void selectByDropdown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByDropdown(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void waitForSpinner(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }
    public void logInfo(String text){
        LOG.info(text);
    }
}


