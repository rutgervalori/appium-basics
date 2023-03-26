package pages;

import base.BaseActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class WelcomePage {

    private AndroidDriver driver;

    public WelcomePage(AndroidDriver androidDriver) {
        driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    final String welcomeTitleId = "welcome_title";
    final String welcomeBodyId = "welcome_body_text";
    final String continueButtonId = "welcome_continue_button";

    @AndroidFindBy(id = welcomeTitleId)
    public WebElement welcomeTitle;

    @AndroidFindBy(id = welcomeBodyId)
    public WebElement welcomeBody;

    @AndroidFindBy(id = continueButtonId)
    public WebElement continueButton;

    public void tapContinue() {
        continueButton.click();
    }
}
