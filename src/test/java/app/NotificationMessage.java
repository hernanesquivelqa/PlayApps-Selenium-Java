package app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import base.TestBase;

public class NotificationMessage extends TestBase {
    @Test
    public void displayNotificationMessage() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.cssSelector("a[href='/notification_message']")).click();

        String texto = driver.findElement(By.id("flash")).getText().trim();
        texto = texto.replace("×", "").trim(); // Eliminamos la "X" del mensaje y espacios extra

        System.out.println("Texto recibido: " + texto);

        assertTrue(
            texto.contains("Action successful") ||
            texto.contains("Action unsuccesful") || // ortografía tal como aparece en el sitio
            texto.contains("please try again"),
            "El mensaje no es el esperado: " + texto
        );
    }
}