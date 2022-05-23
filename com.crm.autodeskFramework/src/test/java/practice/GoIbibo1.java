package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoIbibo1 {
@Test
public void m1() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	/*go to Goibibo hotel*/
//	driver.get("https://www.goibibo.com/hotels/");
//	/*choose country type*/
//	driver.findElement(By.xpath("//h4[text()='India']/preceding-sibling::input[@name='CountryType']")).click();
//	WebElement textBox=driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']"));
//	textBox.click();
//	textBox.sendKeys("Bengaluru");
//	/*select location*/
//	List<WebElement> suggest=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
//	for(WebElement i:suggest) {
//		String suggestionList=i.getText();
//		System.out.println(suggestionList);
//		}
//	driver.close();
}
}

