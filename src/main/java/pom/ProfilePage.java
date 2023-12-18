package pom;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends Page {

    private User user;

    private final By inputLogin = By.xpath(".//label[text()='Логин']/parent::div/input");
    private final By inputPassword = By.xpath(".//input[@type='password']");
    private final By inputName = By.xpath(".//label[text()='Имя']/parent::div/input");
    private final By logoutBtn = By.xpath(".//button[text()='Выход']");


    public ProfilePage(WebDriver driver, User user) {
        super(driver);
        this.user = user;
    }

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("When go to profile waiting for all elements of profile displayed")
    public void waitForProfileElementsDisplayed() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(inputLogin));
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(inputName));
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
    }

    @Step("Check user data is visible in profile")
    public boolean isVisibleUserData() {
        waitForProfileElementsDisplayed();

        WebElement login = driver.findElement(inputLogin);
        WebElement name = driver.findElement(inputName);
        WebElement pass = driver.findElement(inputPassword);

        return (login.getAttribute("value").equals(user.getEmail()) &&
                name.getAttribute("value").equals(user.getUsername()) &&
                pass.getAttribute("value").equals("*****"));
    }

    @Step("Click logout button")
    public void clickLogoutButton() {
        driver.findElement(logoutBtn).click();
    }

}
