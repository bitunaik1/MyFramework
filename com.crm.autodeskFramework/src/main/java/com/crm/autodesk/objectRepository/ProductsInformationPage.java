package com.crm.autodesk.objectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
/**
 * This class contains products information page
 * @author Omprakash
 *
 */
public class ProductsInformationPage {
public ProductsInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(className="lvtHeaderText")
private WebElement savedProductText;

@FindBy(id="commissionrate")
private WebElement commissionRateTB;

@FindBy(name="productname")
private WebElement productNameTB;

@FindBy(xpath="//b[text()='Product Information']/preceding::input[@title='Save [Alt+S]']")
private WebElement saveProductButton;

@FindBy(xpath="//input[@id='unit_price']")
private WebElement unitPriceTB;

@FindBy(xpath="//select[@name='usageunit']")
private WebElement usageUnitDropDown;

@FindBy(id="qtyinstock")
private WebElement quantityInStockTB;

@FindBy(xpath="//input[@value='T']")
private WebElement groupRadioButton;

@FindBy(name="assigned_group_id")
private WebElement marketingGroupDropDown;

@FindBy(id="qty_per_unit")
private WebElement quantityPerUnitTB;

@FindBy(id="reorderlevel")
private WebElement reorderLevelTB;

@FindBy(id="qtyindemand")
private WebElement quantityInDemandTB;

@FindBy(xpath="//textarea[@name='description']")
private WebElement descriptionTB;

public WebElement getsavedProductText() {
	return savedProductText;
}

public WebElement getDescriptionTB() {
	return descriptionTB;
}

public WebElement getUsageUnitDropDown() {
	return usageUnitDropDown;
}

public WebElement getQuantityInStockTB() {
	return quantityInStockTB;
}

public WebElement getGroupRadioButton() {
	return groupRadioButton;
}

public WebElement getMarketingGroupDropDown() {
	return marketingGroupDropDown;
}

public WebElement getQuantityPerUnitTB() {
	return quantityPerUnitTB;
}

public WebElement getReorderLevelTB() {
	return reorderLevelTB;
}

public WebElement getQuantityInDemandTB() {
	return quantityInDemandTB;
}

public WebElement getCommissionRateTB() {
	return commissionRateTB;
}

public WebElement getUnitPrice() {
	return unitPriceTB;
}

public WebElement getSaveProductButton() {
	return saveProductButton;
}

public WebElement getProductNameTB() {
	return productNameTB;
}
public void clickOnGroupRadioButton() {
	groupRadioButton.click();
}
/**
 * used to wait for the web element to be clickable
 * @param driver
 */
public void handleSynchronizedForProduct(WebDriver driver) {
	WebDriverUtility wLib=new WebDriverUtility();
	wLib.waitForElemnetToBeClickAble(driver, savedProductText);
}
/**
 * used to fetch saved product name
 * @return
 */
public String savedProductText() {
	return savedProductText.getText();
}
/**
 * used to perform scroll up
 * @param driver
 */
public void scrollDownPage(WebDriver driver) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0, 300);");
}
/**
 * used to wait for the element to be clickable
 * @param driver
 */
public void waitTillMarketinGroupVisible(WebDriver driver) {
	WebDriverUtility wLib=new WebDriverUtility();
	wLib.waitForElemnetToBeClickAble(driver, marketingGroupDropDown);
}
/**
 * used to provide quantity in demand
 * @param quantityInDemand
 */
public void provideQuantityInDemand(String quantityInDemand) {
	quantityInDemandTB.sendKeys(quantityInDemand);
}
/**
 * used to provide marketing group
 * @param marketingGroup
 */
public void assignMarketingGroup(String marketingGroup) {
	WebDriverUtility wLib= new WebDriverUtility();
	wLib.select(marketingGroupDropDown, marketingGroup);
}
/**
 * used to provide reorder level
 * @param reorderLevel
 */
public void provideReorderLevel(String reorderLevel) {
	reorderLevelTB.sendKeys(reorderLevel);
}
/**
 * used to provide the quantity per unit
 * @param quantityPerUnit
 */
public void provideQuantityPerUnit(String quantityPerUnit) {
	quantityPerUnitTB.sendKeys(quantityPerUnit);
}
/**
 * used to provide quantity in stock
 * @param quantityInStock
 */
public void provideQuantityInStock(String quantityInStock) {
	quantityInStockTB.sendKeys(quantityInStock);
}
/**
 * used to select usage unit type
 * @param usageUnitType
 */
public void usageUnitSelect(String usageUnitType) {
	WebDriverUtility wLib=new WebDriverUtility();
	wLib.selectByValue(usageUnitDropDown, usageUnitType);
}
/**
 * used to provide commission percentage
 * @param commissionPercentage
 */
public void provideCommissionRate(String commissionPercentage) {
	commissionRateTB.sendKeys(commissionPercentage);
}
/**
 * used to provide unit price
 * @param unit_Price
 */
public void provideUnitPrice(String unit_Price) {
	unitPriceTB.clear();
	unitPriceTB.sendKeys(unit_Price);
}
/**
 * used to provide product name
 * @param productName
 * @return
 */
public void provideProductName(String productName){
	productNameTB.sendKeys(productName);
}
/**
 * used to click on save product button
 */
public void saveProduct() {
	saveProductButton.click();
}
}
