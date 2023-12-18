package pom;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage extends Page {

    public static final String ROUTE = "login";

    private final By authForm = By.xpath(".//div[starts-with(@class, 'Auth_login')]");
    private final By btnLogin =By.xpath(".//button[text()='Войти']");
    private final By inputEmail = By.xpath(".//label[text()='Email']/parent::div/input");
    private final By inputPassword = By.xpath(".//input[@type='password']");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public boolean authFormIsDisplayed() {
        WebElement element = new WebDriverWait(driver, TIME_OUT).until(
                ExpectedConditions.visibilityOfElementLocated(authForm));
        return element != null;
    }

    @Step("Filling auth form data")
    private void fillAuthData(String email, String password) {
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Click login button")
    private void clickAuthBtn() {
        driver.findElement(btnLogin).click();
    }

    public void authUser(User user) {
        fillAuthData(user.getEmail(), user.getPassword());
        clickAuthBtn();
    }
}
