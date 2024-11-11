import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import java.io.IOException;

public class InvalidCredentialsLoginTest  extends BasePage {
    public WebDriver driver = null;

    @DataProvider(name="LoginDataProvider")
    public Object[][] getCredentials () {
        Object[][] data = {
                {"da","fe"},
                {"ddsa","wqqw"},
                {"wqw","df"},
                {"sdsd","dsd"}
        };
        return data;
    }

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("baseUrl"));
    }

    @Test(dataProvider = "LoginDataProvider")
    public void invalidCredentials(String email, String password) throws IOException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickMyAccountTap();
        landingPage.clickLoginOption();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    @AfterMethod
    public void closure() {
        driver.close();
    }
}
