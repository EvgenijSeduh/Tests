package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits {
    private final AndroidDriver driver;

    public Waits(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement visible(By by, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement clickable(By by, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean invisible(By by, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public By untilAnyVisible(List<By> locators, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(2));

        return wait.until(d -> {
            for (By locator : locators) {
                if (!driver.findElements(locator).isEmpty()
                        && driver.findElement(locator).isDisplayed()) {
                    return locator;
                }
            }
            return null;
        });
    }
}
