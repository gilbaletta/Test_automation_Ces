package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {
	private By projectManagerLink = By.cssSelector(getSelector("menu_project_manager_link"));
	private By resourcesLink = By.cssSelector(getSelector("menu_project_resources_link"));
	private By contactsLink = By.cssSelector(getSelector("menu_project_contacts_link"));
	private By usernameLogout= By.cssSelector(getSelector("menu_project_username_logout"));
	private By passwordLogout= By.cssSelector(getSelector("menu_project_password_logout"));
	private By logoutLink= By.linkText(getSelector("menu_project_logout_link"));

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public ProjectManagerPage hacerClicEnProjectManagerMenu() {
		hacerClickEn(projectManagerLink);
		return new ProjectManagerPage(driver);
	}

	public ResourcesPage hacerClicEnResourcesMenu() {
		hacerClickEn(resourcesLink);
		return new ResourcesPage(driver);
	}
	
	public ContactosPage hacerClicEnContactsMenu() {
		hacerClickEn(contactsLink);
		return new ContactosPage(driver);
	}

	public void hacerLogout() {
		hacerClickEn(logoutLink);
		Assert.assertEquals("Username: ",
				obtenerTextoDe(usernameLogout));
		Assert.assertEquals("Password: ",
				obtenerTextoDe(passwordLogout));

	}

}
