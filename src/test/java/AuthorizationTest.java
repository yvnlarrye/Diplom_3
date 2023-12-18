import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.*;


public class AuthorizationTest extends StellarBurgersTest {

    private User user;

    @Before
    public void onStartUp() {
        super.onStartUp();
        user = new User();
        accessToken = userAPI.createUser(user).then().extract().body().path("accessToken");
    }

    @Test
    @DisplayName("Check user can authorize by auth form")
    public void checkUserCanAuth() {
        driver.get(Constants.BASE_URI + AuthorizationPage.ROUTE);
        new AuthorizationPage(driver).authUser(user);
        Assert.assertTrue("Authorization failed : Create order button is not displayed",
                new MainPage(driver).isVisibleCreateOrderBtn());
    }

    @Test
    @DisplayName("Check user can be redirected to auth form by clicking Log In button")
    public void checkCanRedirectToAuthPageFromMainPageByLogInButton() {
        driver.get(Constants.BASE_URI);
        new MainPage(driver).clickLoginBtn();
        Assert.assertTrue("Auth form is not displayed", new AuthorizationPage(driver).authFormIsDisplayed());
    }

    @Test
    @DisplayName("Check user can be redirected to auth form by clicking profile button")
    public void checkCanRedirectToAuthPageFromMainPageByProfileButton() {
        driver.get(Constants.BASE_URI);
        new Header(driver).clickProfilePageBtn();
        Assert.assertTrue("Auth form is not displayed", new AuthorizationPage(driver).authFormIsDisplayed());
    }


    @Test
    @DisplayName("Check user can be redirected to auth form by clicking Log In button from registration page")
    public void checkCanRedirectToAuthPageFromRegistrationPageAuthButton() {
        driver.get(Constants.BASE_URI + RegistrationPage.ROUTE);
        new RegistrationPage(driver).clickLoginBtn();
        Assert.assertTrue("Authorization failed : Create order button is not displayed",
                new AuthorizationPage(driver).authFormIsDisplayed());
    }


    @Test
    @DisplayName("Check user can be redirected to auth form by clicking Log In button from forgot password page")
    public void checkCanRedirectToAuthPageFromForgotPasswordPageByAuthButton() {
        driver.get(Constants.BASE_URI + ForgotPasswordPage.ROUTE);
        new ForgotPasswordPage(driver).clickLoginBtn();
        Assert.assertTrue("Authorization failed : Create order button is not displayed",
                new AuthorizationPage(driver).authFormIsDisplayed());
    }
}
