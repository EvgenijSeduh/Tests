package screens.alchemy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.Waits;

public class GameScreen {
    private final AndroidDriver driver;
    private final Waits waits;


    private final By addHintsButton = AppiumBy.xpath("//x2.f1/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]");

    public GameScreen(AndroidDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }



    public HintDialog openHintsDialog() {
        waits.clickable(addHintsButton, 60).click();
        return new HintDialog(driver);
    }
}
