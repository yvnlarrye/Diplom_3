package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage extends Page {

    public static final String ROUTE = "forgot-password";

    private final By loginBtn = By.xpath(".//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click login button on forgot password page")
    public void clickLoginBtn() {
        new WebDriverWait(driver, TIME_OUT)
                .until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
    }

}
