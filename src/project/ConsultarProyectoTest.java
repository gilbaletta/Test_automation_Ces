package project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import datos.Datos;
import pages.HomePage;
import pages.LoginPage;
import pages.ProjectManagerPage;
import pages.ViewProjectPage;
import suites.BaseTest;

public class ConsultarProyectoTest extends BaseTest {
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

		ViewProjectPage viewProjectPage = projectManagerPage.consultarProyectoPorNombre(d.obtenerNombreDeProyecto());

//        Thread.sleep(5000);
		Assert.assertEquals("ProjectManager - View project", viewProjectPage.obtenerTituloPantallaConsulta());
		Assert.assertEquals(d.obtenerNombreDeProyecto(), viewProjectPage.obtenerNombreProyectoConsulta());

		loginPage.cerrar();
	}

}
