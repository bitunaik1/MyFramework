package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
@Test
public void myntra() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://www.myntra.com/");
	driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("cloths");
	List<WebElement> list = driver.findElements(By.xpath("//ul[@class='desktop-group']/descendant::li"));
	for(WebElement i:list) {
		if(i.getText().contains("For Men")) {
			i.click();
		}
	}
}
}
