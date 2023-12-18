package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.User;

import java.util.HashMap;
import java.util.Map;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class UserAPI {

    public UserAPI() {
        RestAssured.baseURI = BASE_URI;
    }

    @Step("Создание пользователя")
    public Response createUser(User user){
        HashMap<String, String> userData = new HashMap<>();
        userData.put("email", user.getEmail());
        userData.put("password", user.getPassword());
        userData.put("name", user.getUsername());
        return given()
                .header("Content-type", JSON_CONTENT_TYPE)
                .and()
                .body(userData)
                .when()
                .post(CREATE_USER_ROUTE);
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .delete(CHANGE_USER_ROUTE);
    }

    @Step("Логин пользователя")
    public Response loginUser(String email, String password) {
        Map<String, String> loginData = new HashMap<>();
        loginData.put("email", email);
        loginData.put("password", password);
        return given()
                .header("Content-type", JSON_CONTENT_TYPE)
                .and()
                .body(loginData)
                .when()
                .post(LOGIN_USER_ROUTE);
    }
}
