import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.AuthorizationPage;
import pom.RegistrationPage;
import org.apache.commons.lang3.RandomStringUtils;

public class RegistrationTest extends StellarBurgersTest {
    private static final String PAGE_ROUTE = "register";

    @Before
    public void onStartUp() {
        super.onStartUp();
        driver.get(Constants.BASE_URI + PAGE_ROUTE);
    }

    @Test
    @DisplayName("Check user can register when he fill correct data into form")
    public void checkWhenCorrectRegistrationDataCanRegister() {
        User user = new User();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(user);

        accessToken = userAPI.loginUser(user.getEmail(), user.getPassword())
                .then().extract().body().path("accessToken");

        boolean authFormIsDisplayed = new AuthorizationPage(driver).authFormIsDisplayed();
        Assert.assertTrue("Registration failed, but supposed to be completed", authFormIsDisplayed);
    }

    @Test
    @DisplayName("Check user can't register with password that is shorted than six symbols")
    public void checkRegistrationWhenEnterPasswordShorterThatSixSymbolsGetAnError() {
        User user = new User();
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(user);
        boolean incorrectPasswordMessageDisplayed = registrationPage.isIncorrectPasswordErrorDisplayed();
        Assert.assertTrue("Incorrect password message hasn't been displayed",
                incorrectPasswordMessageDisplayed);
    }
}
