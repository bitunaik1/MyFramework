package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics {
@Test
public void m1() throws Throwable {
	WebDriverManager.chromedriver().setup();
	ChromeOptions option= new ChromeOptions();
	option.addArguments("--disable-notification");
	WebDriver driver= new ChromeDriver(option);
	driver.get("https://olympics.com/en/athletes/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
	String atheleteFirstName="Suzanne"; ////span[text()='Ziwei']
	driver.findElement(By.xpath("//span[text()='"+atheleteFirstName+"']")).click();
//	try {
//	WebElement goldNo=driver.findElement(By.xpath("//span[@class='medal-text']/preceding-sibling::span[@class='medal-count -gold']"));
//	System.out.println(atheleteFirstName+" has "+goldNo.getText()+" Gold medals.");
//	}
//	catch(Exception e) {
//		throw new Exception("Athelete has no Gold Medals.");
//	}
//	try {
//	WebElement silverNo=driver.findElement(By.xpath("//span[@class='medal-text']/preceding-sibling::span[@class='medal-count -silver']"));
//	System.out.println(atheleteFirstName+" has "+silverNo.getText()+" Silver medals.");
//	}
//	catch(Exception e) {
//		throw new Exception("Athelete has no Silver Medals.");
//	}
//	try {
//	WebElement bronzeNo=driver.findElement(By.xpath("//span[@class='medal-text']/preceding-sibling::span[@class='medal-count -bronze']"));
//	System.out.println(atheleteFirstName+" has "+bronzeNo.getText()+" Bronze medals.");
//	}
//	catch(Exception e) {
//		throw new Exception("Athelete has no Bronze Medals.");
//	}
//	finally {
//		driver.close();
	
	

}
}

