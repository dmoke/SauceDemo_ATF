package common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public interface Waitable{
    Duration BASE_TIMEOUT = Duration.ofSeconds(15);
    Logger logger = LogManager.getLogger(Waitable.class);

    default WebElement waitForElementVisible(WebDriver driver, String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            logger.error("No presence of element being visible: " + xpath);
            Assert.fail("No presence of element being visible: " + xpath);
            return null;
        }
    }

    default WebElement waitForElementClickable(WebDriver driver, String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (Exception e) {
            logger.error("No presence of element being clickable: " + xpath);
            Assert.fail("No presence of element being clickable: " + xpath);
            return null;
        }
    }

    default boolean waitForElementInvisible(WebDriver driver, String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            logger.error("No presence of element being invisible: " + xpath);
            Assert.fail("No presence of element being invisible: " + xpath);
            return false;
        }
    }

    default boolean waitForTextPresentInElement(WebDriver driver, String xpath, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
        } catch (Exception e) {
            logger.error("No presence of text in element: " + text + ' ' + xpath);
            Assert.fail("No presence of text in element: " + text + ' ' + xpath);
            return false;
        }
    }

    default boolean waitForUrlContains(WebDriver driver, String url) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
            return wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            logger.error("No presence of urc containing: " + url);
            Assert.fail("No presence of urc containing: " + url);
            return false;
        }
    }

    default boolean waitForTitleContains(WebDriver driver, String title) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
            return wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            logger.error("No presence of right title " + title);
            Assert.fail("No presence of right title " + title);
            return false;
        }
    }
}
