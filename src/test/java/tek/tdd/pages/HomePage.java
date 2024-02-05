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

    @FindBy(xpath = "//h2[text()='TEK Insurance App']")
    public WebElement homePageTitle;

    @FindBy(xpath = "//a[text()='Create Primary Account']")
    public WebElement createPrimaryAccountBttn;

    @FindBy(xpath = "//h2[text()='Create Primary Account Holder']")
    public WebElement createPrimaryAccountHolderTitle;
    @FindBy(css = "h2.chakra-heading")
    public List<WebElement> headingPageTitles;
}
