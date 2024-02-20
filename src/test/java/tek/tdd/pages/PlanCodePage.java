package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtilities;

import java.util.List;

public class PlanCodePage extends SeleniumUtilities {
    public PlanCodePage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(linkText = "Plans")
    public WebElement plansLink;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> planCodeRows;
    @FindBy(xpath = "//tbody/tr/td[4]")
    public WebElement dateCreatedColumn;
    @FindBy(xpath = "//tbody/tr/td[5]")
    public WebElement dateExpireColumn;

    public void clickOnPlanLink(){
        click(plansLink);
        extentInfo("After click on plans section the today plans price table should displayed ");
    }

    public int getPlanCodeTableRows(){
        return planCodeRows.size();
    }

}
