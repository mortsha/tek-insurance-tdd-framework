package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtilities;

import javax.xml.xpath.XPath;

public class LoginPage extends SeleniumUtilities {


    public LoginPage() {
        PageFactory.initElements(getDriver(), this);

    }

    @FindBy(linkText = "Login")
    public WebElement loginButton;

    @FindBy(name = "username")
    public WebElement userNameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//h2[text()='Customer Service Portal']")
    public WebElement csrTitle;

    @FindBy(xpath = "//div[@data-status='error' and @role='alert']")
    public WebElement errorMessageElement;
}
