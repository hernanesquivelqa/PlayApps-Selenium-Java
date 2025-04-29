package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import base.TestBase;
import pages.RightClickPage;

public class RightClickTest extends TestBase {
    private RightClickPage page;

    @BeforeEach
    public void setupPage() {
        page = new RightClickPage(driver);
        goToUrl(page.getUrl());
    }

    @Test
    public void testRightClick() {
        page.rightClickMainElement();
    }

    @Test
    public void testRightClickShareOption() {
        page.rightClickMainElement();
        page.hoverOverShareOption();
        String html = page.getShareOptionHtml();
        System.out.println(html);
    }

    @Test
    public void testRightClickShareOptionTwitter() {
        page.rightClickMainElement();
        page.hoverOverShareOption();
        page.clickTwitterMenuItem();
        String currentMessage = page.getMessageText();
        assertEquals("Menu item Twitter clicked", currentMessage);
    }
}