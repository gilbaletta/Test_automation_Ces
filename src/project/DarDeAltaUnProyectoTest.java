package project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import datos.Datos;
import pages.HomePage;
import pages.LoginPage;
import pages.ProjectManagerPage;
import suites.BaseTest;

public class DarDeAltaUnProyectoTest extends BaseTest {
	WebDriver driver;
	Datos d;
	private String url = "http://egroupware.cursos.ces.com.uy/login.php";

	@Before
	public void startSelenium() {
		d = new Datos();
		driver = obtenerDriver(d.obtenerNavegador());
	}

	@Test
	public void entrarSalir() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.abrir(url);
		HomePage homePage = loginPage.hacerLogin(d.obtenerUsername(), d.obtenerPassword());

		ProjectManagerPage projectManagerPage = homePage.obtenerMenu().hacerClicEnProjectManagerMenu();
		projectManagerPage.crearProyecto(d.obtenerNombreDeProyecto());

		homePage.obtenerMenu().hacerClicEnProjectManagerMenu();
		WebElement resultado = projectManagerPage.buscarProyectoPorNombre(d.obtenerNombreDeProyecto());

		Assert.assertEquals(resultado.isDisplayed(), true);

		loginPage.cerrar();
	}

}
