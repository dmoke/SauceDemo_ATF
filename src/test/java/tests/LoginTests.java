package tests;

import common.BaseTest;
import data_providers.LoginDataProvider;
import io.qameta.allure.Description;
import models.LoginData;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTests extends BaseTest {
    @Test(dataProvider = "loginDataProvider", dataProviderClass = LoginDataProvider.class)
    @Description("Positive Login test")
    public void loginTest(LoginData loginData) {
        LoginPage loginPage = new LoginPage(driver, jsExecutor);
        openUrl("https://www.saucedemo.com/");
        String urlAfterSubmit = loginPage
                .enterUsername(loginData.getUsername())
                .enterPassword(loginData.getPassword())
                .pressSubmitButton()
                .returnUrl();

        assertEquals(urlAfterSubmit, "https://www.saucedemo.com/inventory.html");
    }

}
