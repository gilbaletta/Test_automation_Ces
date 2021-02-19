package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioProyectoPage extends BasePage {
	private By projectNameField = By.id(getSelector("formulario_proyecto_project_nameField"));
	private By saveButton = By.id(getSelector("formulario_proyecto_save_button"));

	public FormularioProyectoPage(WebDriver driver) {
		super(driver);
	}
	
	public void llenarFormulario(String nombreProyecto) {
		escribirTextoEn(projectNameField, nombreProyecto);
		
	}
	public void guardarFormulario() {
		 hacerClickEn(saveButton);
		
	}
	

	
	
}   


