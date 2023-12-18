import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.AuthorizationPage;
import pom.Header;
import pom.MainPage;
import pom.ProfilePage;


public class ProfileTest extends StellarBurgersTest {

    private Header header;

    @Before
    public void onStartUp() {
        super.onStartUp();
        header = new Header(driver);
    }

    @Test
    @DisplayName("Open profile with authorization")
    public void openProfilePageWithAuthTest() {
        User user = new User();
        accessToken = userAPI.createUser(user).then().extract().body().path("accessToken");
        driver.get(Constants.BASE_URI + AuthorizationPage.ROUTE);
        new AuthorizationPage(driver).authUser(user);
        header.clickProfilePageBtn();
        boolean userDataDisplayed = new ProfilePage(driver, user).isVisibleUserData();

        Assert.assertTrue("User profile data hadn't displayed when user went to profile",
                userDataDisplayed);
    }

    @Test
    @DisplayName("Open profile without authorization")
    public void openProfilePageWithoutAuthTest(){
        driver.get(Constants.BASE_URI);
        header.clickProfilePageBtn();
        boolean authFormIsDisplayed = new AuthorizationPage(driver).authFormIsDisplayed();
        Assert.assertTrue("Authorization form hadn't displayed when went to profile",
                authFormIsDisplayed);
    }

    @Test
    @DisplayName("Open constructor from profile")
    public void openConstructorFromProfile() {
        User user = new User();
        accessToken = userAPI.createUser(user).then().extract().body().path("accessToken");
        driver.get(Constants.BASE_URI + AuthorizationPage.ROUTE);
        new AuthorizationPage(driver).authUser(user);
        header.clickProfilePageBtn();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForProfileElementsDisplayed();
        new Header(driver).clickConstructorBtn();
        new MainPage(driver).isVisibleCreateOrderBtn();
    }

    @Test
    @DisplayName("Click logo from profile")
    public void clickLogoFromProfile() {
        User user = new User();
        accessToken = userAPI.createUser(user).then().extract().body().path("accessToken");
        driver.get(Constants.BASE_URI + AuthorizationPage.ROUTE);
        new AuthorizationPage(driver).authUser(user);
        header.clickProfilePageBtn();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForProfileElementsDisplayed();
        new Header(driver).clickLogo();
        new MainPage(driver).isVisibleCreateOrderBtn();
    }

    @Test
    @DisplayName("Check user can log out")
    public void checkUserLogout() {
        User user = new User();
        accessToken = userAPI.createUser(user).then().extract().body().path("accessToken");
        driver.get(Constants.BASE_URI + AuthorizationPage.ROUTE);
        new AuthorizationPage(driver).authUser(user);
        header.clickProfilePageBtn();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForProfileElementsDisplayed();
        profilePage.clickLogoutButton();
        boolean authFormIsDisplayed = new AuthorizationPage(driver).authFormIsDisplayed();
        Assert.assertTrue("User wasn't redirected on auth page", authFormIsDisplayed);
    }
}
