package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {
@Test
public void mm() throws Throwable {
	WebDriverManager.chromedriver().setup();
	ChromeOptions option= new ChromeOptions();
	option.addArguments("--disable-notification");
	WebDriver driver= new ChromeDriver(option);
	driver.get("https://www.spicejet.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	List<WebElement> lst=driver.findElements(By.xpath("//ul[@class='navbar-nav mr-4 mb-2 mb-lg-0 pl-4 pl-lg-2']/li"));
//	for(WebElement i:lst) {
//		System.out.println(i.getText());
//	}
	driver.findElement(By.xpath("//div[text()='round trip']/parent::div[@class='css-1dbjc4n']/preceding-sibling::div[@class='css-1dbjc4n r-zso239']/*[name()='svg']")).click();
	driver.findElement(By.xpath("//div[text()='To']")).click();
	driver.findElement(By.xpath("//div[text()='Ahmedabad']")).click();
	WebElement rDate= driver.findElement(By.xpath("//div[text()='Return Date']"));
	rDate.click();
	rDate.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@data-testid='undefined-month-April-2022']/descendant::div[text()='8']")).click();
	Thread.sleep(2000);
	//driver.findElement(By.cssSelector("[class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
	driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n r-18u37iz r-1wtj0ep r-1lgpqti\"]/descendant::div[@data-testid=\"home-page-flight-cta\"]")).click();
	driver.close();
	
}
}
