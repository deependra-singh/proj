
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverMethods_updated2 {

	WebDriver driver;
	String browserName, URL; //These are used in the Property File example.
	
	/**
	* Remote web driver example needs below Selenium Server
	* To Start Selenium Server:
	* Go to selenium-server-standalone-2.52.0.jar directory on cmd,
	* Java –jar selenium-server-standalone-2.50.0.jar -Dwebdriver.chrome.driver = " D:\Automation\Selenium Training\May-14\SetupFiles\chromedriver.exe”
	* java -jar selenium-server-standalone-2.50.0.jar -Dwebdriver.ie.driver="D:\Jars\IEDriverServer.exe"
	* java -jar selenium-server-standalone-2.52.0.jar
	*/
	
	/**
	 * This test is to demonstrate how Firefox browser can be launched remotely. 
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	/*@Test
	public void remoteWebDriverFireFox() throws InterruptedException, MalformedURLException{
		DesiredCapabilities cp= DesiredCapabilities.firefox(); //Set browser properties to be used by WebDriver
		URL url = new URL( "http","localhost",4444,"/wd/hub" ); //Set the URL of the remote Hub/Selenium Server
		cp.setJavascriptEnabled(true);
		WebDriver driver = new RemoteWebDriver(url,cp); //Instantiate driver with above defined parameters
		driver.get("http://www.google.com"); // Open the Google page
	}
	*/
	
	/**
	 * This test is to demonstrate how IE browser can be launched remotely. 
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	
	/*@Test
	public void remoteWebDriverIE() throws InterruptedException, MalformedURLException{
		DesiredCapabilities cp= DesiredCapabilities.internetExplorer();
		URL url = new URL( "http","localhost",4444,"/wd/hub" );
		cp.setJavascriptEnabled(true);
		cp.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); //Capability that defines to ignore browser protected mode settings during starting by IEDriverServer.
		WebDriver driver = new RemoteWebDriver(url,cp);
		driver.get("http://www.google.com");
	}*/
	
	/**
	 * This test is to demonstrate how Firefox browser can be launched. 
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	@Test
	public void standAloneWebDriverFF() throws InterruptedException, MalformedURLException{
		driver = new FirefoxDriver();
		driver.get("http://www.google.com/");
	}
	
	
	/**
	 * This test is to demonstrate how Chrome browser can be launched. 
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	@Test
	public void standAloneWebDriverChrome() throws InterruptedException, MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "Jars\\Jars\\chromedriver.exe"); //Path of chrome executable.
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
	
	
		
	/**
	 * This test is to demonstrate how HTML Unit Driver can be launched. 
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	/*@Test
	public void standAloneHtmlUnitDriver() throws InterruptedException, MalformedURLException{
		driver = new HtmlUnitDriver(); 
		driver.get("http://www.google.com/");				
		
	}*/
	
	
	/**
	 * This test is to demonstrate how Title of a page can be validated. 
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	/*@Test
	public void verifyPageTitle() throws InterruptedException, MalformedURLException{
		driver = new FirefoxDriver();
		driver.get("http://www.google.com/");
		String title = driver.getTitle();
		System.out.println("------------Page Title is Displayed-----------> "+title);
		Assert.assertEquals(driver.getTitle(), "Google");		
	}*/
	
	
	/**
	 * This test is to demonstrate how to use WebElement and various functions of it. 
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	/*@Test
	public void usingWebElement() throws InterruptedException, MalformedURLException{
		driver = new FirefoxDriver();
		driver.get("http://www.ehow.com/");				
		WebElement element = null;
		element = driver.findElement(By.xpath(".//*[@id='Header']/section/div/div[2]/div/a[1]"));//Login Link
		element.click();
		element = driver.findElement(By.xpath(".//*[@class='sbar_close']"));
		element.click();
		element = driver.findElement(By.xpath("//*[@id='searchHeader']/input[1]"));//search text box
		element.sendKeys("Hotel");
		Thread.sleep(5000);
		element.clear();
		System.out.println(element.getSize());
		
		driver = new FirefoxDriver();
		driver.get("http://www.ehow.com/");				
		WebElement element = null;
		driver.manage().window().maximize();
		element = driver.findElement(By.xpath(".//*[@id='Header']/section/div/div[2]/div/a[1]"));//Login Link
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id='searchHeader']/input[1]"));//search text box.
		element.sendKeys("Hotel");
		element.clear();
		System.out.println("Print Element Size: "+element.getSize());
	}*/
	
	
	/**
	 * This test is to demonstrate how to select drop down item using ByValue, ByVisibleText, ByIndex. 
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	/*@Test
	public void selectDropDownOptions() throws InterruptedException, MalformedURLException{
		driver = new FirefoxDriver();
		driver.get("http://demo.nopcommerce.com/"); 
		driver.findElement(By.xpath(".//*[@id='small-searchterms']")).sendKeys("And");
		driver.findElement(By.xpath(".//*[@id='small-search-box-form']/input[2]")).click();
		
		
		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='products-orderby']")));
		//dropdown.selectByValue("http://demo.nopcommerce.com/search?q=and&orderby=10"); //Use any of the three.
		dropdown.selectByVisibleText("Price: Low to High");
		//dropdown.selectByIndex(3);
		
		String strFirstProduct = driver.findElement(By.xpath("html/body/div[5]/div[3]/div/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div[2]/h2/a")).getText();
		System.out.println(strFirstProduct);
		Assert.assertEquals(driver.findElement(By.xpath("html/body/div[5]/div[3]/div/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div[2]/h2/a")).getText(), "Pride and Prejudice");
	}*/
	
	
		
	/**
	 * This is a function to read Browser and URL from Property File and set the values.
	 * @param strpropfilename - Pass the Property File name along with path of the file
	 */
/*	public void readConfigFile(String strPropFileName)
	{
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(strPropFileName);
			prop.load(input);// load a properties file

			browserName=prop.getProperty("browser");
			System.out.println("Browser is: "+browserName);
			URL=prop.getProperty("url");
			System.out.println("URL is: "+URL);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}*/
	

}
