package suites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import funcionalidades.Datos;
import funcionalidades.Funcionalidades;

public class Login {

	Funcionalidades func;
	Datos d;

	@Before
	public void startSelenium() {
		func = new Funcionalidades();
		d = new Datos();

	}

	@After
	public void stopSelenium() {
		func.close();
	}

	@Test
	public void entrarSalir() throws InterruptedException {
		func.login(d.obtenerUsername(), d.obtenerPassword());
		String texto = func.obtenerNombreUsuario();
		Assert.assertEquals("[" + d.obtenerUsername() + "] " + d.obtenerUsername() + " User", texto);

		func.logout();
	}
}