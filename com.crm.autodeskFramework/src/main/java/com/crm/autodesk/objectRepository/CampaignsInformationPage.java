package com.crm.autodesk.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
/**
 * This class is used to encapsulate Campaign Information page's elements
 * @author Omprakash
 *
 */
public class CampaignsInformationPage {
public CampaignsInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(name="campaignname")
private WebElement campaignNameTB;

@FindBy(xpath="//input[@name='product_name']/following-sibling::img")
private WebElement productIcon;

@FindBy(id="search_txt")
private WebElement productSearchBar;

@FindBy(name="search")
private WebElement searchButton;

@FindBy(xpath="//b[text()='Campaign Information']/preceding::input[@title='Save [Alt+S]']")
private WebElement saveCampaignButton;

@FindBy(id="mouseArea_Product")
private WebElement savedProduct;

@FindBy(xpath="//tr[@class='lvtColData']//a")
private WebElement searchedProduct;

@FindBy(className="dvHeaderText")
private WebElement savedCampaignText;

public WebElement getSavedCampaignText() {
	return savedCampaignText;
}

public WebElement getSearchedProduct() {
	return searchedProduct;
}


public WebElement getSaveCampaign() {
	return savedProduct;
}

public WebElement getSaveCampaignButton() {
	return saveCampaignButton;
}

public WebElement getProductSearchBar() {
	return productSearchBar;
}

public WebElement getSearchButton() {
	return searchButton;
}


public WebElement getProductIcon() {
	return productIcon;
}

public WebElement getCampaignNameTB() {
	return campaignNameTB;
}
/**
 * used to fetch campaign name
 * @return String
 */
public String savedCampaign() {
	return savedCampaignText.getText();
}
/**
 * used to fetch product name
 * @return String
 */
public String savedProduct() {
	return savedProduct.getText();
}
/**
 * used to provide campaign name
 * @param campaignName
 * @return String
 */
public String provideCampaignName(String campaignName) {
	campaignNameTB.sendKeys(campaignName);
	return campaignName;
}
/**
 * click on production icon
 */
public void clickOnProductIcon() {
	productIcon.click();
}
/**
 * it will handle window and provide productname
 * @param driver
 * @param productName
 */
public void selectProduct(WebDriver driver, String productName) {
	WebDriverUtility wLib= new WebDriverUtility();
	wLib.swithToWindow(driver, "Products&action");
	productSearchBar.sendKeys(productName);
	searchButton.click();
	driver.findElement(By.linkText(productName)).click();	
}
/**
 * it will handle window and save campaign
 * @param driver
 */
public void saveCampaign(WebDriver driver) {
	WebDriverUtility wLib= new WebDriverUtility();
	wLib.swithToWindow(driver, "Campaign");
	saveCampaignButton.click();
}
}
