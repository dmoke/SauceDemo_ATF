package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends Base {
    private final Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected JavascriptExecutor jsExecutor;
    String loggerConfPath = "src/test/java/properties/logger.properties";

    @BeforeMethod
    public void setUp() {
        PropertyConfigurator.configure(loggerConfPath);
        logger.info("Started setting up the driver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (System.getenv("CI") != null && System.getenv("CI").equals("true")) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }
        this.driver = new ChromeDriver(options);
        jsExecutor = (JavascriptExecutor) this.driver;
        logger.info("Finished setting up the driver");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Quiting driver");
        this.driver.quit();
    }

    public void openUrl(String url) {
        this.driver.get(url);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}