package tek.tdd.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UITestBase;

public class HomePageTests extends UITestBase {
    @Test(testName = "Validate title Tek Insurance in home Page and create Primary Account button")
    public void validateApplicationTitleAndCreateAccountButton(){
        String actualTitle = getElementText(factory.getHomePage().homePageTitle);
        assertEqual(actualTitle,"TEK Insurance App","Validating the TEK Insurance App title");
        isElementDisplayed(factory.getHomePage().createPrimaryAccountButton);
        extentInfo("Create Primary Account button displayed");
    }
}
