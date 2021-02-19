package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectManagerPage extends BasePage {
	private By addProjectButton = By.id(getSelector("project_manager_add_project_button"));
	private By editProjectButton = By.cssSelector(getSelector("project_manager_editproject_button"));
	private By viewProjectButton = By.cssSelector(getSelector("project_manager_view_project_button"));
	private By searchInput = By.id(getSelector("project_manager_search_input"));
	private By searchButton = By.id(getSelector("project_manager_search_button"));

	public ProjectManagerPage(WebDriver driver) {
		super(driver);
	}

	public WebElement buscarProyectoPorNombre(String nombreProyecto) {
		hacerClickEn(searchInput);
		escribirTextoEn(searchInput, nombreProyecto);
		hacerClickEn(searchButton);

		return buscar(By.linkText(nombreProyecto));

	}

	public void crearProyecto(String nombreProyecto) {
		FormularioProyectoPage formulario = obtenerCrearProyectoForm();
		formulario.llenarFormulario(nombreProyecto);
		formulario.guardarFormulario();

	}

	public FormularioProyectoPage obtenerCrearProyectoForm() {
		hacerClickEn(addProjectButton);
		return new FormularioProyectoPage(driver);

	}

	public ViewProjectPage consultarProyectoPorNombre(String nombreProyecto) {
		WebElement primerProyecto = buscarProyectoPorNombre(nombreProyecto);
		primerProyecto.click();
		hacerClickEn(viewProjectButton);
		return new ViewProjectPage(driver);

	}

	public EditarProjectPage editarProyectoPorNombre(String nombreProyecto) {
		WebElement primerProyecto = buscarProyectoPorNombre(nombreProyecto);
		primerProyecto.click();
		hacerClickEn(editProjectButton);
		return new EditarProjectPage(driver);

	}

}
