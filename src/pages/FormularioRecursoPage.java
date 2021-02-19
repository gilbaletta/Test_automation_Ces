package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioRecursoPage extends BasePage {
	private By resourceNameField = By.id(getSelector("formulario_recurso_resource_name_field"));
	private By saveButton = By.id(getSelector("formulario_recurso_save_button"));

	public FormularioRecursoPage(WebDriver driver) {
		super(driver);
	}

	public void llenarFormulario(String nombreRecurso) {
		irAlModalWindow();
		hacerClickEn(resourceNameField);
		escribirTextoEn(resourceNameField, nombreRecurso);
	}

	public void guardarFormulario() {
		hacerClickEn(saveButton);
		irAlOriginalWindow();
	}

}
