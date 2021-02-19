package suites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	
	public WebDriver obtenerDriver(String navegador) {
		WebDriver driver = null;		

		if (navegador.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (navegador.equalsIgnoreCase("ie")) {
			// No se pudo
			System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		return driver;
	}
}
