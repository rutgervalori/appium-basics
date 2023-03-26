package base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseActions {

    public static void scrollToBottomOfScrollView(AppiumDriver driver) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(50)"));
    }

    public static void scrollToText(AppiumDriver driver, String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
    }

    public static void waitUntilElementFound(AppiumDriver driver, By locator) {
        waitUntilElementFound(driver, locator, Duration.ofSeconds(10));
    }

    public static void waitUntilElementFound(AppiumDriver driver, By locator, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static Boolean elementExistsAndIsVisible(AppiumDriver driver, By locator) {
        Boolean elementExistsAndIsVisible;
        List<WebElement> myElementList = driver.findElements(locator);
        if (myElementList.isEmpty()) {
            elementExistsAndIsVisible = false;
        } else {
            // We know it exists, now we need to know if it's displayed (visible) or not
            if (myElementList.get(0).isDisplayed()) {
                // This means the element is visible
                elementExistsAndIsVisible = true;
            } else {
                // This means the element exists, but is not visible
                elementExistsAndIsVisible = false;
            }

        }
        return elementExistsAndIsVisible;
    }
}
