package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains web elements of contact page 
 * @author Omprakash
 *
 */
public class ContactsPage {
public ContactsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement createContactIcon;

public WebElement getCreateContactIcon() {
	return createContactIcon;
}
/**
 * used to click on contact icon
 * 
 */
public void clickOnCreateContactIcon() {
	createContactIcon.click();
}

}
