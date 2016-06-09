package searchFunctionality;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.utils.Punycode;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ProcessMakeMyTripCSS {

	@Test
	public void findHotels() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:/Software/SeleniumServer/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// opening the makemytrip site
		driver.get("http://www.makemytrip.com/");

		Thread.sleep(2000);
		// maximizing the window of browser
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// to click hotel tab
		driver.findElement(By.cssSelector(".tabs_list.clearfix :nth-child(3) a ")).click();
		Thread.sleep(4000);
		// sending pune in search field
		driver.findElement(By.cssSelector("#from_city_data_box")).sendKeys("pune");
		Thread.sleep(4000);// to wait for suggestions of cities after city is
							// entered
		// to click dropdown arrow for no of nights
		driver.findElement(By.cssSelector(".arrow_ddn_pointer")).click(); 
		// to select 8 as no of nights
		driver.findElement(By.cssSelector(".nights-dropdown-menu :nth-child(8) a")).click();
		
		Thread.sleep(1000);
		//select adult count as 2.
		List< WebElement> elements=driver.findElements(By.cssSelector(".segmented_controls.make_field.form-control>a[tabindex='5']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", elements.get(0));
		//driver.findElement(By.cssSelector(".segmented_controls.make_field.form-control>a[onclick="incrementer('adultCount_1',6)"]")).click();
		
		Thread.sleep(1000);

		// clicking the submit after entering values
		driver.findElement(By.cssSelector("#hotels_submit")).click();

		// wait for loading the new page after submitting
		Thread.sleep(5000);
		// checking the search list has first entry with following hotel name
		// and asserting accordingly
		assertEquals("St Laurn Business Hotel",
				driver.findElement(By.partialLinkText("St Laurn Business Hotel")).getText());

	}
}
