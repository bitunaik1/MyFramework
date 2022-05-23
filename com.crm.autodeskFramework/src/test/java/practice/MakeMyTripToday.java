package practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
/**
 * This class is used to fetch all the flight names of current date
 * @author Omprakash
 *
 */
public class MakeMyTripToday {
	@Test
public void fetchFlightNamesOfToday() {
	/*today's date*/
	LocalDateTime dateAndTime=LocalDateTime.now();
	int date=dateAndTime.getDayOfMonth();
	String month=dateAndTime.getMonth().toString();
	int year=dateAndTime.getYear();
	String actualMonth= month.substring(0,1)+month.substring(1).toLowerCase();
	String monthAndyear=actualMonth+" "+year;
	
	/*launch the browser and go to MakeMyTrip*/
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	Actions act = new Actions(driver);
	act.moveByOffset(5, 5).click().perform();
	
	WebElement fromCity=driver.findElement(By.id("fromCity"));
	fromCity.click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Goa, India");
	WebDriverWait wait= new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Goa, India']")));
	
	driver.findElement(By.xpath("//p[text()='Goa, India']")).click();
	driver.findElement(By.xpath("//span[text()='To']")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bhubaneswar, India");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Bhubaneswar, India']")));
	driver.findElement(By.xpath("//p[text()='Bhubaneswar, India']")).click();
	
	/*click on date select area*/
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	
	/*select today's date*/
	String pathDate = "//div[text()='"+monthAndyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	driver.findElement(By.xpath(pathDate)).click();
	
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	
	List<WebElement> listOfFlight=driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
	
	for(WebElement i:listOfFlight) {
		String flightName=i.getText();
		System.out.println("Flight name is "+flightName);
	}
	driver.close();
}
}
