package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtilities;

public class CreateAccountPage extends SeleniumUtilities {

    public CreateAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(linkText = "Create Primary Account")
    public WebElement createPrimaryAccountButton;
    @FindBy(xpath = "//div[@id='root']/div/div[2]//div[contains(@class,'chakra-stack')]/h2[1]")
    public WebElement createAccountTitle;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "title")
    public WebElement prefixSelect;

    @FindBy(name = "firstName")
    public WebElement firstNameInput;

    @FindBy(name = "lastName")
    public WebElement lastNameInput;

    @FindBy(name = "gender")
    public WebElement genderSelect;

    @FindBy(name = "maritalStatus")
    public WebElement maritalStatusSelect;

    @FindBy(name = "employmentStatus")
    public WebElement employmentStatusInput;

    @FindBy(name = "dateOfBirth")
    public WebElement dateOfBirthInput;
    @FindBy(xpath = "//div[@id='root']/div/div[2]//div[contains(@class,'chakra-stack')]/h2[1]")
    public WebElement singUpSectionTitle;

    @FindBy(xpath = "//div[@id='root']/div/div[2]//div[contains(@class,'chakra-stack')]/h2[2]")
    public WebElement validateFullNameSection;
    @FindBy(xpath = "//div[@id='root']/div/div[2]//div[contains(@class,'chakra-stack')]/h2[3]")
    public WebElement validateEmailSection;
    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement createAccountButton;
    @FindBy(name = "username")
    public WebElement userNameInput;
    @FindBy(name = "password")
    public WebElement passwordInput;
    @FindBy(name = "confirm")
    public WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInButton;
    @FindBy(xpath = "//div[@id='root']/div/div/div/h2")
    public WebElement portalTitle;
    public void clickOnCreateAccount() {
        click(createPrimaryAccountButton);
    }

    public void createAccountForm(String email, String firstName, String lastName,String prefix, String gender, String maritalStatus, String employmentStatus, String dob) {
        sendText(emailInput, email);
        sendText(firstNameInput, firstName);
        sendText(lastNameInput, lastName);
        sendText(employmentStatusInput, employmentStatus);
        selectByDropdown(prefixSelect, prefix);
        selectByDropdown(genderSelect, gender);
        selectByDropdown(maritalStatusSelect, maritalStatus);
        sendText(dateOfBirthInput, dob);
        click(createAccountButton);
        waitTime(500);
    }
    public void signUpAccount(String username,String password, String confirm){
        sendText(userNameInput,username);
        sendText(passwordInput,password);
        sendText(confirmPasswordInput,confirm);
        click(submitButton);
        waitTime(3000);
    }
    public void signInAccount(String username, String password){
        sendText(userNameInput,username);
        sendText(passwordInput,password);
        click(signInButton);
        waitTime(500);

    }
}
