package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountTap;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickMyAccountTap() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountTap));
        myAccountTap.click();
    }

    public void clickLoginOption() {
        wait.until(ExpectedConditions.elementToBeClickable(loginOption));
        loginOption.click();
    }
}