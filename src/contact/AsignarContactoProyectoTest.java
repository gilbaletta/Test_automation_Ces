package contact;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import datos.Datos;
import pages.ContactosPage;
import pages.EditarProjectPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProjectManagerPage;
import suites.BaseTest;

public class AsignarContactoProyectoTest extends BaseTest {
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
		ContactosPage contactosPage = menuPage.hacerClicEnContactsMenu();
		contactosPage.crearContacto(d.obtenerNombreDeContacto(), d.obtenerApellidoDeContacto());

		ProjectManagerPage projectManagerPage = menuPage.hacerClicEnProjectManagerMenu();
		projectManagerPage.crearProyecto(d.obtenerNombreDeProyecto());

		EditarProjectPage editProjectPage = projectManagerPage.editarProyectoPorNombre(d.obtenerNombreDeProyecto());
		editProjectPage.asignarContactoProyecto(d.obtenerNombreDeContacto(), d.obtenerApellidoDeContacto(),
				d.obtenerNombreDeProyecto());

//		Thread.sleep(5000);

		String contactoAgregado = editProjectPage
				.obtenerContactoAsignado(d.obtenerNombreDeContacto(), d.obtenerApellidoDeContacto()).getText();
		String nombreCompleto = d.obtenerApellidoDeContacto() + ", " + d.obtenerNombreDeContacto();
		Assert.assertEquals(nombreCompleto, contactoAgregado);

		loginPage.cerrar();
	}

}
