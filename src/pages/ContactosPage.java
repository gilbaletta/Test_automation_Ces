package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactosPage extends BasePage {
	private By addContactButton = By.id(getSelector("add_contact_button"));
	private By resultadoBusqueda = By.id(getSelector("resultado_busqueda"));
	private By searchField = By.cssSelector(getSelector("contacto_search_field"));
	private By searchButton = By.id(getSelector("search_button"));

	public ContactosPage(WebDriver driver) {
		super(driver);
	}

	public WebElement buscarContactoPorNombre(String nombreContacto) {
		hacerClickEn(searchField);
		escribirTextoEn(searchField, nombreContacto);
		hacerClickEn(searchButton);

		return buscar(resultadoBusqueda);

	}

	public FormularioContactoPage obtenerCrearContactoForm() {
		hacerClickEn(addContactButton);
		return new FormularioContactoPage(driver);

	}
	
	public void crearContacto(String nombreContacto, String apellidoContacto) {
		FormularioContactoPage formulario = obtenerCrearContactoForm();
		formulario.llenarFormulario(nombreContacto, apellidoContacto);
		formulario.guardarFormulario();
	}
}
