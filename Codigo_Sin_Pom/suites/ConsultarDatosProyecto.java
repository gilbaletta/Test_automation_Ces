package suites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import funcionalidades.Datos;
import funcionalidades.Funcionalidades;

public class ConsultarDatosProyecto {

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
	public void consultarDatosProyecto() throws InterruptedException {
		func.login(d.obtenerUsername(), d.obtenerPassword());
		func.irAProjectManager();
		func.consultarDatosProyecto(d.obtenerNombreDeProyecto());
		Assert.assertEquals("ProjectManager - View project", func.obtenerTituloPantallaConsulta());
		Assert.assertEquals(d.obtenerNombreDeProyecto(), func.obtenerNombreProyectoConsulta());

		func.logout();
	}
}