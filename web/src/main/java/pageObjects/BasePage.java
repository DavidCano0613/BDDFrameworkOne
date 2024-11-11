package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver = null;
    public Properties prop = new Properties();;

    public WebDriver initializeDriver() throws IOException {
        String propPath = System.getProperty("user.dir").concat("/src/main/resources/config.properties");
        FileInputStream file = new FileInputStream(propPath);
        prop.load(file);

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String takeScreenShots(String testName, WebDriver driver) throws IOException {
        File SoruceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + testName + ".png";
        FileUtils.copyFile(SoruceFile, new File(destinationFilePath));

        return destinationFilePath;
    }


    /*
    public WebDriver initializeDriver() {
        Properties prop = loadProperties();

        if (prop == null) {
            throw new RuntimeException("Unable to load configuration properties.");
        }

        String browserName = prop.getProperty("browser", "chrome"); // Default to Chrome if property is missing

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browserName + "\" not supported.");
        }

        setupDriverDefaults();
        return driver;
    }

    private Properties loadProperties() {
        Properties prop = new Properties();
        String propPath = System.getProperty("user.dir") + "/src/main/resources/config.properties";

        try (FileInputStream file = new FileInputStream(propPath)) {
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    private void setupDriverDefaults() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    */

}