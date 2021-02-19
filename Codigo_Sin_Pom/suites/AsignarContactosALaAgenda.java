package suites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import funcionalidades.Datos;
import funcionalidades.Funcionalidades;
import org.junit.Assert;

public class AsignarContactosALaAgenda {

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
	public void agregarContactoALaAgenda() throws InterruptedException {
		func.login(d.obtenerUsername(), d.obtenerPassword());
		func.irAProjectManager();
		func.agregarContactosALaAgenda(d.obtenerNombreDeContacto(), d.obtenerApellidoDeContacto(), d.obtenerNombreDeProyecto());
		Thread.sleep(1000);
		String texto = func.obtenerContactoAgregado(d.obtenerNombreDeContacto(), d.obtenerApellidoDeContacto());
		Assert.assertEquals(d.obtenerApellidoDeContacto() + ", " + d.obtenerNombreDeContacto(), texto);

		func.logout();
	}
}