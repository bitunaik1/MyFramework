package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedProductWithPriceInformationPage {
public SavedProductWithPriceInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(id="mouseArea_Product Name")
private WebElement productNameTB;

@FindBy(id="mouseArea_Unit Price")
private WebElement unitPriceTB;

@FindBy(id="mouseArea_Commission Rate")
private WebElement commissionTB;

public WebElement getProductNameTB() {
	return productNameTB;
}

public WebElement getUnitPriceTB() {
	return unitPriceTB;
}

public WebElement getCommissionTB() {
	return commissionTB;
}
public String productNameText() {
	return productNameTB.getText();
}
public String unitPriceText() {
	return unitPriceTB.getText();
}
public String commissionText() {
	return commissionTB.getText();
}
}
