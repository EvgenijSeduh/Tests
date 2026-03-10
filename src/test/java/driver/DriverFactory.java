package driver;

import config.TestConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class DriverFactory {
    public static AndroidDriver createAlchemyDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName(TestConfig.get("device.name"))
                .setPlatformVersion(TestConfig.get("platform.version"))
                .setAppPackage(TestConfig.get("alchemy.appPackage"))
                .setAppActivity(TestConfig.get("alchemy.appActivity"));

        return new AndroidDriver(new URL(TestConfig.get("appium.url")), options);
    }

    public static AndroidDriver createVkDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName(TestConfig.get("device.name"))
                .setPlatformVersion(TestConfig.get("platform.version"))
                .setAppPackage(TestConfig.get("vk.appPackage"))
                .setAppActivity(TestConfig.get("vk.appActivity"));

        return new AndroidDriver(new URL(TestConfig.get("appium.url")), options);
    }
}
