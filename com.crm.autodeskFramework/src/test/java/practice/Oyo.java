package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Oyo {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	
	/*create objects for generic utilities*/
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	
	String checkInMonth = eLib.getDataFromExcel("oyo", 2, 0);
	String checkIn = eLib.getDataFromExcel("oyo", 2, 1);
	String checkOutMonth= eLib.getDataFromExcel("oyo", 2, 2);
	String checkOut=eLib.getDataFromExcel("oyo", 2, 3);
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	wLib.waitForPageToLoad(driver);
	String url = fLib.getPropertyKeyValue("oyourl");
	driver.get(url);
	driver.findElement(By.xpath("//span[@class='datePickerDesktop__arrowWrapper datePickerDesktop__arrowWrapper--home']")).click();
	WebElement nextMonth=driver.findElement(By.xpath("//div[@class='DateRangePicker__PaginationArrowIcon DateRangePicker__PaginationArrowIcon--next']"));
	for(;;) {
		try {
			WebElement checkInDate=driver.findElement(By.xpath("//span[text()='"+checkInMonth+"']/ancestor::div[@class='DateRangePicker__Month']/descendant::span[text()='"+checkIn+"']"));
			checkInDate.click();
			break;
		}
		catch(Exception e) {
			nextMonth.click();
		}
	}
	for(;;) {
		try {
			WebElement checkOutDate=driver.findElement(By.xpath("//span[text()='"+checkOutMonth+"']/ancestor::div[@class='DateRangePicker__Month']/descendant::span[text()='"+checkOut+"']"));
			wLib.clickTheElement(driver, checkOutDate);
			break;
		}
		catch(Exception e) {
			nextMonth.click();
		}
	}
}
}
