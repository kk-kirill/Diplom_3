package tests;

import base.BaseTest;
import driver.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверяем, что открывается страница авторизации")
    @Test
    public void loginViaPersonalCabinetTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage = mainPage.clickPersonalCabinetButton();
        loginPage.enterUserEmail(user.getEmail());
        loginPage.enterUserPassword(user.getPassword());
        mainPage = loginPage.clickLoginButton();
        assertTrue("Должна открыться главная страница",
                mainPage.isMainPageOpened());
    }

    @DisplayName("Вход через кнопку «Войти в аккаунт»")
    @Description("Проверяем, что открывается страница авторизации")
    @Test
    public void loginViaMainPageButtonTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage = mainPage.clickLoginAccountButton();
        loginPage.enterUserEmail(user.getEmail());
        loginPage.enterUserPassword(user.getPassword());
        mainPage = loginPage.clickLoginButton();
        assertTrue("Должна открыться главная страница",
                mainPage.isMainPageOpened());
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяем, что открывается страница авторизации")
    @Test
    public void loginViaRegisterPageTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage = mainPage.clickPersonalCabinetButton();
        RegisterPage registerPage = loginPage.clickRegisterButton();
        registerPage.clickLoginButton();
        loginPage.enterUserEmail(user.getEmail());
        loginPage.enterUserPassword(user.getPassword());
        mainPage = loginPage.clickLoginButton();
        assertTrue("Должна открыться главная страница",
                mainPage.isMainPageOpened());
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяем, что открывается страница авторизации")
    @Test
    public void loginViaForgotPasswordPageTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage = mainPage.clickPersonalCabinetButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickForgotLoginButton();
        loginPage.enterUserEmail(user.getEmail());
        loginPage.enterUserPassword(user.getPassword());
        mainPage = loginPage.clickLoginButton();
        assertTrue("Должна открыться главная страница",
                mainPage.isMainPageOpened());
    }
}