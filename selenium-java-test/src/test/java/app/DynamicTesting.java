package app;

import base.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PageDynamicTesting;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicTesting extends TestBase {
    
    private PageDynamicTesting pageDynamicTesting;
    
    @BeforeEach
    public void setUpPage() {
        pageDynamicTesting = new PageDynamicTesting(driver);
        pageDynamicTesting.gotoUrl();
    }
    
    @Test
    public void testOne() {
        String titleWebPage = driver.getTitle();
        assertEquals(pageDynamicTesting.currentTitleWebPage(), titleWebPage);
    }
    
}