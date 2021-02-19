package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditarProjectPage extends BasePage {
	private By linksTab = By.id(getSelector("edit_proyecto_linkstab"));
	private By linksSelect = By.id(getSelector("edit_proyecto_links_select"));
	private By searchButton = By.id(getSelector("edit_proyecto_search_button"));
	private By kindSelect = By.id(getSelector("edit_proyecto_kind_select"));
	private By linkButton = By.id(getSelector("edit_proyecto_link_button"));
	private By saveButton = By.id(getSelector("edit_proyecto_save_button"));

	public EditarProjectPage(WebDriver driver) {
		super(driver);
	}

	public void asignarRecursoProyecto(String nombreRecurso, String nombreProyecto) {
		hacerClickEn(linksTab);
		Select drp = new Select(buscar(linksSelect));
		drp.selectByVisibleText("Resources");
		
		hacerClickEn(linksSelect);
		hacerClickEn(searchButton);

		Select drp2 = new Select(buscar(kindSelect));
		drp2.selectByVisibleText(nombreRecurso);

		hacerClickEn(kindSelect);
		hacerClickEn(linkButton);
		hacerClickEn(saveButton);

	}
	
	public WebElement obtenerRecursoAsignado(String nombreRecurso) {
		return driver.findElement(By.linkText(nombreRecurso));
	}

	public void asignarContactoProyecto(String nombreContacto, String apellidoContacto, String nombreProyecto) {
		hacerClickEn(linksTab);

		Select drp = new Select(buscar(linksSelect));
		drp.selectByVisibleText("Addressbook");

		hacerClickEn(linksSelect);
		hacerClickEn(searchButton);

		Select drp2 = new Select(buscar(kindSelect));
		drp2.selectByVisibleText(apellidoContacto + ", " + nombreContacto);

		hacerClickEn(kindSelect);
		hacerClickEn(linkButton);
		hacerClickEn(saveButton);
	}
	
	public WebElement obtenerContactoAsignado(String nombreContacto, String apellidoContacto) {
		return driver.findElement(By.linkText(apellidoContacto + ", " + nombreContacto));
	}

}
