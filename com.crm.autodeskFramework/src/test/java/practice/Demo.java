package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
WebDriver driver=null;
public static void main(String[] args) {
	Demo d = new Demo();
	//System.out.println(d.driver);
	d.driver=new ChromeDriver();
}
}
