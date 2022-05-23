package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginVtiger {
public static void main(String[] args) throws Throwable {
	WebDriver driver = null;
	FileUtility fLib = new FileUtility();
	String url=fLib.getPropertyKeyValue("url");
	String username=fLib.getPropertyKeyValue("username");
	String password=fLib.getPropertyKeyValue("password");	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	LoginPage login=new LoginPage(driver);
	login.login(username, password);
		
}
}
