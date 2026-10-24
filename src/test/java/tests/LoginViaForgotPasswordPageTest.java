package tests;

import driver.DriverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class LoginViaForgotPasswordPageTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void loginViaForgotPasswordPageTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage = mainPage.clickPersonalCabinetButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickForgotLoginButton();
        assertTrue("Должна открыться станица авторизации",
                loginPage.isLoginPageOpened());
    }
}
