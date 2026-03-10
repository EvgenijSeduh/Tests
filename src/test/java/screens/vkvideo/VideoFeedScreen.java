package screens.vkvideo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.Locators;
import utils.Waits;

public class VideoFeedScreen {
    private final AndroidDriver driver;
    private final Waits waits;

    public final By video = AppiumBy.id("com.vk.vkvideo:id/preview");

    public VideoFeedScreen(AndroidDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public VideoScreen selectVideo(){
        if(!driver.findElements(Locators.skipButtonVk).isEmpty()){
            waits.clickable(Locators.skipButtonVk,30).click();
        }
        if(!driver.findElements(Locators.closeButtonAdVk).isEmpty()){
            waits.clickable(Locators.closeButtonAdVk,30).click();
        }
        waits.clickable(video,60).click();

        return new VideoScreen(driver);
    }
}
