import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.BasePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import java.io.IOException;

public class ValidCredentialsLoginTest extends BasePage {
    public WebDriver driver = null;

    String email = "david0613pc@gmail.com";
    String password = "Vainilla&Almendra2*";

    @Test
    public void validCredentials() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("baseUrl"));

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickMyAccountTap();
        landingPage.clickLoginOption();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.myAccountSectionIsPresent());
   }

    @AfterMethod
    public void closure() {
        driver.close();
    }
}
