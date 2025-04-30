package app;

import base.TestBase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxDataTest extends TestBase {
    @Test
    public void shouldWaitUntilElementAppearsOnAjaxCall() {
        driver.get("http://uitestingplayground.com/ajax");
        driver.findElement(By.id("ajaxButton")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.bg-success")));
        
        String successText = driver.findElement(By.cssSelector("p.bg-success")).getText();
        assertEquals("Data loaded with AJAX get request.", successText);
    }
}