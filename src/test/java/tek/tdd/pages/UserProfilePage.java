package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import tek.tdd.base.UITestBase;
import tek.tdd.utility.SeleniumUtilities;

public class UserProfilePage extends SeleniumUtilities {
    public UserProfilePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='root']/div/div/div/button")
    public WebElement profileButton;
    @FindBy(xpath = "//p[contains(text(),'STATUS')]//parent::div//span/span")
    public WebElement statusProfile;
    @FindBy(xpath = "//p[text()='USER TYPE']//following-sibling::p")
    public WebElement userTypeProfileText;
    @FindBy(xpath = "//p[text()='FULL NAME']//following-sibling::p")
    public WebElement fullNameProfileText;
    @FindBy(xpath = "//p[text()='USERNAME']//following-sibling::p")
    public WebElement userNameProfileText;
    @FindBy(xpath = "//p[text()='AUTHORITIES']//parent::div/ul/li")
    public WebElement authoritiesProfileText;

    public void validateUserProfile(String status, String userType,String fullName,String username,String authorities){
        String actualStatus = getElementText(statusProfile);
        assertEqual(actualStatus,status,"Validate status of profile section");
        String actualUserType = getElementText(userTypeProfileText);
        assertEqual(actualUserType,userType, "Validate user type of profile section ");
        String actualFullName = getElementText(fullNameProfileText);
        assertEqual(actualFullName,fullName,"Validate full name of profile section");
        String actualUsername = getElementText(userNameProfileText);
        assertEqual(actualUsername,username,"Validate username of profile section");
        String actualAuthorities = getElementText(authoritiesProfileText);
        assertEqual(actualAuthorities,authorities,"Validate authorities of profile section");
    }
}
