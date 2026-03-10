package screens.alchemy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waits;

import java.time.Duration;
import java.util.List;

public class AdDialog {

    private final AndroidDriver driver;
    private final Waits wait;

    public AdDialog(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
    }
    public static final List<By> closeOrSkipButtons = List.of(
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 2\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView"),
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 2\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]"),
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 2\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView"),
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 1\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]"),
            AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.ilyin.alchemy:id/bigo_ad_btn_close\"]"),
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 1\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView"),
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 2\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView"),
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 3\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")
    );

    public static final By elementGameScreen = AppiumBy.xpath("//android.widget.TextView[@text=\"Get hints\"]");

    public void watchAdAndClose() {
        while(driver.findElements(elementGameScreen).isEmpty()) {
            for(By button : closeOrSkipButtons) {
                if(!driver.findElements(button).isEmpty()) {
                    driver.findElement(button).click();
                    sleep(2000);
                    break;
                }
            }
            sleep(2000);
        }
    }
    private void sleep(long mil) {
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
//android.widget.RelativeLayout[@content-desc="pageIndex: 2"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView
//android.widget.RelativeLayout[@content-desc="pageIndex: 2"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]
//android.widget.RelativeLayout[@content-desc="pageIndex: 2"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView
//android.widget.RelativeLayout[@content-desc="pageIndex: 1"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]
//android.widget.RelativeLayout[@content-desc="pageIndex: 3"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView
//android.widget.ImageView[@resource-id="com.ilyin.alchemy:id/bigo_ad_btn_close"]
//android.widget.ImageView[@resource-id="com.ilyin.alchemy:id/bigo_ad_btn_close"]
//android.widget.ImageView[@resource-id="com.ilyin.alchemy:id/bigo_ad_btn_close"]
//android.widget.RelativeLayout[@content-desc="pageIndex: 3"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView
