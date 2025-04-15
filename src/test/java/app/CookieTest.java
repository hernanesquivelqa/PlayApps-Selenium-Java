package app;

import base.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookieTest extends TestBase {
	@Test
	public void test_login_in() {
	    goToUrl("https://demo.guru99.com/test/cookie/selenium_aut.php");
	    
	    driver.findElement(By.cssSelector("[name='username']")).sendKeys("Selenium");
	    driver.findElement(By.cssSelector("[name='password']")).sendKeys("abc123");
	    driver.findElement(By.cssSelector("[name='submit']")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlContains("selenium_cookie.php"));
	    
	    String new_url = driver.getCurrentUrl();
	    assertTrue(new_url.contains("selenium_cookie.php"), "La URL no contiene 'selenium_cookie.php'");
	    
	  
	    System.out.println("Cookies antes de eliminar:");
	    Set<Cookie> cookies = driver.manage().getCookies();
	    for (Cookie cookie : cookies) {
	        System.out.println(cookie.getName() + ": " + cookie.getValue());
	    }
	    
	    driver.navigate().refresh();
	    String logged = driver.findElement(By.cssSelector("h2.form-signin-heading center")).getText();
	    assertEquals(logged, "You are logged In");
	    
	    driver.manage().deleteCookieNamed("Selenium");
	    
	    System.out.println("Cookies después de eliminar:");
	    cookies = driver.manage().getCookies();
	    for (Cookie cookie : cookies) {
	        System.out.println(cookie.getName() + ": " + cookie.getValue());
	    }
	}
}