package tests;

import api.UserApi;
import driver.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserModel;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationUserTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private UserApi userApi = new UserApi();
    private String email;
    private String password = "123456";

    @After
    public void tearDown() {
        UserModel user = new UserModel(email, password, "Иван");
        Response response = userApi.login(user);
        String accessToken = response.then().extract().path("accessToken");
        if (accessToken != null) {
            userApi.delete(accessToken);
        }
    }

    @Test
    public void successfulRegistrationTest() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();
        LoginPage loginPage = mainPage.clickPersonalCabinetButton();
        RegisterPage registerPage = loginPage.clickRegisterButton();
        registerPage.enterUserName("Иван");
        email = "test" + System.currentTimeMillis() + "@yandex.ru";
        registerPage.enterUserEmail(email);
        registerPage.enterUserPassword(password);
        registerPage.clickRegisterButton();
        assertTrue("После регистрации должна открыться страница авторизации",
                loginPage.isLoginPageOpened());
    }
}