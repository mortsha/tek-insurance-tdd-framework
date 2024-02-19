package tek.tdd.tests.regression;

import org.testng.annotations.Test;
import tek.tdd.base.AuthenticateTestBase;
import tek.tdd.base.UITestBase;
import tek.tdd.utility.SeleniumUtilities;

public class UserProfileTest extends AuthenticateTestBase {
    @Test(testName = "Login with CSR and validate the profile side drawer information ")
    public void validateProfileCSR() {
        csrLogin();
        click(factory.getUserProfilePage().profileButton);
        extentInfo("After clicking on profile button the profile side drawer with user information should displayed");
        factory.getUserProfilePage().validateUserProfile("Active","CSR","Supervisor","supervisor","admin");
        logoutAccount();
    }

    @Test(testName = "Login to primary account and validate the profile side drawer information")
    public void validateProfileWithPrimaryAccount(){
        primaryAccountLogin();
        click(factory.getUserProfilePage().profileButton);
        extentInfo("After clicking on profile button the profile side drawer with user information should displayed");
        factory.getUserProfilePage().validateUserProfile("Active","CUSTOMER","Test User","mori12345","customer");
        logoutAccount();
    }
}
