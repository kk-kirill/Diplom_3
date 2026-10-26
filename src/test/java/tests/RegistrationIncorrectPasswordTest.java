package tests;

import driver.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationIncorrectPasswordTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @DisplayName("Регистрация с некорректным паролем")
    @Description("Проверяем, что появляется ошибка при пароле короче 6 символов")
    @Test
    public void registrationWithShortPasswordTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage;
        loginPage = mainPage.clickPersonalCabinetButton();
        RegisterPage registerPage;
        registerPage = loginPage.clickRegisterButton();
        registerPage.enterUserName("Иван");
        String email = "test" + System.currentTimeMillis() + "@yandex.ru";
        registerPage.enterUserEmail(email);
        registerPage.enterUserPassword("12345");
        registerPage.clickRegisterButton();
        assertTrue("Долен появится текст ошибки 'Некорректный пароль'",
                registerPage.isPasswordErrorVisible());
    }
}
