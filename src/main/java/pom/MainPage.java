package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    private final By btnLogin = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By btnCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    private final By sauceSectionBtn = By.xpath(".//span[text()='Соусы']");
    private final By bunSectionBtn = By.xpath(".//span[text()='Булки']");
    private final By fillingSectionBtn = By.xpath(".//span[text()='Начинки']");
    private final By sauceSection = By.xpath(".//span[text()='Соусы']/parent::div[contains (@class, 'current')]");
    private final By bunSection = By.xpath(".//span[text()='Булки']/parent::div[contains (@class, 'current')]");
    private final By fillingSection = By.xpath(".//span[text()='Начинки']/parent::div[contains (@class, 'current')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check create order button is displayed after authorization")
    public boolean isVisibleCreateOrderBtn() {
        WebElement element = new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(btnCreateOrder));
        return element != null;
    }

    @Step("Click log in button on main page")
    public void clickLoginBtn() {
        driver.findElement(btnLogin).click();
    }

    @Step("Click sauce section button on main page")
    public void clickSauceSectionBtn() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.elementToBeClickable(sauceSectionBtn));
        driver.findElement(sauceSectionBtn).click();
    }

    @Step("Click bun section button on main page")
    public void clickBunSectionBtn() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.elementToBeClickable(bunSectionBtn));
        driver.findElement(bunSectionBtn).click();
    }

    @Step("Click filling section button on main page")
    public void clickFillingSectionBtn() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.elementToBeClickable(fillingSectionBtn));
        driver.findElement(fillingSectionBtn).click();
    }

    @Step("Check sauce section is visible on main page")
    public boolean isVisibleSauceSection() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sauceSection));
        return driver.findElement(sauceSection).isDisplayed();
    }

    @Step("Check bun section is visible on main page")
    public boolean isVisibleBunSection() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bunSection));
        return driver.findElement(bunSection).isDisplayed();
    }

    @Step("Check filling section is visible on main page")
    public boolean isVisibleFillingSection() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fillingSection));
        return driver.findElement(fillingSection).isDisplayed();
    }
}
