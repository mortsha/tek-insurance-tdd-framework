package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtilities;

import java.util.List;

public class HomePage extends SeleniumUtilities {

    // Constructor to initialize instance of driver to instance elements of that Java Class.
    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='root']/div/div/div/h2[1]")
    public WebElement homePageTitle;
    @FindBy(linkText = "Create Primary Account")
    public WebElement createPrimaryAccountButton;

    @FindBy(xpath = "//h2[text()='Create Primary Account Holder']")
    public WebElement createPrimaryAccountHolderTitle;
    @FindBy(css = "h2.chakra-heading")
    public List<WebElement> headingPageTitles;
    @FindBy(xpath = "//div[@id='root']/div/div/div/div/h2[1]")
    public WebElement letsGetYouStartedTitle;

    @FindBy(xpath = "//div[@id='root']/div/div/div[1]/button[1]")
    public WebElement profileButton;
    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton;

    public void getLogOut(){
        click(profileButton);
        click(logoutButton);
    }
}

