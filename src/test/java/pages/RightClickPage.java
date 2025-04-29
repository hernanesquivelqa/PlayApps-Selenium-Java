package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RightClickPage {
    private WebDriver driver;
    private String url = "https://qaplayground.dev/apps/context-menu/";
    private By mainElement = By.cssSelector("main[role='main']");
    private By shareOption = By.cssSelector(".menu-item.share");
    private By twitterMenuItem = By.xpath("//li[contains(@class, 'menu-item')]//span[contains(text(), 'Twitter')]");
    private By messageElement = By.cssSelector("p#msg");

    public RightClickPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return this.url;
    }

    public void rightClickMainElement() {
        WebElement element = driver.findElement(mainElement);
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }

    public void hoverOverShareOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shareElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shareOption));
        Actions action = new Actions(driver);
        action.moveToElement(shareElement).perform();
    }

    public String getShareOptionHtml() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shareElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shareOption));
        return shareElement.getAttribute("outerHTML");
    }

    public void clickTwitterMenuItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement twitterElement = wait.until(ExpectedConditions.elementToBeClickable(twitterMenuItem));
        twitterElement.click();
    }

    public String getMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(messageElement));
        return message.getText();
    }
}