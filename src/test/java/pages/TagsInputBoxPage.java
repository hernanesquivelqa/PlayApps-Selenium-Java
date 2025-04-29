package pages;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TagsInputBoxPage {
    private WebDriver driver;
    private By tags = By.cssSelector(".content ul li");
    private By inputField = By.cssSelector(".content ul input"); 
    private String url = "https://qaplayground.dev/apps/tags-input-box/";

    public TagsInputBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllTags() {
        return driver.findElements(tags);
    }

    public List<String> getAllTagsText() {
        List<WebElement> tagElements = driver.findElements(tags);
        return tagElements.stream()
                .map(element -> element.getText().replaceAll("(?i)remove.*$", "").trim())
                .collect(Collectors.toList());
    }

    
    public void addNewTag(String tag) {
        WebElement input = driver.findElement(inputField);
        input.sendKeys(tag); 
        input.sendKeys(Keys.ENTER); 
    }

    public String getUrl() {
        return this.url;
    }
}