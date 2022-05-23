package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementsCompare {
	@Test
public void webelements() throws Throwable {
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
		
		List<WebElement> orgNames=driver.findElements(By.xpath("//a[@title='Organizations']"));
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		
		List<WebElement> contactOrgNames=driver.findElements(By.xpath("//a[@title='Organizations']"));
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(orgNames, contactOrgNames);
		
	//	Assert.assertEquals(orgNames, contactOrgNames);
}
}
