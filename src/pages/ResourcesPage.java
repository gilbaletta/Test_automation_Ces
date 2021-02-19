package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResourcesPage extends BasePage {
	private By addResouceButton = By.id(getSelector("resources_add_resouce_button"));
	private By resultadoBusqueda = By.id(getSelector("resources_resultado_busqueda"));
	private By searchField = By.id(getSelector("resources_search_field"));
	private By searchButton = By.id(getSelector("resources_search_button"));

	public ResourcesPage(WebDriver driver) {
		super(driver);
	}

	public WebElement obtenerRecursoPorNombre(String nombreRecurso) {
		hacerClickEn(searchField);
		escribirTextoEn(searchField, nombreRecurso);
		hacerClickEn(searchButton);
		
		return buscar(resultadoBusqueda);

	}

	public FormularioRecursoPage obtenerCrearRecursoForm() {
		hacerClickEn(addResouceButton);
		return new FormularioRecursoPage(driver);

	}

	public void crearRecurso(String nombreRecurso) {
		FormularioRecursoPage formulario = obtenerCrearRecursoForm();
		formulario.llenarFormulario(nombreRecurso);
		formulario.guardarFormulario();

	}

}
