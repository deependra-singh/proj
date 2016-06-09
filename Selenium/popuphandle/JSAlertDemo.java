package popuphandle;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class JSAlertDemo {

	/*@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium Java & Web Drivers/SeleniumServer/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.javascriptkit.com/javatutors/alert2.shtml");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='contentcolumn']/form/p/input")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("input[name|='B3']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("input[name|='B3']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("input[name|='B4']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().sendKeys("Hello");
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void cybageMISTest() throws IOException, InterruptedException{
						
		System.setProperty("webdriver.ie.driver",
				"C:/Selenium Java & Web Drivers/SeleniumServer/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://cybagemis.cybage.com");
		
		Thread.sleep(2000);
		
		String[] param = new String[] {"script\\authentication.exe", "Authentication Required", "deependras", "Ds8802631632!@#"};
		Runtime.getRuntime().exec(param);
	}*/

}
