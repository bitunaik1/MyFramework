package practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.WebDriverUtility;
/**
 * This class is used to choose date as per our requirement
 * @author Omprakash
 *
 */
public class MakeMyTrip {
	@Test
public void bookTicket() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	
	String date="10";
	String monthAndYear="May 2022";
	Actions act = new Actions(driver);
	act.moveByOffset(5, 5).click().perform();
	
	
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	String pathDate = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	for(;;) {
	try {
		driver.findElement(By.xpath(pathDate)).click();
		break;
	}
	catch(Exception e) {
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	}
	System.out.println("passed");
}
}
}
