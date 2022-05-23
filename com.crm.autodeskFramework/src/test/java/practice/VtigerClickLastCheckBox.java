package practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to click last check box of organizations
 * @author Omprakash
 *
 */
public class VtigerClickLastCheckBox {
	@Test
public void checkLastCheckBox() throws Throwable {

	FileUtility fLib = new FileUtility();
	String url=fLib.getPropertyKeyValue("url");
	String username=fLib.getPropertyKeyValue("username");
	String password=fLib.getPropertyKeyValue("password");	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	LoginPage login=new LoginPage(driver);
	login.login(username, password);
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("(//input[@onclick='check_object(this)'])[last()]")).click();
	
}
}
