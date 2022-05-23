package com.crm.autodesk.genericutility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains web driver specific methods
 * @author Omprakash
 *
 */
public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IPathConstants.ITO, TimeUnit.SECONDS);
	}
	/**
	 * wait for page to load before indentifying any assychronized[java scripts actions] element in DOM [HTML-Docuent]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		
		driver.manage().timeouts().setScriptTimeout(IPathConstants.ITO, TimeUnit.SECONDS);
	}
	
    /**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param element
     */
	public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IPathConstants.ITO);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to wait for element to visible in GUI
	 * @param driver
	 * @param locator
	 */
	public void waitForElementToVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, IPathConstants.ITO);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	  /**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param element
     * @param pollingTime in the form second
	 * @throws Throwable 
     */
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.wait(IPathConstants.ITO);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
	       Set<String> set = driver.getWindowHandles();
	         Iterator<String> it = set.iterator();        
	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          if(driver.getTitle().contains(partialWindowTitle)) {
			        	  break;
			          }
		    	}
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to fetch the text of alert message
	 * @param driver
	 */
	public void switchTogetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	/**
	 * used to send input inside the text box of alert
	 * @param driver
	 * @param text
	 */
	public void switchToSendText(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on visible text available in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option available in GUI
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element , String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * used to upload the file by using clipboard
	 * @param path
	 * @throws Throwable
	 */
	public void fileUploadByClipBoard(String path) throws Throwable {
		StringSelection  path1 = new StringSelection(path);
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(path1, null);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * used to place mouse cursor on specified element and click
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOnElemnet(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	/**
	 * 	 used to right click  on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	/**
	 * used to perform double click
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * used to click the element
	 * @param driver
	 * @param element
	 */
	public void clickTheElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	/**
	 * used to perform move by off set
	 * @param driver
	 * @param x_coordinate
	 * @param y_coordinate
	 */
	public void moveByOffset(WebDriver driver, int x_coordinate, int y_coordinate) {
		Actions act = new Actions(driver);
		act.moveByOffset(x_coordinate, y_coordinate).click().perform();
	}
	/**
	 * used to move an element from one place to another place
	 * @param driver
	 * @param element
	 * @param movedTo
	 */
	public void click_Hold_Move(WebDriver driver, WebElement element, WebElement movedTo) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
		act.moveToElement(movedTo).perform();
		act.release().perform();
	}
	/**
	 * Used to drag one element and drop another location
	 * @param driver
	 * @param dragElement
	 * @param dropLocation
	 */
	public void dragAndDropElement(WebDriver driver, WebElement dragElement, WebElement dropLocation)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(dragElement, dropLocation).perform();
	}
	/**
	 * This method is used to drop the source element at the required x,y co-ordinate
	 * @param driver
	 * @param source
	 * @param x_Distance
	 * @param y_Distance
	 */
	public void dragAndDropUseDistance(WebDriver driver, WebElement source, int x_Distance, int y_Distance) {
		Actions act= new Actions(driver);
		act.dragAndDropBy(source, x_Distance, y_Distance).perform();
	}
	   /**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   } 
   /**
    * used to execute java script of console
    * @param driver
    * @param JavaScript
    */
   public void executeJavascripts(WebDriver driver, int x_axis_coodinate, int y_axis_coordinate ) {
	   JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x_axis_coodinate+","+y_axis_coordinate+");");
	}
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
		/**
		 * used to wait for the element to load and click that element
		 * @param element
		 * @throws InterruptedException
		 */
	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break; 
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }
	   /**
	    * used to take screenshot
	    * @return String
	    * @param driver
	    * @param screenshotName
	    * @throws Throwable
	    */
	    public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
	    	JavaUtility jLib= new JavaUtility();
	    	String dateAndTime=jLib.getSystemDateAndTime().toString().replace(":", "_");
	    //	String dateAndTime=Calendar.getInstance().getTime().toString().replace(":", "_");
	    	String filePath="./errorshot/"+screenshotName+dateAndTime+".png";
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File src=ts.getScreenshotAs(OutputType.FILE);
	    	File dest=new File(filePath);
	    	//Files.copy(src, dest);
	    	FileUtils.copyFile(src, dest);
	    	return dest.getAbsolutePath();
	    }
}