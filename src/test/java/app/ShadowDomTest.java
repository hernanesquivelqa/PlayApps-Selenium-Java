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
import pages.ShadowDomPage;

public class ShadowDomTest extends TestBase {
	private ShadowDomPage pageShadowDom;
	
	@BeforeEach
    public void  setUpPage() {
		pageShadowDom = new ShadowDomPage(driver);
		goToUrl(pageShadowDom.getUrl());
		
	}
	@Test
	public void initalStateOfProgressBar() {
    WebElement initalStateOfProgressBar =  pageShadowDom.progressBar();
    assertEquals("5", initalStateOfProgressBar.getAttribute("percent"));
    pageShadowDom.clickProgressBar();
    WebElement finalStateOfProgressBar = pageShadowDom.waitForProgressBarToBeAlmostFull();
    assertEquals("95", finalStateOfProgressBar.getAttribute("percent"));
	}
	
}
