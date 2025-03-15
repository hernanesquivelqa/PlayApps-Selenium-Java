package app;
import base.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.VerifyAccountPage;

public class VerifyAccount extends TestBase {
    private VerifyAccountPage verifyAccountPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver(); 
        verifyAccountPage = new VerifyAccountPage(driver); 
    }

    @Test
    public void testVerifyAccountPage() throws InterruptedException {
        verifyAccountPage.gotoUrl(); 
        verifyAccountPage.fillInputs("9");
        assertEquals(verifyAccountPage.getSuccessText(), "Success");
    }
}