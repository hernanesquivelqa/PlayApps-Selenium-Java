package app;
import pages.PageCookie;
import base.TestBase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CookieTest extends TestBase {
	private PageCookie page;
	@BeforeEach
	public void setupPage() {
	    page = new PageCookie(driver);
	}
	@Test
	public void test_login_in() {
	    goToUrl(page.getUrl());
        page.loginIn();
        page.new_url_is_visible();
        driver.navigate().refresh(); // Refresh page due to known UI defect requiring reload to display content correctly
	    String logged = page.getTextSignIn();
	    assertEquals(logged, "You are logged In");   
	    page.deleteCookie();
	    
	}
}