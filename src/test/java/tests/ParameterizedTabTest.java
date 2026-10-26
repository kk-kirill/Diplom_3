package tests;

import driver.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ParameterizedTabTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private final String tabName;

    public ParameterizedTabTest(String tabName) {
        this.tabName = tabName;
    }

    @Parameterized.Parameters(name = "Вкладка: {0}")
    public static Object[][] tabs() {
        return new Object[][]{
                {"Булки"},
                {"Соусы"},
                {"Начинки"}
        };
    }

    @DisplayName("Переключение вкладок конструктора")
    @Description("Проверяем, что при клике на вкладку она становится активной")
    @Test
    public void switchConstructorTab_showsActiveTab() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openStellarBurger();

        if (tabName.equals("Булки")) {
            mainPage.clickConstructorTab("Соусы"); // уходим с булок
        }
        mainPage.clickConstructorTab(tabName);
        mainPage.clickConstructorTab(tabName);
        assertTrue("Вкладка '" + tabName + "' должна стать активной",
                mainPage.isTabActive(tabName));
    }
}
