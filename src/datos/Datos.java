package datos;

import java.io.FileReader;
import java.util.Properties;

public class Datos {
	Properties properties;

	public Datos() {
		FileReader reader;
		try {
			reader = new FileReader("datos.properties");

			properties = new Properties();
			properties.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String obtenerNavegador() {
		return properties.getProperty("browser");
	}

	public String obtenerPassword() {
		return properties.getProperty("password");
	}

	public String obtenerUsername() {
		return properties.getProperty("username");
	}

	public String obtenerNombreDeRecurso() {
		return properties.getProperty("nombre_recurso");
	}

	public String obtenerNombreDeProyecto() {
		return properties.getProperty("nombre_proyecto");
	}

	public String obtenerNombreDeContacto() {
		return properties.getProperty("nombre_contacto");
	}

	public String obtenerApellidoDeContacto() {
		return properties.getProperty("apellido_contacto");
	}

}
