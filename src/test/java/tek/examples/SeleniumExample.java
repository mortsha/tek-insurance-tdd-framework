package tek.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumExample {

    private static WebDriver driver;

    @BeforeMethod
    public void setupTests(){
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      driver.manage().window().maximize();
      driver.get("https://dev.insurance.tekschool-students.com/");
    }


    @Test
    public void testPageTitle(){
        WebElement pageTitle = driver.findElement(By.xpath("//h2[text()='TEK Insurance App']"));
        String actualTitleText = pageTitle.getText();
        Assert.assertEquals(actualTitleText,"TEK Insurance App");
        System.out.println(actualTitleText);
        System.out.println("actual and expected title are the same");

    }

    @AfterMethod
    public void closeTests(){
        driver.quit();
    }
}
