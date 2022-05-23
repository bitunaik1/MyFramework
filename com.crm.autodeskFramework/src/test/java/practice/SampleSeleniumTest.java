package practice;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class SampleSeleniumTest {
	
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8888");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	String orgName = "TestYantra";
	Random r = new Random();
	int num= r.nextInt(1000);
	orgName= orgName+num;
	//step 1: login to app
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("root");
	driver.findElement(By.id("submitButton")).click();
	//step 2: navigate to organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	//step 3: navigate to create organization
	driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	//step 4: verify
	String actual = driver.findElement(By.className("dvHeaderText")).getText();
	if(actual.contains(orgName)) {
		System.out.println(orgName+ " : Org creation is passed");
	}
	else {
	System.out.println(orgName+ " : Org creation is failed");
	}
	//logout
	WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(logout).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	//close
	driver.close();
}
}
