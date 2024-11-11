import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreenShotExample {

    @Test
    public void run() {
        // Configurar el driver de Chrome automáticamente
        WebDriverManager.chromedriver().setup();

        // Crear instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navegar a Google
            driver.get("https://www.google.com");

            // Tomar la captura de pantalla
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Definir la ubicación donde se guardará la captura de pantalla
            String filePath = "src/test/resources/EIPComplete.png";
            File destFile = new File(filePath);

            // Guardar la captura de pantalla en el archivo destino
            FileHandler.copy(srcFile, destFile);

            System.out.println("Captura de pantalla guardada en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar la captura de pantalla: " + e.getMessage());
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}