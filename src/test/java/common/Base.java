package common;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.util.Arrays;

public class Base extends Assert {

    protected void sleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] captureScreen(WebDriver driver) {
        try {
            System.out.println("here"+driver);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("./target/allure-results/screenshots/" + screenshot.getName()));
            return Files.toByteArray(screenshot);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}
