package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // локаторы для полей
    private final By LOGIN_EMAIL_FIELD = By.xpath("//input[@placeholder='*Email']");
    private final By LOGIN_PASSWORD_FIELD = By.xpath("//input[@placeholder='*Пароль']");

    //локаторы для кнопок
    private final By LOGIN_REGISTER_BUTTON = By.xpath("//a[text()='Зарегистрироваться']");
    private final By SUBMIT_LOGIN_BUTTON = By.xpath("//button[text()='Войти']");
    private final By FORGOT_PASSWORD_LINK = By.xpath("//a[@href='/forgot-password']");

    // методы для полей
    public void enterUserEmail(String userEmail) {
        driver.findElement(LOGIN_EMAIL_FIELD).sendKeys(userEmail);
    }

    public void enterUserPassword(String userPassword) {
        driver.findElement(LOGIN_PASSWORD_FIELD).sendKeys(userPassword);
    }

    // методы для кнопок
    public RegisterPage clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(LOGIN_REGISTER_BUTTON))
                .click();
        return new RegisterPage(driver);
    }

    public MainPage clickLoginButton() {
        driver.findElement(SUBMIT_LOGIN_BUTTON).click();
        return new MainPage(driver);
    }

    public ForgotPasswordPage clickForgotPasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(FORGOT_PASSWORD_LINK))
                .click();
        return new ForgotPasswordPage(driver);
    }

    // методы для проверки
    public boolean isLoginPageOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("/login"));
        return true;
    }
}


