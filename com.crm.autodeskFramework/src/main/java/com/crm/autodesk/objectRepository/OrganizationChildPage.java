package com.crm.autodesk.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
/**
 * This class contains web element of organization (child)page
 * @author Omprakash
 *
 */
public class OrganizationChildPage {
public OrganizationChildPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id="search_txt")
private WebElement searchBarOfOrganization;

public WebElement getSearchBarOfOrganization() {
	return searchBarOfOrganization;
}
@FindBy(name="search")
private WebElement searchButton;

public WebElement getSearchButton() {
	return searchButton;
}

/**
 * used to provide organization name
 * @param driver
 * @param orgName
 */
public void provideOrgNameAndSearch(WebDriver driver, String orgName) {
	WebDriverUtility wLib= new WebDriverUtility();
	wLib.swithToWindow(driver, "Accounts&action");
	searchBarOfOrganization.sendKeys(orgName);	
	searchButton.click();
	driver.findElement(By.linkText(orgName)).click();
}
}
