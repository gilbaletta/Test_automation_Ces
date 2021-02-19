package suites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import funcionalidades.Datos;
import funcionalidades.Funcionalidades;

public class CrearContacto {

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
	public void crearContactoDatosValidos() throws InterruptedException {
		func.login(d.obtenerUsername(), d.obtenerPassword());
		func.irAContacto();
		func.irAFormularioCrearContacto();
		func.completarFormularioContactoValido(d.obtenerNombreDeContacto(), d.obtenerApellidoDeContacto());
		func.irABusquedaContacto(d.obtenerNombreDeContacto(), d.obtenerApellidoDeContacto());
		String texto = func.obtenerTextoBusquedaContacto();

		Assert.assertEquals(d.obtenerApellidoDeContacto() + ", " + d.obtenerNombreDeContacto(), texto);

		func.logout();
	}
}