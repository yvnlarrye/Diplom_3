package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends Page {
    private final By constructorBtn = By.xpath(".//a[@href='/']/p[text()='Конструктор']");
    private final By profilePageBtn = By.xpath(".//a[@href='/account']");
    private final By logoBtn = By.xpath(".//div[starts-with(@class, 'AppHeader_header__logo')]");

    public Header(WebDriver driver) {
        super(driver);
    }

    @Step("Click logo button")
    public void clickLogo(){
        driver.findElement(logoBtn).click();
    }

    @Step("Click constructor button")
    public void clickConstructorBtn() {
        driver.findElement(constructorBtn).click();
    }

    @Step("Click profile button")
    public void clickProfilePageBtn () {
        driver.findElement(profilePageBtn).click();
    }

}
