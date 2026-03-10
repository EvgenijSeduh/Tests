package tests.alchemy;

import driver.VkVideoBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import screens.vkvideo.VideoFeedScreen;
import screens.vkvideo.VideoScreen;


public class VkVideoTest extends VkVideoBaseTest {
    @Test
    public void playingRandomVideo(){
        VideoFeedScreen videoFeedScreen = new VideoFeedScreen(driver);
        VideoScreen videoScreen = videoFeedScreen.selectVideo();
        int start = videoScreen
                .showControls()
                .getVideoTime();
        videoScreen.waitSecVideoPlayback(5);
        int finish = videoScreen.showControls()
                .getVideoTime();
        Assertions.assertTrue(finish > start);
    }
}
