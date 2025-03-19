package app;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.TestBase;
import pages.PagePopUp;
public class PopUpTest extends TestBase {
	private PagePopUp page;
	@BeforeEach
	public void setupUpPage() {
		page = new PagePopUp(driver);
		goToUrl(page.getUrl());
		assertEquals(page.getButtonNotClicked(), page.getInfoText());
		
	}
	@Test
	public void openPopUp() throws InterruptedException {
		page.clickButton();
		page.popUpClickSubmit();
	    assertEquals(page.getButtonClicked(), page.getInfoText());
	}


}
