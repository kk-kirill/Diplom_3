package tests;

import driver.DriverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginViaRegisterPageTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void loginViaRegisterPageTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage = mainPage.clickPersonalCabinetButton();
        RegisterPage registerPage = loginPage.clickRegisterButton();
        registerPage.clickLoginButton();
        assertTrue("Должна открыться станица авторизации",
                loginPage.isLoginPageOpened());
    }
}
