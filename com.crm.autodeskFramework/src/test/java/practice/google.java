package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class google {
	@Test
	public void google1() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("cycle");
	//	List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"autocomplete-results-container\"]/descendant::div[@class=\"s-suggestion\"]/span"));
		List<WebElement> list=driver.findElements(By.xpath("//div[@id=\"nav-flyout-searchAjax\"]/descendant::div[@role=\"button\"]/span[@class=\"s-heavy\"]"));
	//	Thread.sleep(2000);
		for(WebElement i:list) {
			
			System.out.println(i.getText());
		}
	
	}

}
