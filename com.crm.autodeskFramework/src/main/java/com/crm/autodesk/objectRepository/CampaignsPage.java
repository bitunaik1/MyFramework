package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains web elements of campaigns page
 * @author Omprakash
 *
 */
public class CampaignsPage {
public CampaignsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@title='Create Campaign...']")
private WebElement createCampaignsIcon;

public WebElement getCreateCampaignsIcon() {
	return createCampaignsIcon;
}
/**
 * used to click create campaign icon
 */
public void clickOnCreateCampaigns() {
	createCampaignsIcon.click();
}
}
