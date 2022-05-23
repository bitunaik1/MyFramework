package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoIbiboHotelBooking {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*go to Goibibo hotel*/
		driver.get("https://www.goibibo.com/hotels/");
		/*choose country type*/
		driver.findElement(By.xpath("//h4[text()='India']/preceding-sibling::input[@name='CountryType']")).click();
		WebElement textBox=driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']"));
		textBox.click();
		textBox.sendKeys("Bengaluru");
		/*select location*/
		List<WebElement> suggest=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		for(WebElement i:suggest) {
			String suggestionList=i.getText();
			if(suggestionList.contains("(Bengaluru)")) {
				i.click();
				break;
			}
		}
		/*click on calender*/
		driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']")).click();
		/*checkin date*/
		driver.findElement(By.xpath("//span[text()='March 2022']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='31']")).click();
		/*checkout date*/
		driver.findElement(By.xpath("//span[text()='April 2022']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='1']")).click();
		/*number of guests*/
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
		/*select number of child*/
		for(int i=1;i<=3;i++) {
		driver.findElement(By.xpath("//span[text()='Children']/following-sibling::div/descendant::span[text()='+']")).click();
		}
		
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='1']/following-sibling::div/child::h4")));
		/*first child's age*/
		driver.findElement(By.xpath("//span[text()='1']/following-sibling::div/child::h4")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='1']/following-sibling::ul/child::li[2]")));
		driver.findElement(By.xpath("//span[text()='1']/following-sibling::ul/child::li[2]")).click();
		/*second child's age*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='2']/following-sibling::div/child::h4")));
		driver.findElement(By.xpath("//span[text()='2']/following-sibling::div/child::h4")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='2']/following-sibling::ul/child::li[3]")));
		driver.findElement(By.xpath("//span[text()='2']/following-sibling::ul/child::li[3]")).click();
		/*third child's age*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='3']/following-sibling::div/child::h4")));
		driver.findElement(By.xpath("//span[text()='3']/following-sibling::div/child::h4")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='3']/following-sibling::ul/child::li[4]")));
		driver.findElement(By.xpath("//span[text()='3']/following-sibling::ul/child::li[4]")).click();
		/*click on done*/
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		/*click on search on hotels*/
		driver.findElement(By.xpath("//button[@data-testid='searchHotelBtn']")).click();
		/*fetch all the hotels*/
		List<WebElement> hotels=driver.findElements(By.xpath("//h4[@itemprop='name']"));
		for(WebElement i:hotels) {
			System.out.println(i.getText());
		}
		/*close the browser*/
		driver.close();
	}
}
