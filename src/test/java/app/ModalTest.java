package app;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import base.TestBase;

public class ModalTest extends TestBase {

    @Test
    public void testModal() {
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        // Reinicia el modal
        //driver.findElement(By.cssSelector("#restart-ad")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));

      
        WebElement closeButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("div.modal-footer > p"))
        );
        closeButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modal")));

   
        WebElement modal = driver.findElement(By.id("modal"));
        assertFalse(modal.isDisplayed(), "El modal todavía está visible.");
    }
}
