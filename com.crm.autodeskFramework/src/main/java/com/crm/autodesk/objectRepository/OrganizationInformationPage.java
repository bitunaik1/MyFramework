package com.crm.autodesk.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
/**
 * This class contains of web element of organization information page
 * @author Omprakash
 *
 */
public class OrganizationInformationPage {
public OrganizationInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(className="dvHeaderText")
private WebElement savedInformationText;

public WebElement getSavedInformationText() {
	return savedInformationText;
}
/**
 * used to capture the saved visible text
 * @return By locator
 */
public By savedInfoText() {
	return By.className("dvHeaderText");
}
/**
 * used to fetch saved organization name
 * @return String
 */
public String actualOrgName() {
	return savedInformationText.getText();
}

@FindBy(xpath="//span[@id='dtlview_Industry']")
private WebElement savedIndustryType;

public WebElement getSavedIndustryType() {
	return savedIndustryType;
}
/**
 * used to fetch industry type
 * @return String
 */
public String savedIndustryText() {
	return savedIndustryType.getText();
}


@FindBy(xpath="//input[@name='accountname']")
private WebElement organizationNameTB;

public WebElement getOrganizationNameTB() {
	return organizationNameTB;
}

@FindBy(xpath="//b[text()='Organization Information']/preceding::input[@title='Save [Alt+S]']")
private WebElement saveOrganizationButton;

public WebElement getSaveOrganizationButton() {
	return saveOrganizationButton;
}

@FindBy(name="industry")
private WebElement industry;

public WebElement getIndustry() {
	return industry;
}
/**
 * used to select the industry type
 * @param text
 */
public void chooseIndustry(String text) {
	WebDriverUtility wLib=new WebDriverUtility();
	wLib.select(industry, text );
}
/**
 * click on save organize button
 */
public void saveOrganization() {
	saveOrganizationButton.click();
}
/**
 * used to provide organization name
 * @param organizationName
 */
public void provideOrganizationName(String organizationName) {
	organizationNameTB.sendKeys(organizationName);
}
}
