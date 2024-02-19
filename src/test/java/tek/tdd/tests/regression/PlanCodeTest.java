package tek.tdd.tests.regression;

import org.testng.annotations.Test;
import tek.tdd.base.AuthenticateTestBase;

public class PlanCodeTest extends AuthenticateTestBase {
    @Test(testName = "Login to csr and validate table rows in plan code")
    public void testPlanCodeTable(){
       plansLogin();
        assertEqual(factory.getPlanCodePage().getPlanCodeTableRows(),4,"Validate plan code counts");
    }
    @Test(testName = "Login to customer service portal and validate the date creation and date expire")
    public void testPlansValidateDates(){
       plansLogin();
        String todayDate = dateUtility.todayDate();
        String createdDate = getElementText(factory.getPlanCodePage().dateCreatedColumn);
        assertEqual(createdDate,todayDate,"Validate Date Created column with today date");

        String todayDatePlusOne = dateUtility.incrementDate(1);
        String expireDate = getElementText(factory.getPlanCodePage().dateExpireColumn);
        assertEqual(expireDate,todayDatePlusOne,"Validate Date Expire column with today date plus one");

    }
}
