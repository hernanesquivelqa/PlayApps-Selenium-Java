package pages;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PagePopUp {
	private WebDriver driver;
	private By buttonLogin = By.id("login");
	private By buttonPopUpSubmit = By.cssSelector("#wrapper button");
	private By infoText = By.id("info");
	private String url = "https://qaplayground.dev/apps/popup/#";
	private String buttonNotClicked ="Click to open pop-up";
	private String buttonClicked = "Button Clicked";

	public PagePopUp(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickButton() {
		driver.findElement(buttonLogin).click();
	}

	public String getUrl() {
		return url;
	}
	
	public void popUpClickSubmit() {
	    // Guardar el identificador de la ventana principal
	    String mainWindow = driver.getWindowHandle();
	    // Esperar hasta que se abra una nueva ventana
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String window : allWindows) {
	        if (!window.equals(mainWindow)) {
	            driver.switchTo().window(window); // Cambiar al pop-up
	            break;
	        }
	    }
	
	    // Hacer clic en el botón dentro del pop-up
	    driver.findElement(buttonPopUpSubmit).click();
	
	    // Volver a la ventana principal
	    driver.switchTo().window(mainWindow);
	}
	public String getInfoText() {
		return driver.findElement(infoText).getText();
	}

	public String getButtonClicked() {
		return buttonClicked;
	}
	public String getButtonNotClicked() {
		return buttonNotClicked;
	}

}
