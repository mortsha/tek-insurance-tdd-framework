package tek.tdd.utility;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.tdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtilities extends BaseSetup {



    public String extentInfo(String string){
        return ExtentTestManager.getTest().info(string).toString();
    }
    public void extentInfo1(String string){
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

    public void sendText(WebElement element, String text){
        waitTillVisible(element).sendKeys(text);
    }
    public boolean isElementDisplayed(WebElement element){
        return waitTillVisible(element).isDisplayed();
    }
}
