package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private WelcomePage welcomePage;

    @Test(priority = 1)
    public void testWhenLoginButtonIsTappedAndEmailIsInvalidThenErrorShouldBeDisplayed() {
        loginPage = new LoginPage(driver);
//        Assert.assertFalse(loginPage.loginFieldErrorExistsAndIsVisible(), "Error should not be displayed when app has been started"); //  This Test makes the test really slow, because appium will spend 30seconds looking for the element. (see: implicit timeout)
        loginPage.enterEmailAddress("invalid-email-address");
        loginPage.tapLogin();
        Assert.assertTrue(loginPage.loginFieldErrorExistsAndIsVisible(), "Error message for email field should be displayed if login button is tapped and email address in invalid");
    }

    @Test(priority = 2)
    public void testWhenLoginButtonIsTappedAndEmailIsvalidThenWelcomePageShouldBeDisplayed() {
        loginPage = new LoginPage(driver);
        welcomePage = new WelcomePage(driver);

        loginPage.enterEmailAddress("valid-address@test.com");
        loginPage.tapLogin();

        Assert.assertTrue(welcomePage.welcomeTitle.isDisplayed());
        Assert.assertEquals(welcomePage.welcomeTitle.getText(), "Welcome");
        Assert.assertEquals(welcomePage.welcomeBody.getText(), "Step right in....");
           }


}
