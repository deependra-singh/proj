//package samplePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Popup_AdvConcepts_updated2 {
	
	static WebDriver driver;
		
	
	
	
	
	/**
	 * Working with JavaScript Alerts, need not demo can be used as trail for trainees.
	 * @throws InterruptedException
	 */
	/*@Test
	public void javascriptExample() throws InterruptedException{		
		driver=new FirefoxDriver(); 
		driver.get("D:\\CybageSeleniumTraining\\Selenium_Core Java_March'16\\sample Source\\SeleniumTraining\\SupportingFiles\\JavaScript_COnfirmation.html");
		Thread.sleep(4000);

		driver.findElement(By.id("btn_Try")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.findElement(By.id("btn_Try")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
	}*/
	

/*Use this as Assignment 
 * For Alert: http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert : Hint use driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
 * For Confirmation popup: http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm2
 * For Prompt: http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_state_switch4
 * */
	
	
	/**
	 * Handling Windows User Authentication pop-up dialog
	 * @throws IOException
	 */
	/*@Test
	public void AutoITPopUpExample() throws IOException{
		String[] Param=new String[]{"AutoITScript\\FirstScript.exe", "Authentication Required","CybEmpName","Test@123"};
		Runtime.getRuntime().exec(Param);

		FirefoxDriver myDriver= new FirefoxDriver();
		myDriver.get("http://cybagemis.cybage.com/Framework/Iframe.aspx");		
	}*/
	
	
	
}