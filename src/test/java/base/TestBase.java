package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    protected WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
     
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless");
        options.addArguments("--no-sandbox");         // Necesario en entornos CI como GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Evita problemas de memoria compartida en CI
        options.addArguments("--remote-allow-origins=*"); // Soluciona problemas de conexión WebSocket en versiones recientes

        // Inicializar el driver con las opciones
        driver = new ChromeDriver(options);
    }
    public void goToUrl(String url) {
        driver.get(url);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}