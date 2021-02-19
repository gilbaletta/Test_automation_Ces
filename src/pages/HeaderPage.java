package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
	private By usernameText = By.cssSelector(getSelector("header_username_text"));

	public HeaderPage(WebDriver driver) {
		super(driver);
	}

	public String obtenerTextoUsername() {
		return buscar(usernameText).getText();
	}
}


