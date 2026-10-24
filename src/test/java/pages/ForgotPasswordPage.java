package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // локаторы для кнопок
    private final By FORGOT_LOGIN_BUTTON = By.xpath("//a[@href='/login']");

    // методы для кнопок
    public LoginPage clickForgotLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(FORGOT_LOGIN_BUTTON))
                .click();
        return new LoginPage(driver);
    }
}
