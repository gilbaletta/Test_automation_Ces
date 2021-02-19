package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioContactoPage extends BasePage {
	private By openWindowButton = By.id(getSelector("formulario_contact_open_window_button"));
	private By contactNameField = By.id(getSelector("formulario_contact_name_field"));
	private By contactFamilyNameField = By.id(getSelector("formulario_contact_family_name_field"));
	private By okButton = By.cssSelector(getSelector("formulario_contact_ok_button"));
	private By saveButton = By.id(getSelector("formulario_contact_save_button"));

	public FormularioContactoPage(WebDriver driver) {
		super(driver);
	}

	public void llenarFormulario(String nombreContacto, String apellidoContacto) {
		irAlModalWindow();
		hacerClickEn(openWindowButton);
		hacerClickEn(contactNameField);
		escribirTextoEn(contactNameField, nombreContacto);
		hacerClickEn(contactFamilyNameField);
		escribirTextoEn(contactFamilyNameField, apellidoContacto);
		hacerClickEn(okButton);
	}

	public void guardarFormulario() {
		hacerClickEn(saveButton);
		irAlOriginalWindow();
	}

}
