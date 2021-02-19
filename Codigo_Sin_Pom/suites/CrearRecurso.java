package suites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import funcionalidades.Datos;
import funcionalidades.Funcionalidades;

public class CrearRecurso {

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
	public void crearRecursoDatosValidos() throws InterruptedException {
		func.login(d.obtenerUsername(), d.obtenerPassword());
		func.irARecursos();
		func.irAFormularioCrearRecurso();
		func.completarFormularioRecursoValido(d.obtenerNombreDeRecurso());
		func.irABusquedaRecurso(d.obtenerNombreDeRecurso());
		String texto = func.obtenerTextoBusquedaRecurso();

		Assert.assertEquals(d.obtenerNombreDeRecurso(), texto);


		func.logout();
	}
}