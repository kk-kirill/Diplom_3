package tests;

import driver.DriverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class LoginViaPersonalCabinetTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void loginViaPersonalCabinetTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage = mainPage.clickPersonalCabinetButton();
        assertTrue("Должна открыться станица авторизации",
                loginPage.isLoginPageOpened());
    }
}
