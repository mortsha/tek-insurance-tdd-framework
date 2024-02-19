package tek.tdd.pages;

import tek.tdd.base.AuthenticateTestBase;

public class POMFactory {
    public LoginPage getLoginPage() {
        return new LoginPage();
    }

    public HomePage getHomePage() {
        return new HomePage();
    }

    public CreateAccountPage getCreateAccountPage() {
        return new CreateAccountPage();
    }

    public PlanCodePage getPlanCodePage() {
        return new PlanCodePage();
    }

    public UserProfilePage getUserProfilePage() {
        return new UserProfilePage();
    }

    public CSRAccountsPage getCSRAccountsPage() {
        return new CSRAccountsPage();
    }
}
