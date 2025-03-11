package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
     
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
  
        if (driver != null) {
            driver.quit();
        }
    }
}