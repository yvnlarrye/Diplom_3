import constants.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.MainPage;

public class ConstructorTest extends StellarBurgersTest {
    private MainPage mainPage;

    @Before
    public void onStartUp() {
        super.onStartUp();
        mainPage = new MainPage(driver);
        driver.get(Constants.BASE_URI);
    }

    @Test
    @DisplayName("Open bun section in constructor")
    public void openBunSectionTest() {
        /* Bun section is picked by default and not clickable.
            That is why I need to switch to another section before click bun section button
         */
        mainPage.clickFillingSectionBtn();
        mainPage.clickBunSectionBtn();
        Assert.assertTrue("Bun section is not displayed", mainPage.isVisibleBunSection());
    }


    @Test
    @DisplayName("Open filling section in constructor")
    public void openFillingSectionTest() {
        mainPage.clickFillingSectionBtn();
        Assert.assertTrue("Filling section is not displayed", mainPage.isVisibleFillingSection());
    }

    @Test
    @DisplayName("Open sauce section in constructor")
    public void openSauceSectionTest() {
        mainPage.clickSauceSectionBtn();
        Assert.assertTrue("Sauce section is not displayed", mainPage.isVisibleSauceSection());
    }

}
