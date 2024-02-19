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
import tek.tdd.pages.*;
import tek.tdd.utility.FakeData;
import tek.tdd.utility.DateUtility;
import tek.tdd.utility.SeleniumUtilities;

@Listeners(ExtentITestListenerClassAdapter.class)
public class UITestBase extends SeleniumUtilities {
   public POMFactory factory = new POMFactory();
   public FakeData fakeData = new FakeData();
   public DateUtility dateUtility = new DateUtility();
//    public HomePage homePage;
//    public LoginPage loginPage;
//    public PlanCodePage planCodePage;
//    public CreateAccountPage createAccountPage;
//    public UserProfilePage userProfilePage;

    @BeforeMethod
    public void initializeTest() {
        openBrowser();

//        this.homePage = new HomePage();
//        this.loginPage = new LoginPage();
//        this.planCodePage = new PlanCodePage();
//        this.createAccountPage = new CreateAccountPage();
//        this.userProfilePage = new UserProfilePage();
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
