package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class ShadowDomTest extends TestBase {
	@BeforeEach
    public void  setUpPage() {
		goToUrl("https://qaplayground.dev/apps/shadow-dom/");
		
	}
	

	@Test
	public void secondTestCase() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Seleccionar el Shadow Host (<progress-bar>)
	        WebElement shadowHost = driver.findElement(By.tagName("progress-bar"));
	        assertEquals("5", shadowHost.getAttribute("percent"));

	        // Acceder al Shadow Root y obtener el botón dentro del Shadow DOM
	        WebElement button = (WebElement) js.executeScript(
	            "return arguments[0].shadowRoot.querySelector('.btn-green-outline');", 
	            shadowHost
	        );
	        button.click();
        // Espera explícita para que el atributo "percent" llegue a "95" (máximo 10 segundos)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {
       
            String attribute = shadowHost.getAttribute("percent");
            return "95".equals(attribute);
        });

        String attribute = shadowHost.getAttribute("percent");
        assertEquals("95", attribute);
	}
	
}
