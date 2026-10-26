package base;

import api.UserApi;
import model.UserModel;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    protected UserApi userApi;
    protected UserModel user;
    protected String accessToken;

    @Before
    public void setUp() {
        userApi = new UserApi();
        String email = "test" + System.currentTimeMillis() + "@yandex.ru";
        String password = "password123";
        user = new UserModel(email, password, "Ivan");

        accessToken = userApi.register(user).then().extract().path("accessToken");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userApi.delete(accessToken);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}