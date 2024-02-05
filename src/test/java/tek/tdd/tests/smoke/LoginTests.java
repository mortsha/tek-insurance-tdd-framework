package tek.tdd.tests.smoke;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UITestBase;
import tek.tdd.pages.LoginPage;

public class LoginTests extends UITestBase {

    /*TestCase 1)
    Navigate to login by clicking on Login button and enter valid csr user
    Username: supervisor
    Password: tek_supervisor
    And validate user navigate to Customer Service Portal */

    @Test
    public void validateSuccessLogin() {
        click(loginPage.loginButton);
        sendText(loginPage.userNameInput, "supervisor");
        sendText(loginPage.passwordInput, "tek_supervisor");
        click(loginPage.signInButton);

        ExtentTestManager.getTest().info("After click on Login will go to Customer Service Portal");

        String actualCSRTitle = getElementText(loginPage.csrTitle);
        Assert.assertEquals(actualCSRTitle, "Customer Service Portal", "User should be able to see the Customer service Portal title");
    }
    @Test(dataProvider = "negativeData")
    public void NegativeLoginTest(String email, String password, String expectedError) {
        click(loginPage.loginButton);
        sendText(loginPage.userNameInput, email);
        sendText(loginPage.passwordInput, password);
        click(loginPage.signInButton);

        extentInfo("After click on sign in the error message should be display");
        extentInfo1("After click on sign in the error message should be display - Method void");

        String actualErrorMessage = getElementText(loginPage.errorMessageElement);
        Assert.assertEquals(actualErrorMessage,expectedError, "wrong username and password test");

    }


    // Data Provider is use for test with parameter and multiple data.
    @DataProvider(name = "negativeData")
    private String[][] negativeTestData() {
        String[][] testData = {
                {"WrongUsername", "tek_supervisor", "ERROR\n" + "User WrongUsername not found"},
                {"supervisor", "WrongPassword", "ERROR\n" + "Password not matched"},

        };
        return testData;
    }
}
