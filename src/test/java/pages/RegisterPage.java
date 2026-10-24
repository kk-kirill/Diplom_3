package pages;

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
    public void enterUserName(String userName) {
        driver.findElement(REGISTER_NAME_FIELD).sendKeys(userName);
    }

    public void enterUserEmail(String userEmail) {
        driver.findElement(REGISTER_EMAIL_FIELD).sendKeys(userEmail);
    }

    public void enterUserPassword(String userPassword) {
        driver.findElement(REGISTER_PASSWORD_FIELD).sendKeys(userPassword);
    }

    // методы для кнопок
    public LoginPage clickRegisterButton() {
        driver.findElement(REGISTER_REGISTER_BUTTON).click();
        return new LoginPage(driver);
    }

    public LoginPage clickLoginButton() {
        driver.findElement(REGISTER_LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }

    // методы для ошибок
    public boolean isPasswordErrorVisible() {
        return driver.findElement(PASSWORD_ERROR_FIELD).isDisplayed();
    }
}
