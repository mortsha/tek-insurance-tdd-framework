package tek.tdd.tests.smoke;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UITestBase;
import tek.tdd.pages.HomePage;

public class HomePageTests extends UITestBase {


    /*
    TestCase 1)
    Navigate to Home page and validate the title
    then click on Create Primary Account Button.
    User should navigate to Create Account form page
    validate Form Title as Expected “Create Primary Account Holder” */

    @Test
    public void NavigateToCreateAccountPageAndValidatePageTitle() {
        String actualHomePage = getElementText(homePage.homePageTitle);
        Assert.assertEquals(actualHomePage, "TEK Insurance App", "validate top left corner title");

        click(homePage.createPrimaryAccountBttn);

        String actualCPAHTitle = getElementText(homePage.createPrimaryAccountHolderTitle);
        Assert.assertEquals(actualCPAHTitle, "Create Primary Account Holder", "validate create primary account holder title");

        for(WebElement elem : homePage.headingPageTitles){
            if(getElementText(elem).equals("Create Primary Account Holder")){
                Assert.assertTrue(isElementDisplayed(elem) ,"Create Primary Account Holder title should be displayed");
            }
        }

    }
}
