package tek.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIndByExample {

    // This class need to have access to Instance of WebDriver

   /* public FIndByExample(){
        PageFactory.initElements(driver, this );
    }*/

    // By approach on Page Object Model Design
    public static final By button = By.id("Button");

    // FindBy approach POM Design

    @FindBy(id = "Button")
    public WebElement buttonElement;

}
