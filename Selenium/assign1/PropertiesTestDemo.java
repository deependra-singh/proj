package assign1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesTestDemo {

	/*@Test
	public void test() throws InterruptedException {
		
		Properties properties = new Properties();
		WebDriver driver = null;
		
		try
		{
			File file = new File("selenium.properties");
			FileInputStream fileInput = new FileInputStream(file);
			properties.load(fileInput);
			fileInput.close();
		}
		
		catch(Exception e){
			
		}
		
		String browser = properties.getProperty("browser");
		switch (browser) {
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		
		driver.get("http://" + properties.getProperty("url"));
		driver.findElement(By.cssSelector(".dropdown-toggle[href='#']")).click();
		driver.findElement(By.cssSelector(".quick-link[href='/career']")).click();

		assertEquals("Careers",driver.getTitle());
		driver.manage().window().maximize();
	}*/

}
