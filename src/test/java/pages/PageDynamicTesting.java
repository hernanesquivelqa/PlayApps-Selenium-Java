package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.WebDriverWait;  
import org.openqa.selenium.support.ui.ExpectedConditions;  
import java.time.Duration; 

public class PageDynamicTesting {
    private WebDriver driver;
    private String url = "https://qaplayground.dev/apps/dynamic-table/";
    private By locatorTitulo = By.tagName("h1");
    private By locatorBoton = By.id("boton-dinamico");
    private String titleWebPage = "Test Dynamic Table";
    private By locatorSuperHeroHeader = By.xpath("//th[contains(text(),'Superhero')]");
   
    private By locatorSpiderManRow = By.xpath("//div[contains(text(),'Spider-Man')]/../../../..");
    private By locatorRealNameSuperHero = By.xpath("//tr//td[3]//span[text()='Peter Parker']");
    
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
    
    public String getUrl() {
        return this.url;
    }
    public WebElement superHeroBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locatorSuperHeroHeader));
    }
    public WebElement getSpiderManRowLocator() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locatorSpiderManRow));
            
    }
    public WebElement getSpiderManRealNameCell() {
    	
      return getSpiderManRowLocator().findElement(locatorRealNameSuperHero);
    }
    
    public String getTextSpiderMan() {
    	return getSpiderManRealNameCell().getText();
    }
    
}