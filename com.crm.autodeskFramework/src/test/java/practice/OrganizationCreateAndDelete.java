package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;
import com.crm.autodesk.objectRepository.OrganizationInformationPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizationCreateAndDelete {
	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root", Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Random ran = new Random();
		int randomNum=ran.nextInt(10000);
		String orgName= "Test baby";
		orgName=orgName+randomNum;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//b[text()='Organization Information']/preceding::input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='tabSelected']/a[text()='Organizations']")));*/
		
		driver.findElement(By.xpath("//td[@class='tabSelected']/a[text()='Organizations']")).click();
		//List<WebElement> orgNames=driver.findElements(By.xpath("//a[@title='Organizations']"));
		
		for(;;) {
			List<WebElement> orgNames=driver.findElements(By.xpath("//a[@title='Organizations']"));
			for(WebElement i:orgNames) {
				System.out.println(i.getText());
			}
			try {
				
				driver.findElement(By.linkText(orgName)).click();
				break;
			}
			catch(Exception e) {
				
				driver.findElement(By.xpath("//table[@align='center']/parent::td/following-sibling::td[@align='right']/descendant::a[@alt='Next']")).click();
			}
		}
		driver.findElement(By.xpath("//input[@name='Delete']")).click();
		driver.switchTo().alert().accept();
		System.out.println("=================organization deleted=====================");
		WebElement administrator=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(administrator).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
