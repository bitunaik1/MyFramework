package practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class Yatra {
public static void main(String[] args) {
	
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.yatra.com/");
	driver.findElement(By.id("BE_flight_origin_date")).click();
	WebElement drag = driver.findElement(By.className("month-wrapper"));
	Actions act = new Actions(driver);
	act.dragAndDropBy(drag, 0, 20).perform();
}
}
