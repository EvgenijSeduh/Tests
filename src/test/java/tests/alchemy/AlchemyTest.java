package tests.alchemy;

import driver.AlchemyBaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import screens.alchemy.AdDialog;
import screens.alchemy.GameScreen;
import screens.alchemy.HintDialog;
import screens.alchemy.MainMenuScreen;

public class AlchemyTest extends AlchemyBaseTest {
    @Test
    public void shouldIncreaseHintsCountToFourAfterWatchingAd() {
        MainMenuScreen mainMenuScreen = new MainMenuScreen(driver);
        GameScreen gameScreen = mainMenuScreen.tapPlay();
        HintDialog hintDialog = gameScreen.openHintsDialog();
        int start = hintDialog.getHintsCount();
        int end = hintDialog
                .getHintForAd()
                .getHintsCount();
        
        Assertions.assertEquals(2, end - start);
    }

}
