package tek.tdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import tek.tdd.utility.Constants;
import tek.tdd.utility.SeleniumUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {

    private static final Logger LOG = LogManager.getLogger(BaseSetup.class);
    private static WebDriver driver;

    public void openBrowser() {
        Properties configs = readProperties();
        String browserType = configs.getProperty("browser");
        boolean headless = Boolean.parseBoolean(configs.getProperty("headless"));
        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (headless) {
                options.addArguments("-headless");
            }
            driver = new FirefoxDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            driver = new EdgeDriver(options);
        } else {
            LOG.error("Wrong browser type check config file");
            throw new RuntimeException("Wrong browser type check config file");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        String url = configs.getProperty("base.url");
        driver.get(url);

    }

    private Properties readProperties() {
        String targetEnvironment = System.getProperty("tek_env");
        String propertyFilePath;
        if (targetEnvironment == null) {
            propertyFilePath = Constants.CONFIG_FILE_ENV_PATH + "dev_env.properties";
        }else{
            propertyFilePath = Constants.CONFIG_FILE_ENV_PATH + targetEnvironment + "_env.properties";
        }
            LOG.info("Config file path ::::: " + propertyFilePath);
        System.out.println("printing Config file path: " + propertyFilePath);
        LOG.info("Config file path with message method "  + propertyFilePath);
        Properties properties = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties.load(inputStream);
        } catch (IOException exception) {
            throw new RuntimeException("Not able to read property file " + exception.getMessage());
        }
        return properties;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
