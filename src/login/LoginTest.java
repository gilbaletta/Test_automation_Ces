package login;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import datos.Datos;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import suites.BaseTest;

public class LoginTest extends BaseTest {
	private WebDriver driver;
	private Datos d;
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

		HeaderPage headerPage = homePage.obtenerHeader();
		String username = "[" + d.obtenerUsername() + "] " + d.obtenerUsername() + " User";

		Assert.assertEquals(username, headerPage.obtenerTextoUsername());

//		Thread.sleep(3000);
		homePage.obtenerMenu().hacerLogout();
		loginPage.cerrar();

	}

}
