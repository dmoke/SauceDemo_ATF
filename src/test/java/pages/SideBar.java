package pages;

import com.google.j2objc.annotations.Weak;
import common.BaseTest;
import common.Waitable;
import elements.SideBarElements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SideBar extends BaseTest implements Waitable {

    protected WebDriver driver;
    protected JavascriptExecutor jsExecutor;

    public SideBar(WebDriver driver, JavascriptExecutor jsExecutor) {
        this.driver = driver;
        this.jsExecutor = jsExecutor;
    }

    public SideBar clickMenuBtn(){
        this.waitForElementClickable(driver,SideBarElements.OPEN_BURGER_BUTTON.xpath).click();
//        sleep(1000);
        return this;
    }

    public boolean isSideBarHidden(){

       return Boolean.parseBoolean(this.waitForElementVisible(driver,SideBarElements.SIDE_BAR_MENU_WRAPPER.xpath).getAttribute("aria-hidden"));

    }
}
