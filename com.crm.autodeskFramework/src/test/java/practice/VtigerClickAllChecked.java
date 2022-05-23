package practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to click all check box of organizations data
 * @author Omprakash
 *
 */
public class VtigerClickAllChecked {
	@Test
	public void checkAllCheckbox() throws Throwable {
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
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		List<WebElement> checkBox=driver.findElements(By.xpath("//input[@onclick='check_object(this)']"));
		
		for(WebElement i:checkBox) {
			i.click();
		}
		
	}
}
