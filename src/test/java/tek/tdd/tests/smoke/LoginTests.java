package tek.tdd.tests.smoke;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.AuthenticateTestBase;
import tek.tdd.base.UITestBase;
import tek.tdd.pages.POMFactory;

public class LoginTests extends AuthenticateTestBase {

    @Test(testName = "success login to Customer Service Portal and validate title")
    public void successLoginToCSR() {
        factory.getLoginPage().getLogin("supervisor", "tek_supervisor");
        extentInfo("After click on Login will go to Customer Service Portal");
        waitTime(500);
        String actualCSRTitle = getElementText(factory.getHomePage().homePageTitle);
        assertEqual(actualCSRTitle, "Customer Service Portal", "User should be able to see the Customer service Portal title");
    }
    @Test(testName = "success login to Primary Account Portal and validate title")
    public void successLoginToPrimary() {
        primaryAccountLogin();
        extentInfo("After click on Login will go to Primary Account Portal");
        waitTime(500);
        String actualTitle = getElementText(factory.getLoginPage().homePageTitle);
        assertEqual(actualTitle, "Primary Account Portal", "User should be able to see the Primary Account Portal title");
    }

    @Test(dataProvider = "negativeData", testName = "Negative test both in CSR and Primary Account")
    public void NegativeLoginTest(String email, String password, String expectedError) {
       factory.getLoginPage().getLogin(email, password);
        extentInfo("After click on sign in the error message should be display");
        String actualErrorMessage = getElementText(factory.getLoginPage().errorMessageElement).replace("ERROR\n", "");
        assertEqual(actualErrorMessage, expectedError, "wrong username and password test");
    }

    // Data Provider is use for test with parameter and multiple data.
    @DataProvider(name = "negativeData")
    private String[][] negativeTestData() {
        String[][] testData = {
                {"WrongUsername", "tek_supervisor", "User WrongUsername not found"},
                {"supervisor", "WrongPassword", "Password not matched"},
                {"Morteza", "WrongPassword", "User Morteza not found"},
        };
        return testData;
    }
}
