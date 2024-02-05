package tek.tdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;
import tek.tdd.utility.SeleniumUtilities;

@Listeners(ExtentITestListenerClassAdapter.class)
public class UITestBase extends SeleniumUtilities {

    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeMethod
    public void initializeTest() {
        openBrowser();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }


    @AfterMethod
    public void testClosure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
            String screenshot = takesScreenshot.getScreenshotAs(OutputType.BASE64);
            ExtentTestManager.getTest().fail("Test failed Taking screen shot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot, "failed_test_screen_shot").build());
        }
        closeBrowser();
    }

}
