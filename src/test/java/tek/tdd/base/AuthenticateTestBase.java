package tek.tdd.base;

public class AuthenticateTestBase extends UITestBase {
    public void csrLogin() {
        factory.getLoginPage().getLogin("supervisor", "tek_supervisor");
    }

    public void primaryAccountLogin() {
        factory.getLoginPage().getLogin("mori12345", "mori1234");
    }

    public void loginCSRAccounts() {
        csrLogin();
        factory.getCSRAccountsPage().clickOnAccounts();
        waitForSpinner();
    }
    public void waitForSpinner(){
        waitForSpinner(factory.getCSRAccountsPage().spinner);
    }

    public void plansLogin() {
        csrLogin();
        factory.getPlanCodePage().clickOnPlanLink();
        waitForSpinner();
    }

    public void logoutAccount() {
        click(factory.getLoginPage().logoutButton);
        String actualTitle = getElementText(factory.getHomePage().letsGetYouStartedTitle);
        assertEqual(actualTitle, "Lets get you started", "validate home page title - lets get you started");
        extentInfo("After clicking on logout button user should see the home page and title");
    }
}
