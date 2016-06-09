package assign4;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CybageSearch {

	/*@Test
	public void find() throws InterruptedException, IOException {

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.cybage.com");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".top-menu-bar :nth-child(4)"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".top-menu-bar :nth-child(5)"))
				.click();

		driver.findElement(By.id("txtSearch")).sendKeys("Automation");
		driver.findElement(By.className("global-search-button")).click();
		Thread.sleep(8000);

		WebElement select = driver.findElement(By.tagName("option"));
		System.out.println(select.getText());

		driver.findElement(
				By.xpath(".//*[@class='search-results-panel']/a/span[text()='Testing and QA']"))
				.click();
	}*/

}
