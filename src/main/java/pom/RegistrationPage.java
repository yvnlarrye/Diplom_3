package pom;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends Page {

    public static final String ROUTE = "register";

    private final By inputName = By.xpath(".//label[text()='Имя']/parent::div/input");
    private final By inputEmail = By.xpath(".//label[text()='Email']/parent::div/input");
    private final By inputPassword = By.xpath(".//input[@type='password']");
    private final By btnRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By incorrectPasswordError = By.className("input__error");
    private final By loginBtn = By.xpath(".//a[@href='/login']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling registration form data")
    private void fillDataRegistration(String name, String email, String password) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Click registration button")
    private void clickRegistrationBtn(){
        driver.findElement(btnRegistration).click();
    }

    public void registerUser(User user) {
        fillDataRegistration(user.getUsername(), user.getEmail(), user.getPassword());
        clickRegistrationBtn();
    }

    @Step("Check incorrect password error displayed")
    public boolean isIncorrectPasswordErrorDisplayed() {
        WebElement element = new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordError));
        return element != null;
    }

    @Step("Click login button")
    public void clickLoginBtn() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
    }

}
