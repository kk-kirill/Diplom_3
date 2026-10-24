package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // локаторы для кнопок
    private final By LOGIN_ACCOUNT_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");
    private final By PERSONAL_CABINET_BUTTON = By.xpath("//p[text()='Личный Кабинет']");

    // локаторы для вкладок
    private final String TAB_XPATH = "//div[contains(@class,'tab_tab__')][.//span[text()='%s']]";

    // метод для открытия сайта
    public void openStellarBurger() {
        driver.get("https://qa-stellarburgers.education-services.ru/");
    }

    // методы для кнопок
    public LoginPage clickLoginAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(LOGIN_ACCOUNT_BUTTON))
                .click();
        return new LoginPage(driver);
    }

    public LoginPage clickPersonalCabinetButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(PERSONAL_CABINET_BUTTON))
                .click();
        return new LoginPage(driver);
    }

    // методы для вкладок
    public void clickConstructorTab(String tabName) {
        WebElement tab = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(String.format(TAB_XPATH, tabName))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);
    }

    public boolean isTabActive(String tabName) {
        return driver.findElement(By.xpath(String.format(TAB_XPATH, tabName)))
                .getAttribute("class").contains("tab_tab_type_current");
    }
}