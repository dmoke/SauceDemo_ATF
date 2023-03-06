package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        System.out.println("here");
        String headless = System.getProperty("headless");
        if (headless == null) {
            headless = "";
        }
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        if (headless.equals("headless")) {
            this.driver.manage().window().setSize(new Dimension(1920, 1080));
        } else {
            this.driver.manage().window().maximize();
        }
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