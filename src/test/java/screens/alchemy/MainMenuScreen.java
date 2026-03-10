package screens.alchemy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.Waits;

public class MainMenuScreen {
    private final AndroidDriver driver;
    private final Waits waits;

    private final By playButton = AppiumBy.xpath("//android.widget.TextView[@text=\"Play\"]");

    public MainMenuScreen(AndroidDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public boolean isOpened() {
        return !driver.findElements(playButton).isEmpty();
    }
    public GameScreen tapPlay() {
        waits.clickable(playButton, 10).click();
        return new GameScreen(driver);
    }
}
