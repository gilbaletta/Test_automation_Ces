package resources;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import datos.Datos;
import pages.EditarProjectPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProjectManagerPage;
import pages.ResourcesPage;
import suites.BaseTest;

public class AsignarRecursoProyectoTest extends BaseTest {
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

		ProjectManagerPage projectManagerPage = menuPage.hacerClicEnProjectManagerMenu();
		projectManagerPage.crearProyecto(d.obtenerNombreDeProyecto());

		EditarProjectPage editProjectPage = projectManagerPage.editarProyectoPorNombre(d.obtenerNombreDeProyecto());
		editProjectPage.asignarRecursoProyecto(d.obtenerNombreDeRecurso(), d.obtenerNombreDeProyecto());

//		Thread.sleep(5000);

		String recursoAgregado = editProjectPage.obtenerRecursoAsignado(d.obtenerNombreDeRecurso()).getText();
		Assert.assertEquals(d.obtenerNombreDeRecurso(), recursoAgregado);

		loginPage.cerrar();
	}

}
