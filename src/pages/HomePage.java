package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HeaderPage obtenerHeader() {
		return new HeaderPage(driver);
	}
	
	public MenuPage obtenerMenu() {
		return new MenuPage(driver);
	}

}
