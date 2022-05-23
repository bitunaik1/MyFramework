package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;
/**
 * This class contains the web element of home page
 * @author Omprakash
 *
 */
public class HomePage {
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(className="tabSelected")
private WebElement homeLink;

@FindBy(linkText="Organizations")
private WebElement organizationLink;

@FindBy(linkText="Contacts")
private WebElement ContactsLink;

@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Products']")
private WebElement ProductsLink;

@FindBy(linkText="More")
private WebElement MoreDropDown;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administratorIcon;

@FindBy(linkText="Sign Out")
private WebElement signOutLink;

@FindBy(linkText="Campaigns")
private WebElement campaignsLink;

public WebElement getHomeLink() {
	return homeLink;
}

public WebElement getOrganizationLink() {
	return organizationLink;
}

public WebElement getContactsLink() {
	return ContactsLink;
}

public WebElement getProductsLink() {
	return ProductsLink;
}

public WebElement getMoreDropDown() {
	return MoreDropDown;
}

public WebElement getAdministratorIcon() {
	return administratorIcon;
}

public WebElement getSignOutLink() {
	return signOutLink;
}

public WebElement getCampaignsLink() {
	return campaignsLink;
}
/**
 * used to click on home page
 */
public void clickOnHomeLink() {
	homeLink.click();
}
/**
 * used to perform sign out action
 * @param driver
 */
public void signOut(WebDriver driver) {
	WebDriverUtility wLib=new WebDriverUtility();
	wLib.mouseOnElemnet(driver, administratorIcon);
	signOutLink.click();
}
/**
 * used to click product link
 */
public void clickOnProductsLink() {
	ProductsLink.click();
}
/**
 * used to click on campaigns
 * @param driver
 */
public void clickOnCampaigns(WebDriver driver) {
	WebDriverUtility wLib=new WebDriverUtility();
	wLib.mouseOnElemnet(driver, MoreDropDown);
	campaignsLink.click();
}
/**
 * used to click on organization link
 */
public void clickOnOrganizationLink() {
	organizationLink.click();
}
/**
 * used to click on contact link
 */
public void clickOnContactLink() {
	ContactsLink.click();
}


}