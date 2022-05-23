package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains web elements of organization page
 * @author Omprakash
 *
 */
public class OrganizationPage {
public OrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createOrganizationIcon;

public WebElement getCreateOrganizationIcon() {
	return createOrganizationIcon;
}
/**
 * used to create organization
 */
public void clickOnCreateOrganization() {
	createOrganizationIcon.click();
}
}
