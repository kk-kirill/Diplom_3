package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.UserModel;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URL = "https://qa-stellarburgers.education-services.ru";

    @Step("Создание пользователя через API")
    public Response register(UserModel user) {
        return given()
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL)
                .body(user)
                .when()
                .post("/api/auth/register");
    }

    @Step("Удаление пользователя через API")
    public Response delete(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .baseUri(BASE_URL)
                .when()
                .delete("/api/auth/user");
    }

    @Step("Логин пользователя через API")
    public Response login(UserModel user) {
        return given()
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL)
                .body(user)
                .when()
                .post("/api/auth/login");
    }
}