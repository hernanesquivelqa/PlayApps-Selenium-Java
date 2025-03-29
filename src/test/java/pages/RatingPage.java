package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RatingPage {
    private WebDriver driver;
    private final String PAGE_URL = "https://qaplayground.dev/apps/rating/";
    private final By firstStarButton = By.cssSelector("label.star-1");

    private final List<By> starButtons = Arrays.asList(
            By.cssSelector("label.star-1"),
            By.cssSelector("label.star-2"),
            By.cssSelector("label.star-3"),
            By.cssSelector("label.star-4"),
            By.cssSelector("label.star-5")
        );
        
        private final List<String> expectedMessages = Arrays.asList(
            "I just hate it", 
            "I don't like it", 
            "This is awesome", 
            "I just like it", 
            "I just love it"
        );
        
    private By ratingMessageLocator = By.cssSelector(".footer .text");
    private By ratingNumberLocator = By.cssSelector(".footer .numb");

    public RatingPage(WebDriver driver) {
        this.driver = driver;
    }

    /** 
     * Clicks on the one-star rating button.
     */
    public void selectOneStar() {
        driver.findElement(firstStarButton).click();
    }

    /** 
     * Returns the URL of the rating page.
     */
    public String getPageUrl() {
        return PAGE_URL;
    }

    /** 
     * Retrieves the rating message displayed using the CSS pseudo-element "::before".
     */
    public String getRatingMessage() {
        return getPseudoElementContent(driver.findElement(ratingMessageLocator));
    }

    /** 
     * Retrieves the numeric rating value displayed using the CSS pseudo-element "::before".
     */
    public String getRatingNumber() {
        return getPseudoElementContent(driver.findElement(ratingNumberLocator));
    }

    /**
     * Helper method to extract the "content" property of a CSS "::before" pseudo-element.
     */
    private String getPseudoElementContent(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(
            "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
            element
        );
    }
    
        public void eachStarClick() {
            for (int i = 0; i < starButtons.size(); i++) {
                WebElement star = driver.findElement(starButtons.get(i));
                star.click();
                
                String expectedMessage = expectedMessages.get(i);
                String ratingMessage = getRatingMessage();
                assertTrue(ratingMessage.contains(expectedMessage));
                
        
            }
        }

    
    
    
}