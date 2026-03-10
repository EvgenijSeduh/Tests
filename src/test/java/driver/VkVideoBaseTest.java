package driver;

import io.appium.java_client.android.AndroidDriver;

public class VkVideoBaseTest extends BaseTest{
    @Override
    protected AndroidDriver createDriver() throws Exception {
        return DriverFactory.createVkDriver();
    }
}
