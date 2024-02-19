package tek.tdd.tests.regression;

import org.testng.annotations.Test;
import tek.tdd.base.AuthenticateTestBase;

public class CSRAccountsTest extends AuthenticateTestBase {
    @Test(testName = "Login with CSR from Accounts section verify 5 rows")
    public void testPrimaryAccountsVerifyRows() {
        loginCSRAccounts();
        assertEqual(factory.getCSRAccountsPage().getAccountsTableRows(), 5, "Validate table rows of accounts section to be 5");
    }

    @Test(testName = "Login with CSR from Accounts section change show to 10,25,50 and validate records per selected")
    public void testPrimaryAccountsValidateRecords() {
        loginCSRAccounts();
        factory.getCSRAccountsPage().dropdownWithRecords(10);
        factory.getCSRAccountsPage().dropdownWithRecords(25);
        factory.getCSRAccountsPage().dropdownWithRecords(50);
    }
}
