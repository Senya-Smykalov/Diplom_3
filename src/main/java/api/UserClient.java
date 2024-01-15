package api;

import io.qameta.allure.Step;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
import model.User;

import static io.restassured.RestAssured.given;

public class UserClient {
    public static final String createUserEndPoint = "/api/auth/register";
    public static final String loginUserEndPoint = "/api/auth/login";
    public static final String deleteUserEndPoint = "/api/auth/user";
    private static User user = new User("muBest@exmaple.com", "zxcvbnm", "Jonny");
    static Header header = new Header("Content-type", "application/json");

    public static String email = "muBest@exmaple.com";

    public static String password = "zxcvbnm";

    @Step("Создание пользователя")
    public void createUser() {
        given()
                .header(header)
                .body(user)
                .post(createUserEndPoint)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Step("Авторизация пользователя")
    public ValidatableResponse authUser() {
        return given()
                .header(header)
                .body(user)
                .post(loginUserEndPoint)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .delete(deleteUserEndPoint)
                .then()
                .log()
                .all()
                .statusCode(202);
    }

}
