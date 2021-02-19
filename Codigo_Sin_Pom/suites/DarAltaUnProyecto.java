package suites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import funcionalidades.Datos;
import funcionalidades.Funcionalidades;

public class DarAltaUnProyecto {

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
	public void crearProyectoDatosValidos() throws InterruptedException {
		func.login(d.obtenerUsername(), d.obtenerPassword());
		func.irAProjectManager();
		func.irAFormularioCrearProyecto();
		func.completarFormularioProyectoValido(d.obtenerNombreDeProyecto());
		func.consultarDatosProyecto(d.obtenerNombreDeProyecto());
		Assert.assertEquals("ProjectManager - View project", func.obtenerTituloPantallaConsulta());
		Assert.assertEquals(d.obtenerNombreDeProyecto(), func.obtenerNombreProyectoConsulta());

		func.logout();
	}
}