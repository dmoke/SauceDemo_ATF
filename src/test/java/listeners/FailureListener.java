package listeners;


import common.Base;
import common.BaseTest;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailureListener extends Base implements ITestListener {

    Logger logger = LogManager.getLogger(FailureListener.class);
    String loggerConfPath = "src/main/java/ui/test/properties/logger.properties";

    @Override
    public void onTestFailure(ITestResult result) {
        PropertyConfigurator.configure(loggerConfPath);
        logger.info("---------------------------------------------------------------");
        logger.info("Failed because of - " + result.getThrowable());
        logger.info("---------------------------------------------------------------");
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        if (driver != null) {
            captureScreen(driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("---------------------------------------------------------------");
        logger.info("Skipped because of - " + result.getThrowable());
        logger.info("---------------------------------------------------------------");
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        if (driver != null) {
            captureScreen(driver);
        }
    }
}