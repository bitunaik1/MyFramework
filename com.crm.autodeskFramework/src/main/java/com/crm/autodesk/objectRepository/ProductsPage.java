package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains web element of product page  
 * @author Omprakash
 *
 */
public class ProductsPage {
public ProductsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[@title='Create Product...']")
private WebElement createProductImage;

public WebElement getCreateProductImage() {
	return createProductImage;
}
/**
 * used to click on create product image
 */
public void clickOnCreateProductsImage() {
	createProductImage.click();
}

}
