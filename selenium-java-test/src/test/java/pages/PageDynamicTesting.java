package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageDynamicTesting {
    private WebDriver driver;
    
  
    private By locatorTitulo = By.tagName("h1");
    private By locatorBoton = By.id("boton-dinamico");
    private String titleWebPage = "Test Dynamic Table";

    // Constructor
    public PageDynamicTesting(WebDriver driver) {
        this.driver = driver;
    }


    public String getTitulo() {
        return driver.findElement(locatorTitulo).getText();
    }
    
    public void clickBoton() {
        driver.findElement(locatorBoton).click();
    }
    
    public String currentTitleWebPage() {
        return this.titleWebPage;
    }
    
    public void gotoUrl() {
    	driver.get("https://qaplayground.dev/apps/dynamic-table/");
    }
    
 
}