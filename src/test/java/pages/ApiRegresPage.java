package pages;

import org.openqa.selenium.WebDriver;

public class ApiRegresPage {
	private WebDriver driver;
	private final String BASE_URL = "https://reqres.in/api";

	
	public ApiRegresPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUrl() {
	 return this.BASE_URL;
	}

}
