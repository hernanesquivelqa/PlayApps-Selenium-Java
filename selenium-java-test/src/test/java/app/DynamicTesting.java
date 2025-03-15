package app;

import org.openqa.selenium.WebElement;
import base.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PageDynamicTesting;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicTesting extends TestBase {
    
    private PageDynamicTesting pageDynamicTesting;
    
    @BeforeEach
    public void setUpPage() {
        pageDynamicTesting = new PageDynamicTesting(driver);
        pageDynamicTesting.gotoUrl();
    }
    @Test
    public void testCurrentTitleWebPage() {
        String titleWebPage = driver.getTitle();
        assertEquals(pageDynamicTesting.currentTitleWebPage(), titleWebPage);
    }
    @Test
    public void testHeaderTextShouldBeVisible() {
        WebElement headerText = pageDynamicTesting.superHeroBeVisible();
        assertTrue(headerText.isDisplayed(), "The SUPERHERO element should be visible.");
    }  
    @Test
    public void testShouldReturnSpidermanRealNameAsPeterParker() {
    	WebElement spidermanRowLocator = pageDynamicTesting.getSpiderManRowLocator();
    	String realNameHero = pageDynamicTesting.getTextSpiderMan();
    	assertTrue(spidermanRowLocator.isDisplayed());
    	assertEquals("Peter Parker", realNameHero);
    	
    }   
}
