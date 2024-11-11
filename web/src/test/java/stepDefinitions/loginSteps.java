package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.AccountPage;
import pageObjects.BasePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import java.io.IOException;

public class loginSteps extends BasePage {
    public WebDriver driver = null;
    LoginPage loginPage;
    LandingPage landingPage;
    AccountPage accountPage;

    @Given("User has navigated to Login page")
    public void navigateToLoginPage() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("baseUrl"));
        landingPage = new LandingPage(driver);
        landingPage.clickMyAccountTap();
        landingPage.clickLoginOption();
    }

    @When("User enters username as {string} and password as {string}")
    public void enterUserNameAndPassword(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("User clicks on Login button")
    public void clickLoginBtn() {
        loginPage.clickLoginButton();
    }

    @Then("Verify user is able to successfully login")
    public void loginSuccessfully() {
        accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.myAccountSectionIsPresent());
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}