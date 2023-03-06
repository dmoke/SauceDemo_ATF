package pages;

import common.Waitable;
import elements.LoginPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage implements Waitable {
    protected WebDriver driver;
    protected JavascriptExecutor jsExecutor;

    public LoginPage(WebDriver driver, JavascriptExecutor jsExecutor) {
        this.driver = driver;
        this.jsExecutor = jsExecutor;
    }

    @Step("Entering Username")
    public LoginPage enterUsername(String username) {
        this.waitForElementClickable(driver, LoginPageElements.USERNAME_INPUT_FIELD.xpath)
                .sendKeys(username);
        return this;
    }
    @Step("Entering Password")
    public LoginPage enterPassword(String password) {
        this.waitForElementClickable(driver, LoginPageElements.PASSWORD_INPUT_FIELD.xpath)
                .sendKeys(password);
        return this;
    }
    @Step("Submitting login form")
    public LoginPage pressSubmitButton() {
        this.waitForElementClickable(driver, LoginPageElements.SUBMIT_BUTTON.xpath)
                .click();
        return this;
    }
    @Step("Returns Current url")
    public String returnUrl(){
        return this.driver.getCurrentUrl();
    }
}
