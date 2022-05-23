package com.crm.autodeskFramework.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RemoteExecution {
	RemoteWebDriver driver;
	@Parameters("Browser")
	@BeforeClass
	public void configBeforeClass(String BROWSER) throws MalformedURLException {
			 URL url = new URL("http://192.168.1.100:4444/wd/hub");//check url
			  DesiredCapabilities cap= new DesiredCapabilities();	
			if(BROWSER.equals("chrome")) {
				  cap.setPlatform(Platform.WINDOWS);
				  cap.setBrowserName("chrome");
			}else if(BROWSER.equals("firefox")){
				  cap.setPlatform(Platform.WINDOWS);
				  cap.setBrowserName("firefox");
			}
			driver = new RemoteWebDriver(url, cap);
		}	
	@Test 
	public void remotteExcecution() throws MalformedURLException
	{
			  driver.get("http://gmail.com");
	}                                                  
}
