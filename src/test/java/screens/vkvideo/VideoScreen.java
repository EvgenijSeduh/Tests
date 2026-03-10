package screens.vkvideo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.Locators;
import utils.Waits;

public class VideoScreen {
    public final By playPauseButton = By.id("com.vk.vkvideo:id/video_play_button");
    private final By previewVideo = By.xpath("//android.widget.TextView[@resource-id=\"com.vk.vkvideo:id/title\" and @text=\"More videos\"]");
    public final By progressBarVideo = AppiumBy.xpath("//android.widget.SeekBar[@content-desc=\"Slider\"]");
    public final By currentVideo = AppiumBy.id("com.vk.vkvideo:id/video_subtitles");
    private final AndroidDriver driver;
    private final Waits waits;

    public VideoScreen(AndroidDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public VideoScreen showControls() {
        waits.clickable(currentVideo, 90).click();
        return this;
    }

    public VideoScreen tapPlayPauseButton() {
        waits.clickable(playPauseButton, 10).click();
        return this;
    }

    public VideoScreen waitWhenVideoClickable(){
        waits.clickable(previewVideo, 90);
        return this;
    }

    public int getVideoTime() {
        if(driver.findElements(progressBarVideo).isEmpty())
            showControls();
        String text = waits.visible(progressBarVideo, 60).getText();
        System.out.println("SeekBar text = " + text);
        return Integer.parseInt(text.trim());
    }

    public VideoScreen waitSecVideoPlayback(int seconds) {
        sleep(seconds);
        return this;
    }


    private void sleep(long mil) {
        long sec = mil *1000L;
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
