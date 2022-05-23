package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
/**
 * This class contains web elements of contact information page
 * @author Omprakash
 *
 */
public class ContactInformationPage {
public ContactInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(name="lastname")
private WebElement lastNameTB;

public WebElement getLastNameTB() {
	return lastNameTB;
}
@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement OrganizationIcon;

public WebElement getOrganizationIcon() {
	return OrganizationIcon;
}

@FindBy(id="mouseArea_Organization Name")
private WebElement actualOrganizationNameText;

public WebElement getActualOrganizationNameText() {
	return actualOrganizationNameText;
}
/**
 * used to fetch saved organization name
 * @return String
 */
public String savedOrganizationName() {
	return actualOrganizationNameText.getText();
}
@FindBy(className="dvHeaderText")
private WebElement savedInformationText;

public WebElement getSavedInformationText() {
	return savedInformationText;
}
/**
 * used to fetch saved last name
 * @return String
 */
public String actualLastName() {
	return savedInformationText.getText();
}
/**
 * used to click on organization icon
 */
public void clickOrganizationIcon() {
	OrganizationIcon.click();
}

@FindBy(xpath="//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")
private WebElement saveContactButton;

public WebElement getSaveContactButton() {
	return saveContactButton;
}
/**
 * this method will handle the window pop up and click on save button
 * @param driver
 */
public void clickOnSaveContactButton(WebDriver driver) {
	WebDriverUtility wLib= new WebDriverUtility();
	wLib.swithToWindow(driver, "Contact");
	saveContactButton.click();
}
/**
 * used to provide last name
 * @param lastName
 */
public void provideLastName(String lastName) {
	lastNameTB.sendKeys(lastName);
}

}
