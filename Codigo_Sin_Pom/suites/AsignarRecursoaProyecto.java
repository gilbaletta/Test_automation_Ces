package suites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import funcionalidades.Datos;
import funcionalidades.Funcionalidades;

public class AsignarRecursoaProyecto {

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
	public void agregarRecursosAProyecto() throws InterruptedException {
		func.login(d.obtenerUsername(), d.obtenerPassword());
		func.irAProjectManager();
		func.asignarRecursosAProyecto(d.obtenerNombreDeRecurso(), d.obtenerNombreDeProyecto());
		String texto = func.obtenerRecursoAgregado(d.obtenerNombreDeRecurso());
		Assert.assertEquals(d.obtenerNombreDeRecurso(), texto);


		func.logout();
	}
}