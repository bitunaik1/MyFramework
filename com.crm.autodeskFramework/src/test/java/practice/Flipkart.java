package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
@Test(enabled = true)
public void flipkart() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	String productName="APPLE iPhone 12 (Green, 128 GB)";
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	driver.findElement(By.name("q")).sendKeys("iphone 12", Keys.ENTER);
	WebElement price=driver.findElement(By.xpath("//div[text()='"+productName+"']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']"));
	System.out.println(price.getText());
	WebElement offer=driver.findElement(By.xpath("//div[text()='APPLE iPhone 12 (Green, 128 GB)']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_3xFhiH']"));
	System.out.println(offer.getText());
	driver.quit();
}
}
