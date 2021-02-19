package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ViewProjectPage extends BasePage {
	private By pageTitle = By.id("divAppboxHeader");
	private By projectTitle = By.cssSelector("td:nth-child(4) > b"); 
	
	public ViewProjectPage (WebDriver driver) {
		super(driver);
	}
	public String obtenerTituloPantallaConsulta() {
		return obtenerTextoDe(pageTitle);
	}

	public String obtenerNombreProyectoConsulta() {
		return obtenerTextoDe(projectTitle);
	}

	
	

} 
