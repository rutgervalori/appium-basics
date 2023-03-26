package pages;

import base.BaseActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private AndroidDriver driver;

    public LoginPage(AndroidDriver androidDriver) {
        driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    final String loginFieldId = "username_edit_text_input";
    final String loginFieldErrorId = "textinput_error";
    final String loginButtonId = "login_button";

    @AndroidFindBy(id = loginFieldId)
    public WebElement loginField;

    @AndroidFindBy(id = loginFieldErrorId)
    public WebElement loginFieldError;

    @AndroidFindBy(id = loginButtonId)
    public WebElement loginButton;

    public void enterEmailAddress(String emailAddress) {
        loginField.sendKeys(emailAddress);
    }

    public Boolean loginFieldErrorExistsAndIsVisible() {
        return BaseActions.elementExistsAndIsVisible(driver, By.id(loginFieldErrorId));
    }

    public void tapLogin() {
        loginButton.click();
    }
}
