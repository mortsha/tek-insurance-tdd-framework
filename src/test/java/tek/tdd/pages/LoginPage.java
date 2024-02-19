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

    @FindBy(xpath = "//div[@id='root']/div/div/div/h2[1]")
    public WebElement homePageTitle;

    @FindBy(xpath = "//div[@data-status='error' and @role='alert']")
    public WebElement errorMessageElement;
    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton;

    public void getLogin(String username, String password){
        click(loginButton);
        sendText(userNameInput,username);
        sendText(passwordInput,password);
        click(signInButton);
        waitTime(500);
        extentInfo("After providing the username and password should log in to the account");

    }

    public String getErrorMessage(){
        return getElementText(errorMessageElement);
    }
}
