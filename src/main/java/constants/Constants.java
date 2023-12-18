package constants;

public class Constants {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";
    private static final String USER_ENDPOINT = "/api/auth";
    public static final String CREATE_USER_ROUTE = USER_ENDPOINT + "/register";
    public static final String CHANGE_USER_ROUTE = USER_ENDPOINT + "/user";
    public static final String LOGIN_USER_ROUTE = USER_ENDPOINT + "/login";
    public static final String JSON_CONTENT_TYPE = "application/json";
}
