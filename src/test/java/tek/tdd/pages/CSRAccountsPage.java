package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtilities;

import java.util.List;

public class CSRAccountsPage extends SeleniumUtilities {
    public CSRAccountsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(linkText = "Accounts")
    public WebElement accountsSection;
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> accountsRows;
    @FindBy(xpath = "//table/following-sibling::div//select")
    public WebElement showDropdown;
    @FindBy(css = "div.chakra-spinner")
    public WebElement spinner;

    public void clickOnAccounts() {
        click(accountsSection);
        extentInfo("After click on account section the Primary accounts information with table rows and columns should displayed ");

    }

    public int getAccountsTableRows() {
        return accountsRows.size();
    }

    public void dropdownWithRecords(int dropdownValue) {
        selectByDropdown(showDropdown, "Show " + dropdownValue);
        assertEqual(getAccountsTableRows(), dropdownValue, "Validate table show as expected of " + dropdownValue + " records");
    }
}
