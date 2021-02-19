package pages;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	WebDriver driver;
	private String originalWindow;
	private Properties selectores;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		FileReader reader;
		try {
			reader = new FileReader("selectores.properties");

			selectores = new Properties();
			selectores.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getSelector(String key) {
		return selectores.getProperty(key);
	}
	
	public void abrir(String url) {
		driver.get(url);
	}

	public WebElement buscar(By locator) {
		return driver.findElement(locator);
	}

	public void escribirTextoEn(By locator, String texto) {
		buscar(locator).sendKeys(texto);
	}

	public void hacerClickEn(By locator) {
		buscar(locator).click();
	}
	
	public String obtenerTextoDe(By locator) {
		return buscar(locator).getText();
	}

	public void cerrar() {
		driver.close();
	}
	
	public void irAlModalWindow() {
		originalWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}
	
	public void irAlOriginalWindow() {
		driver.switchTo().window(originalWindow);
	}
}
