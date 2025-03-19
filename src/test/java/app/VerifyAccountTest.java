package app;
import base.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.VerifyAccountPage;

public class VerifyAccountTest extends TestBase {
    private VerifyAccountPage verifyAccountPage;

    @BeforeEach
    public void setupUpPage() {
        verifyAccountPage = new VerifyAccountPage(driver); 
    	goToUrl(verifyAccountPage.getUrl());
    }

    @Test
    public void verifySuccessMessageAfterEnteringCode() {
        verifyAccountPage.fillInputs("9");
        assertEquals(verifyAccountPage.getSuccessText(), "Success");
    }
}
