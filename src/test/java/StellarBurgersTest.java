import api.UserAPI;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StellarBurgersTest {
    protected WebDriver driver;
    protected String accessToken;
    protected final UserAPI userAPI = new UserAPI();

    @Before
    public void onStartUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) {
            userAPI.deleteUser(accessToken);
            accessToken = null;
        }
    }
}