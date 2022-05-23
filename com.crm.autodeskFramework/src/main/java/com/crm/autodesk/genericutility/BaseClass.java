package com.crm.autodesk.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriverUtility	wLib= new WebDriverUtility();
	public static WebDriver listenerDriver; 

	@BeforeSuite(groups= {"smokeTest","regressionTest","sanatyTest"})
	public void bSuite() {
		System.out.println("Database connection");
	}

	@BeforeTest(groups= {"smokeTest","regressionTest","sanatyTest"})
	public void bTest() {
		System.out.println("Parallel execution");
	}
//	@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest","sanatyTest"})
	public void bc(/* String browser */ ) throws Throwable {
		
		String browser= fLib.getPropertyKeyValue("browser");
		System.out.println(browser);
		String url = fLib.getPropertyKeyValue("url");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("browser is not compatible.");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		listenerDriver=driver;
	}

	@BeforeMethod(groups= {"smokeTest","regressionTest","sanatyTest"})
	public void bMethod() throws Throwable {
		String username=fLib.getPropertyKeyValue("username");
		String password= fLib.getPropertyKeyValue("password");
		LoginPage login=new LoginPage(driver);
		login.login(username, password);
	}

	@AfterMethod(groups= {"smokeTest","regressionTest","sanatyTest"})
	public void aMethod() {
		HomePage homePage= new HomePage(driver);
		homePage.signOut(driver);
	}

	@AfterClass(groups= {"smokeTest","regressionTest","sanatyTest"})
	public void aClass() {
		driver.quit();
	}

	@AfterTest(groups= {"smokeTest","regressionTest","sanatyTest"})
	public void aTest() {
		System.out.println("Parallel execution ended");
	}

	@AfterSuite
	public void aSuite() {
		System.out.println("Database closed");
	}
}
