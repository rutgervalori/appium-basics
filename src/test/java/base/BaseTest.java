package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static AndroidDriver driver;

    private String deviceAndroidVersion = "12.0";
    private String deviceName = "emulator-5554";
    private String androidAppLocation = System.getProperty("user.dir") + "/apps/demo-app-debug.apk";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", deviceAndroidVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("app", androidAppLocation);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub/"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}