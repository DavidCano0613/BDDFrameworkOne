import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumLearning {

    @Test
    public void run() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.get("https://omayo.blogspot.com/");
        //driver.manage().window().maximize();

        //Alerts
        //driver.findElement(By.id("alert2")).click();
        //Alert alert = driver.switchTo().alert();
        //alert.accept();

        //iFrames

        //id or name
        //driver.switchTo().frame("iframe1");
        //System.out.println(driver.findElement(By.id("Header1_headerimg")).isDisplayed());

        // WebElement
        // WebElement iframe2 = driver.findElement(By.xpath("//iframe[@src='https://selenium-by-arun.blogspot.com/']"));
        // driver.switchTo().frame(iframe2);
        // System.out.println(driver.findElement(By.cssSelector("h1")).isDisplayed());

        // to return to original context
        //driver.switchTo().defaultContent();
        // driver.findElement(By.xpath("//button[@value='LogIn']")).click();

        //Switch to Another window


        //Drop-downs
        //WebElement dropdown = driver.findElement(By.id("drop1"));  // Cambia "id_del_dropdown" al id real de tu elemento

        //Select select = new Select(dropdown);
        //select.selectByVisibleText("doc 1");
        //select.selectByValue("mno");

        // only when the select is created to select multiple options
        //select.deselectByValue("mno");

        //List<WebElement> options = select.getOptions();
        //for (WebElement option : options) {
        //    System.out.println(option.getText());
        //}

        // Actions Class
        //driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //driver.manage().window().maximize();
        //Actions actions = new Actions(driver);

        // Arrastrar y soltar
        //WebElement origen = driver.findElement(By.id("box5"));
        //WebElement destino = driver.findElement(By.id("box105"));
        //actions.dragAndDrop(origen, destino).perform();
        //System.out.println("hola");

    }

}