package searchFunctionality;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.apache.http.client.utils.Punycode;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessMakeMyTrip {

	@Test
	public void findHotels() throws InterruptedException {
		//setting system properties for to use chrome driver
		System.setProperty("webdriver.chrome.driver", "D:/Software/SeleniumServer/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//opening the makemytrip site
		driver.get("http://www.makemytrip.com/");

		Thread.sleep(4000);
		//maximizing the window of browser
		driver.manage().window().maximize();
		
		// to click hotel tab
		driver.findElement(By.xpath(".//*[@id='widget_row']/div[1]/div[1]/div[2]/ul/li[3]/a")).click();
		// sending pune in search field
		driver.findElement(By.xpath(".//*[@id='from_city_data_box']")).sendKeys("pune");
		Thread.sleep(3000);// to wait for suggestions of cities after city is
							// entered
		// to click dropdown arrow for no of nights
		driver.findElement(By.xpath(".//*[@id='nightAnchor']/div/p[2]/span[2]")).click();
		// to select 2 as no of nights
		driver.findElement(By.xpath(".//*[@id='nightAnchor']/div/div/ul/li[2]/a"));

		Thread.sleep(1000);
		//for selecting no of adult count as 2
		driver.findElement(By.xpath(".//*[@id='roomDiv_1']/div/div/div[2]/div/div/a[2]")).click();

		Thread.sleep(1000);

		// clicking the submit after entering values
		driver.findElement(By.xpath(".//*[@id='hotels_submit']")).click();

		// wait for loading the new page after submitting
		Thread.sleep(5000);
		// checking the search list has first entry with following hotel name
		// and asserting accordingly
		assertEquals("St Laurn Business Hotel",
				driver.findElement(By.partialLinkText("St Laurn Business Hotel")).getText());

	}
}
