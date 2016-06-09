import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class locators_updated2 {
	
	WebDriver driver;
	
	/**
	 * This example shows how to use locator by elements ID and Name.
	 * @throws InterruptedException
	 */
	/*@SuppressWarnings("unused")
	@Test
	public void locatorByIdName() throws InterruptedException{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.id("gb_70")).click(); // Click on "Sign in" Button 
		driver.findElement(By.name("Email")).sendKeys("admin1"); //Enter text in "Email"
		driver.findElement(By.id("next")).click(); // Click on "Next" Button
		//Thread.sleep(2000);
		driver.findElement(By.name("Passwd")).sendKeys("admin1"); //Enter text in "Password"
		driver.findElement(By.id("signIn")).click(); // Click on "Sign In" Button
	}*/
	
	
	/**
	 * This example shows how to use locator by links Text and Partial Text.
	 * @throws InterruptedException
	 */
	/*@SuppressWarnings("unused")
	@Test
	public void locatorByLinkTextPartialLink() throws InterruptedException{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.id("gb_70")).click();  
		Thread.sleep(6000);
		
		driver.findElement(By.linkText("Create account")).click();
		driver.findElement(By.partialLinkText("I prefer")).click();
	}*/
	
	/**
	 * This example shows how to use locator by elements Xpath (Absolute and Relative).
	 * @throws InterruptedException
	 */
/*	@SuppressWarnings("unused")
	@Test
	public void locatorByXpath() throws InterruptedException{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		//absolute xpath
		//driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div/div/div[2]/div[3]/div/a")).click(); //to click on Sign In button
		driver.findElement(By.xpath(".//*[@class='gb_pc']//*[@id='gb_70']")).click();
		
		//relative xpath
		driver.findElement((By.xpath("//*[@id='Email']"))).sendKeys("admin1");;
			
		driver.findElement((By.xpath("//*[@id='next']"))).click();
		Thread.sleep(1000);
		driver.findElement((By.xpath("//*[@id='Passwd']"))).sendKeys("aaa");
		driver.findElement((By.xpath("//*[@id='signIn']"))).click();
		
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errormsg_0_Passwd']")).getText(), "The email and password you entered don't match."); //to validate error message
		if (false){
			driver.findElement(By.xpath("//a[contains(text(),'Create an account')]")).click();
		}
		else
			driver.findElement(By.xpath("//*[@id='link-forgot-passwd']")).click();
		
		
		driver.navigate().to("http://www.makemytrip.com/"); // Navigate to Flight+Hotel
		driver.findElement(By.xpath(".//*[@id='widget_row']/div[1]/div/div[2]/ul/li[5]/a/span[2]")).click();
	}*/
	
	
}


