package runners;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CalculatorPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@CucumberOptions(features = "src/test/resources/features", glue = "steps", tags = "@nums")
public class Runner extends AbstractTestNGCucumberTests {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static CalculatorPage calculatorPage;

    @BeforeMethod
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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
