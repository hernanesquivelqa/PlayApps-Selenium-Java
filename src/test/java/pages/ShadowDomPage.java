package pages;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowDomPage {
	private WebDriver driver;
	@FindBy(tagName = "progress-bar" )
	private WebElement progressBar;
	
	private String url = "https://qaplayground.dev/apps/shadow-dom/";
  public ShadowDomPage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	  
  }
public String getUrl() {
	return url;
}
public WebElement progressBar() {
    WebElement shadowHost = progressBar;
    return shadowHost;
}
public void clickProgressBar () {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement shadowHost = progressBar();
    WebElement button = (WebElement) js.executeScript(
        "return arguments[0].shadowRoot.querySelector('.btn-green-outline');", 
        shadowHost
    );
    button.click();
}
public WebElement waitForProgressBarToBeAlmostFull() {
    WebElement shadowHost = progressBar();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(driver -> {
        String attribute = shadowHost.getAttribute("percent");
        return "95".equals(attribute);
    });
    return shadowHost;
}

}
