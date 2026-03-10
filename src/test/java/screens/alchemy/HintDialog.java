package screens.alchemy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.Waits;

public class HintDialog {
    private final AndroidDriver driver;
    private final Waits waits;

    private final By hintsCount = AppiumBy.xpath("//x2.f1/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView");
    private final By rewardHintButton = AppiumBy.xpath("//android.widget.TextView[@text=\"Watch\"]");
    //private final By loadHintButton = AppiumBy.xpath("//android.widget.TextView[@text=\"Load\"]");
    public HintDialog(AndroidDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    public HintDialog getHintForAd() {
        //waits.invisible(loadHintButton,40);
        waits.clickable(rewardHintButton, 60).click();

        AdDialog adDialog = new AdDialog(driver);
        adDialog.watchAdAndClose();

        return new HintDialog(driver);
    }
    public int getHintsCount() {
        String text = waits.visible(hintsCount,60).getText();
        return Integer.parseInt(text.trim());
    }
}
