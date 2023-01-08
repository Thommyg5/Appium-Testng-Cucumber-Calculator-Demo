package com.testing.runners;

import com.testing.helpers.HelperMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.testing.pages.CalculatorPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@CucumberOptions(features = "src/test/resources/features", glue = "com/testing/steps", tags = "@nums")
public class Runner extends AbstractTestNGCucumberTests {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static CalculatorPage calculatorPage;
    private AppiumDriverLocalService appiumDriverLocalService;

    @BeforeMethod(enabled = true)
    public void setUp() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Pixel_3a_API_33_x86_64");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:platformVersion", "13");
        desiredCapabilities.setCapability("appium:app", (new File("src/test/resources/apkFiles/Calculator.apk")).getAbsolutePath());
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        calculatorPage = new CalculatorPage(driver);
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod(enabled = false)
    public synchronized void setUpAutomatic() throws IOException {
        HelperMethods.useCommandLine("C:\\Users\\wutan\\AppData\\Local\\Android\\Sdk\\tools\\emulator","-avd","Pixel_3a_API_33_x86_64");

        appiumDriverLocalService = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723)
                .withArgument(() -> "--base-path", "/wd/hub").build();
        appiumDriverLocalService.start();

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel_3a_API_33_x86_64");
        uiAutomator2Options.setApp((new File("src/test/resources/apkFiles/Calculator.apk")).getAbsolutePath());
        uiAutomator2Options.setUdid("emulator-5554");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, uiAutomator2Options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        calculatorPage = new CalculatorPage(driver);
    }

    @AfterMethod(enabled = false)
    public void tearDownAutomatic() throws IOException {
        HelperMethods.useCommandLine("C:\\Users\\wutan\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb", "-s", "emulator-5554", "emu", "kill");
        driver.quit();
        appiumDriverLocalService.close();
    }

}
