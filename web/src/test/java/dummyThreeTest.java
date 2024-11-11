import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BasePage;

import java.io.IOException;

public class dummyThreeTest extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(dummyThreeTest.class);
    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = new ChromeDriver();
        driver.get(prop.getProperty("baseUrl"));
    }

    @Test
    public void testThree() throws IOException {
        logger.info("This is an info log message.");
        System.out.println("Run dummy one test");
        logger.error("This is an error log message.");
    }

    @AfterMethod
    public void closure() {
        driver.close();
    }
}