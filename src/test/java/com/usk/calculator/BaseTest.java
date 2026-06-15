package com.usk.calculator;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setAppPackage("com.example.calculator");
        options.setAppActivity("com.example.calculator.MainActivity");
        options.setNoReset(true);

        URL appiumServerUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(appiumServerUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Pastikan app dibawa ke foreground
        driver.activateApp("com.example.calculator");

        // Tunggu sampai app benar-benar siap (tombol AC muncul)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(d -> !d.findElements(AppiumBy.id("com.example.calculator:id/bac")).isEmpty());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}