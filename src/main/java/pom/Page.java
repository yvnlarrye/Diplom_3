package pom;

import org.openqa.selenium.WebDriver;

public class Page {
    protected final WebDriver driver;
    public static final int TIME_OUT = 3;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
