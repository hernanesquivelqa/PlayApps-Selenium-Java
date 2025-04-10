package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import base.TestBase;
import pages.QRCodeGeneratorPage;

public class QRCodeGeneratorTest extends TestBase {
    private QRCodeGeneratorPage page;

    @BeforeEach
    public void setupPage() {
        page = new QRCodeGeneratorPage(driver);
        goToUrl(page.getUrl());
        assertEquals(page.getTitlePage(), driver.getTitle());
    }

    @Test
    public void testGeneratedQRCodeMatchesInput() {
        String expectedQrData = "https://qaplayground.dev/";
        page.fillForm(expectedQrData);
        String actualQrData = page.extractDataFromQrImage();
        assertEquals(expectedQrData, actualQrData, "QR data does not match input");
    }
}
