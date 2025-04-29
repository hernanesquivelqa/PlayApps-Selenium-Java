package app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.TestBase;
import pages.PopUpPage;
public class PopUpTest extends TestBase {
	private PopUpPage page;
	@BeforeEach
	public void setupUpPage() {
		page = new PopUpPage(driver);
		goToUrl(page.getUrl());
		assertEquals(page.getButtonNotClicked(), page.getInfoText());
		
	}
	@Test
	public void openPopUp() {
		page.clickButton();
		page.popUpClickSubmit();
	    assertEquals(page.getButtonClicked(), page.getInfoText());
	}


}
