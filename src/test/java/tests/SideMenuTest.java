package tests;

import common.BaseTest;
import elements.SideBarElements;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SideBar;

public class SideMenuTest extends BaseTest {
    @Test
    public void sideMenuTest() {


        LoginPage loginPage = new LoginPage(driver, jsExecutor);
        SideBar sideBar = new SideBar(driver, jsExecutor);
        openUrl("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user").enterPassword("secret_sauce").pressSubmitButton();


        assertFalse(sideBar.clickMenuBtn().isSideBarHidden());

    }

}
