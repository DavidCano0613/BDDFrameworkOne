package stepDefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;

import java.io.IOException;

public class Hooks extends BasePage {
    public WebDriver driver = null;

    public void openAnyBowser() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("baseUrl"));
    }

    public void closeBrowser() {
        driver.close();
    }
}
