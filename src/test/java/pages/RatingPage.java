package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RatingPage {
    private WebDriver driver;
    private By oneStarButton = By.cssSelector("label.star-1");
    private By ratingText = By.cssSelector(".footer .text");
    private String url = "https://qaplayground.dev/apps/rating/";

    public RatingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOneStar() {
        driver.findElement(oneStarButton).click();
    }
    public String getUrl() {
    	return url;
    	
    }

    public String getRatingMessage() {
        WebElement element = driver.findElement(ratingText);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(
            "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
            element
        );
    }
}