package funcionalidades;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Funcionalidades {
	WebDriver driver;

	public Funcionalidades() {
		System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	public void close() {
		driver.close();
	}

	public void login(String usuario, String clave) {
		driver.get("http://egroupware.cursos.ces.com.uy/login.php");
		driver.findElement(By.name("login")).sendKeys(usuario);
		driver.findElement(By.name("passwd")).sendKeys(clave);
		driver.findElement(By.name("submitit")).click();
	}

	public void logout() {
		driver.findElement(By.linkText("Logout")).click();
		Assert.assertEquals("Username: ",
				driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(1)")).getText());
		Assert.assertEquals("Password: ",
				driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(1)")).getText());

	}

	public void irARecursos() {
		driver.get("http://egroupware.cursos.ces.com.uy/egroupware/calendar/index.php");
		driver.findElement(By.cssSelector("td:nth-child(2) td:nth-child(6) img")).click();
	}

	public void irAFormularioCrearRecurso() {
		driver.findElement(By.id("exec[add]")).click();
	}

	public void completarFormularioRecursoValido(String nombreRecurso) throws InterruptedException {
		String originalWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.findElement(By.id("exec[name]")).click();
		driver.findElement(By.id("exec[name]")).sendKeys(nombreRecurso);
		driver.findElement(By.id("exec[save]")).click();
		Thread.sleep(1000);
		driver.switchTo().window(originalWindow);
	}

	public void irAProjectManager() {
		driver.get("http://egroupware.cursos.ces.com.uy/egroupware/calendar/index.php");
		driver.findElement(By.cssSelector("td:nth-child(2) td:nth-child(5) img")).click();
	}

	public void irAFormularioCrearProyecto() {
		driver.findElement(By.id("exec[add]")).click();
	}

	public void completarFormularioProyectoValido(String nombreProyecto) {
		driver.findElement(By.id("exec[pm_title]")).click();
		driver.findElement(By.id("exec[pm_title]")).sendKeys(nombreProyecto);
		driver.findElement(By.id("exec[save]")).click();
	}

	public void consultarDatosProyecto(String nombreProyecto) {
		driver.findElement(By.cssSelector("td:nth-child(5) img")).click();
		driver.findElement(By.linkText("Projectlist")).click();
		driver.findElement(By.linkText(nombreProyecto)).click();

		driver.findElement(By.cssSelector(".th .noPrint td:nth-child(2) img")).click();
	}

	public void asignarRecursosAProyecto(String nombreRecurso, String nombreProyecto) {
		driver.findElement(By.cssSelector("td:nth-child(5) img")).click();
		driver.findElement(By.linkText("Projectlist")).click();
		driver.findElement(By.linkText(nombreProyecto)).click();
		driver.findElement(By.cssSelector(".th td:nth-child(3) img")).click();
		driver.findElement(By.id("projectmanager.edit.links-tab")).click();

		Select drp = new Select(driver.findElement(By.id("exec[link_to][app]")));
		drp.selectByVisibleText("Resources");

		driver.findElement(By.id("exec[link_to][app]")).click();
		driver.findElement(By.id("exec[link_to][start_search]")).click();

		Select drp2 = new Select(driver.findElement(By.id("exec[link_to][id]")));
		drp2.selectByVisibleText(nombreRecurso);

		driver.findElement(By.id("exec[link_to][id]")).click();
		driver.findElement(By.id("exec[link_to][create]")).click();
		driver.findElement(By.id("exec[save]")).click();
	}

	public void agregarContactosALaAgenda(String nombreContacto, String apellidoContacto, String nombreProyecto) {
		driver.findElement(By.cssSelector("td:nth-child(5) img")).click();
		driver.findElement(By.linkText("Projectlist")).click();
		driver.findElement(By.linkText(nombreProyecto)).click();
		driver.findElement(By.cssSelector(".th td:nth-child(3) img")).click();

		driver.findElement(By.id("projectmanager.edit.links-tab")).click();

		Select drp = new Select(driver.findElement(By.id("exec[link_to][app]")));
		drp.selectByVisibleText("Addressbook");

		driver.findElement(By.id("exec[link_to][app]")).click();
		driver.findElement(By.id("exec[link_to][start_search]")).click();

		Select drp2 = new Select(driver.findElement(By.id("exec[link_to][id]")));
		drp2.selectByVisibleText(apellidoContacto + ", " + nombreContacto);

		driver.findElement(By.id("exec[link_to][id]")).click();
		driver.findElement(By.id("exec[link_to][create]")).click();
		driver.findElement(By.id("exec[save]")).click();
	}

	public void irAContacto() {
		driver.get("http://egroupware.cursos.ces.com.uy/egroupware/calendar/index.php");
		driver.findElement(By.cssSelector("td:nth-child(2) td:nth-child(3) img")).click();
	}

	public void irAFormularioCrearContacto() {
		driver.findElement(By.id("exec[add]")).click(); // esto va en contacto page
	}

	public void completarFormularioContactoValido(String nombreContacto, String apellidoContacto)
			throws InterruptedException {
		String originalWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.findElement(By.id("exec[n_fn]")).click();
		driver.findElement(By.id("exec[n_given]")).click();
		driver.findElement(By.id("exec[n_given]")).sendKeys(nombreContacto);
		driver.findElement(By.id("exec[n_family]")).click();
		driver.findElement(By.id("exec[n_family]")).sendKeys(apellidoContacto);
		driver.findElement(By.cssSelector("td:nth-child(2) > #exec\\[\\]")).click();
		driver.findElement(By.id("exec[button][save]")).click();
		Thread.sleep(1000);
		driver.switchTo().window(originalWindow);
	}

	public void irABusquedaContacto(String nombreBuscar, String apellidoBuscar) {
		driver.get("http://egroupware.cursos.ces.com.uy/egroupware/index.php?menuaction=addressbook.uicontacts.index");
		driver.findElement(By.cssSelector("td:nth-child(6) > #exec\\[nm\\]\\[search\\]")).click();
		driver.findElement(By.cssSelector("td:nth-child(6) > #exec\\[nm\\]\\[search\\]")).sendKeys(nombreBuscar);
		driver.findElement(By.id("exec[nm][start_search]")).click();

	}

	public String obtenerTextoBusquedaContacto() {
		return driver.findElement(By.id("1[line1]")).getText();
	}

	public String obtenerContactoAgregado(String nombreBuscar, String apellidoBuscar) {
		return driver.findElement(By.linkText(apellidoBuscar + ", " + nombreBuscar)).getText();
	}

	public String obtenerRecursoAgregado(String nombreRecurso) {
		return driver.findElement(By.linkText(nombreRecurso)).getText();
	}

	public String obtenerTituloPantallaConsulta() {
		return driver.findElement(By.id("divAppboxHeader")).getText();
	}

	public String obtenerNombreProyectoConsulta() {
		return driver.findElement(By.cssSelector("td:nth-child(4) > b")).getText();
	}

	public String obtenerTextoBusquedaRecurso() {
		return driver.findElement(By.id("1[name]")).getText();
	}

	public void irABusquedaRecurso(String nombreRecurso) {
		driver.findElement(By.id("exec[nm][search]")).click();
		driver.findElement(By.id("exec[nm][search]")).sendKeys(nombreRecurso);
		driver.findElement(By.id("exec[nm][start_search]")).click();
	}

	public String obtenerNombreUsuario() {
		return driver.findElement(By.cssSelector("b")).getText();
	}
}
