package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class VerifyAccountPage {
    private WebDriver driver;
    private String url = "https://qaplayground.dev/apps/verify-account/";
    private By inputs = By.cssSelector("input[type='number']");
    private By successText = By.cssSelector(".info.success");
    public VerifyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoUrl() {
        driver.get(url);
    }
    

    public void fillInputs(String value) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	List<WebElement> inputElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(inputs));
    	
    	if(!inputElements.isEmpty()) {
    	    int sizeInputs = inputElements.size() - 1;
    	    for  (int i= 0; i <= sizeInputs; i++) {
    	    	WebElement eachInput = inputElements.get(i);
    	    	eachInput.clear();
    	    	eachInput.sendKeys(value);
    	    }
    		
    	} else {
    		throw new RuntimeException("No se encontraron inputs en la página.");
    	}
    }
    public String getSuccessText() {
    	String text = driver.findElement(successText).getText();
    	return text;
    }
    
    
}

