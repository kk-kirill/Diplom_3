package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // локаторы для полей
    private final By REGISTER_NAME_FIELD = By.xpath("(//input[@type='text'])[1]");
    private final By REGISTER_EMAIL_FIELD = By.xpath("(//input[@type='text'])[2]");
    private final By REGISTER_PASSWORD_FIELD = By.xpath("//input[@type='password']");

    // локаторы для кнопок
    private final By REGISTER_REGISTER_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    private final By REGISTER_LOGIN_BUTTON = By.xpath("//a[@href='/login']");

    //локаторы для ошибок
    private final By PASSWORD_ERROR_FIELD = By.xpath("//div[contains(@class,'input_status_error')]");

    // методы для полей
    @Step("Ввести имя: {userName}")
    public void enterUserName(String userName) {
        driver.findElement(REGISTER_NAME_FIELD).sendKeys(userName);
    }

    @Step("Ввести email: {userEmail}")
    public void enterUserEmail(String userEmail) {
        driver.findElement(REGISTER_EMAIL_FIELD).sendKeys(userEmail);
    }

    @Step("Ввести пароль")
    public void enterUserPassword(String userPassword) {
        driver.findElement(REGISTER_PASSWORD_FIELD).sendKeys(userPassword);
    }

    // методы для кнопок
    @Step("Нажать «Зарегистрироваться»")
    public LoginPage clickRegisterButton() {
        driver.findElement(REGISTER_REGISTER_BUTTON).click();
        return new LoginPage(driver);
    }

    @Step("Нажать «Войти»")
    public LoginPage clickLoginButton() {
        driver.findElement(REGISTER_LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }

    // методы для ошибок
    @Step("Проверить видимость ошибки пароля")
    public boolean isPasswordErrorVisible() {
        return driver.findElement(PASSWORD_ERROR_FIELD).isDisplayed();
    }
}
