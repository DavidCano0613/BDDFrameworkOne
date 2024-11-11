
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BasePage;

import java.io.IOException;

public class dummyOneTest extends BasePage {
    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("baseUrl"));
    }

    @Test
    public void testOne() throws IOException {
        System.out.println("Run dummy one test");
    }

    @AfterMethod
    public void closure() {
        driver.close();
    }
}