package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.*;

public class GeneratorQR {

    protected WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @BeforeEach
    public void setup() {
    	driver = new ChromeDriver();
        driver.get("https://qaplayground.dev/apps/qr-code-generator/");
        String title = driver.getTitle();
        assertEquals("Test QR Code Generator", title);
    }

    @Test
    public void testGeneratedQRCodeMatchesInput() {
        String expectedQrData = "https://qaplayground.dev/";

        driver.findElement(By.cssSelector("input[type=text]")).sendKeys(expectedQrData);
        driver.findElement(By.cssSelector(".form button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement qrImageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".qr-code img"))
        );

        String qrImageUrl = qrImageElement.getAttribute("src");
        String actualQrData = qrImageUrl.split("data=")[1];

        assertEquals(expectedQrData, actualQrData);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}