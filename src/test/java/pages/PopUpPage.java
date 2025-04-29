package pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePopUp {
    private WebDriver driver;
    
    @FindBy(id = "login")
    private WebElement buttonLogin;

    @FindBy(css = "#wrapper button")
    private WebElement buttonPopUpSubmit;

    @FindBy(id = "info")
    private WebElement infoText;
    
    private String url = "https://qaplayground.dev/apps/popup/#";
    private String buttonNotClicked = "Click to open pop-up";
    private String buttonClicked = "Button Clicked";

    // Constructor con inicialización de PageFactory
    public PagePopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickButton() {
        buttonLogin.click(); 
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
    
      
        buttonPopUpSubmit.click();
        // Volver a la ventana principal
        driver.switchTo().window(mainWindow);
    }

    public String getInfoText() {
        return infoText.getText();
        		}

    public String getButtonClicked() {
        return buttonClicked;
    }

    public String getButtonNotClicked() {
        return buttonNotClicked;
    }
}