package resources;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import datos.Datos;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ResourcesPage;
import suites.BaseTest;

public class DarDeAltaUnRecursoTest extends BaseTest {
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

		MenuPage menuPage = homePage.obtenerMenu();
		ResourcesPage resourcesPage = menuPage.hacerClicEnResourcesMenu();
		resourcesPage.crearRecurso(d.obtenerNombreDeRecurso());

		menuPage.hacerClicEnResourcesMenu();
		WebElement recursoCreado = resourcesPage.obtenerRecursoPorNombre(d.obtenerNombreDeRecurso());

		Assert.assertEquals(recursoCreado.isDisplayed(), true);
//		Thread.sleep(1000);

		loginPage.cerrar();
	}

}
