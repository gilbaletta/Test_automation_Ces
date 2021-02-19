package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	private By usernameField = By.name(getSelector("login_username_field"));
	private By passwordField = By.name(getSelector("login_password_field"));
	private By loginButton = By.name(getSelector("login_submit_button"));

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage hacerLogin(String username, String password) {
		escribirTextoEn(usernameField, username);
		escribirTextoEn(passwordField, password);
		hacerClickEn(loginButton);
		return new HomePage(driver);
	}
}
