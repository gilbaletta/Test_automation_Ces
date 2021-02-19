package contact;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import datos.Datos;
import pages.ContactosPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import suites.BaseTest;

public class DarDeAltaUnContactoTest extends BaseTest {
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
		ContactosPage contactsPage = menuPage.hacerClicEnContactsMenu();
		contactsPage.crearContacto(d.obtenerNombreDeContacto(), d.obtenerApellidoDeContacto());

		menuPage.hacerClicEnContactsMenu();
		WebElement resultado = contactsPage.buscarContactoPorNombre(d.obtenerNombreDeContacto());

		Assert.assertEquals(resultado.isDisplayed(), true);

		String nombreCompleto = d.obtenerApellidoDeContacto() + ", " + d.obtenerNombreDeContacto();
		Assert.assertEquals(resultado.getText(), nombreCompleto);

		loginPage.cerrar();
	}// TODO crear un affter para el logaut y un before para el logaout

}
