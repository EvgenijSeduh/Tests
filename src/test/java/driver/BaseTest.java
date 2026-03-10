package driver;

import config.TestConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URL;
import java.time.Duration;


public abstract class BaseTest {

    protected AndroidDriver driver;

    @BeforeEach
    void setUp() throws Exception {
        driver = createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected abstract AndroidDriver createDriver() throws Exception;
}
