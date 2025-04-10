package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QRCodeGeneratorPage {
    private WebDriver driver;
    private String url = "https://qaplayground.dev/apps/qr-code-generator/";
    private String TitlePage = "Test QR Code Generator";

    @FindBy(css = "input[type='text']")
    private WebElement inputTextOrUrlField;

    @FindBy(css = ".form button")
    private WebElement generateQRCodeButton;
    @FindBy(css = ".qr-code img")
    private WebElement qrCodeImage;

    public QRCodeGeneratorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String data) {
        inputTextOrUrlField.sendKeys(data);
        generateQRCodeButton.click();
    }

    public void enterText(String data) {
        inputTextOrUrlField.sendKeys(data);
    }

    public void clickGenerateQR() {
        generateQRCodeButton.click();
    }

	public String getUrl() {
		return url;
	}

	public String getTitlePage() {
		return TitlePage;
	}
	public String extractDataFromQrImage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement qrImageElement = wait.until(ExpectedConditions.visibilityOf(qrCodeImage));
        String qrImageUrl = qrImageElement.getAttribute("src");
        String actualQrData = qrImageUrl.split("data=")[1];
        return actualQrData;
		
		
	}



}