package tek.tdd.tests.smoke;

import org.testng.annotations.Test;
import tek.tdd.base.UITestBase;
import tek.tdd.utility.FakeData;

public class CreateAccountTests extends UITestBase {
    @Test(testName = "from homepage and create account page validate titles")
    public void validateCreatePrimaryAccountTitle() {
        String actualHomePage = getElementText(factory.getHomePage().homePageTitle);
        assertEqual(actualHomePage, "TEK Insurance App", "validate top left corner title");
        click(factory.getHomePage().createPrimaryAccountButton);
        extentInfo("After clicking on create account button should go to create account form");
        String actualCPAHTitle = getElementText(factory.getHomePage().createPrimaryAccountHolderTitle);
        assertEqual(actualCPAHTitle, "Create Primary Account Holder", "validate create primary account holder title");
    }

    @Test(testName = "fill the create account form and validate the info in sign up page")
    public void testCreateAccountAndValidate() {
        factory.getCreateAccountPage().clickOnCreateAccount();
        String firstName = fakeData.getFirstName();
        String lastName = fakeData.getLastName();
        String fullName = firstName + " " + lastName;
        String email = fakeData.getEmail(firstName, lastName);
        factory.getCreateAccountPage().createAccountForm(email, firstName, lastName, "Mr.", "Male", "Single", "Tester", "01/01/1988");
        extentInfo("After filling the create account form and clicking on create account the sing up page should be displayed");
        String actualSection = getElementText(factory.getCreateAccountPage().singUpSectionTitle);
        assertEqual(actualSection, "Sign up your account", "Validate Sign up your account title in Sign up form");

        String actualFullName = getElementText(factory.getCreateAccountPage().validateFullNameSection);
        assertEqual(actualFullName, fullName, "Validate fullName as expected");
        String actualEmail = getElementText(factory.getCreateAccountPage().validateEmailSection);
        assertEqual(actualEmail, email, "Validate email as expected");
    }

    @Test(testName = "Create account with existing email and validate error message")
    public void testNegativeWithErrorMessage() {
        factory.getCreateAccountPage().clickOnCreateAccount();
        String email = "MortezaAutumn5106@happy.org";
        factory.getCreateAccountPage().createAccountForm(email, "morteza", "Autumn", "Mr.", "Male", "Single", "Tester", "01/01/1988");
        extentInfo("After filling the form with existing email the error message should displayed");
        String actualError = factory.getLoginPage().getErrorMessage().replace("ERROR\n", "");
        assertEqual(actualError, "Account with email " + email + " is exist", "Validate Error message with existing email address");
    }

    @Test(testName = "Create account end to end")
    public void createAccountE2E() {
        factory.getCreateAccountPage().clickOnCreateAccount();
        String firstName = fakeData.getFirstName();
        String lastName = fakeData.getLastName();
        String email = fakeData.getEmail(firstName, lastName);
        factory.getCreateAccountPage().createAccountForm(email, firstName, lastName, "Mr.", "Male", "Single", fakeData.getJobPosition(), fakeData.getDate());
        extentInfo("After filling the create account form and clicking on create account the sing up page should be displayed");
        String actualSection = getElementText(factory.getCreateAccountPage().singUpSectionTitle);
        assertEqual(actualSection, "Sign up your account", "Validate Sign up your account title in Sign up form");
        String username = email.substring(0, email.indexOf('@'));
        System.out.println(username);
        String password = fakeData.generatePassword(firstName, lastName);
        System.out.println(password);
        factory.getCreateAccountPage().signUpAccount(username, password, password);
        waitTime(3000);
        factory.getCreateAccountPage().signInAccount(username,password);
        String actualTitle = getElementText(factory.getCreateAccountPage().portalTitle);
        assertEqual(actualTitle,"Primary Account Portal", "Validate Primary Account Portal title");

    }
}
