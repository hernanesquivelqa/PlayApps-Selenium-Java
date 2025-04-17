package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PageCookie {
	private String url = "https://demo.guru99.com/test/cookie/selenium_aut.php";
	private WebDriver driver;
    @FindBy(css = "h2.form-signin-heading center")
    private WebElement textSignIn;
 
	@FindBy(css = "[name='username']")
	private WebElement username;
	@FindBy(css = "[name='password']")
	private WebElement password;
	@FindBy(css = "[name='submit']")
	private WebElement submit;
	public PageCookie(WebDriver driver){
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public void typeUsername() {
		username.sendKeys("Selenium");
	}
	public void typePassword() {
		password.sendKeys("abc123");
	}
	 
	public void loginIn() {
		typeUsername();
		typePassword();
		submit.click();
	}
    public String getUrl() {
        return this.url;
    }
    public void new_url_is_visible() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlContains("selenium_cookie.php"));
    }
    public void getCookies() {

	    Set<Cookie> cookies = driver.manage().getCookies();
	    for (Cookie cookie : cookies) {
	        System.out.println(cookie.getName() + ": " + cookie.getValue());
	    } 
	    
    }
    public String getTextSignIn() {
    	return textSignIn.getText();
    }
    public void deleteCookie() {
	    driver.manage().deleteCookieNamed("Selenium");
    }

}


