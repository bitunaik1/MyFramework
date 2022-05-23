package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedProductWithStockInformationPage {
public SavedProductWithStockInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id="mouseArea_Usage Unit")
private WebElement usageUnitTB;

@FindBy(xpath="//span[@id='dtlview_Qty. in Stock']")
private WebElement quantityInStockTB;

@FindBy(xpath="//span[@id='dtlview_Handler']/child::a[text()='Team Selling']")
private WebElement marketingGroupDropDown;

@FindBy(id="mouseArea_Qty/Unit")
private WebElement quantityPerUnitTB;

@FindBy(xpath="//span[@id='dtlview_Reorder Level']")
private WebElement reorderLevelTB;

@FindBy(xpath="//span[@id='dtlview_Qty. in Demand']")
private WebElement quantityInDemandTB;

public WebElement getUsageUnitTB() {
	return usageUnitTB;
}

public WebElement getQuantityInStockTB() {
	return quantityInStockTB;
}

public WebElement getMarketingGroupDropDown() {
	return marketingGroupDropDown;
}

public WebElement getQuantityPerUnitTB() {
	return quantityPerUnitTB;
}

public WebElement getReorderLevelTB() {
	return reorderLevelTB;
}

public WebElement getQuantityInDemandTB() {
	return quantityInDemandTB;
}
/**
 * used to fetch data from saved quantity of demand text box
 * @return String
 */
public String quantityInDemandText() {
	return quantityInDemandTB.getText();
}
/**
 * used to fetch record level text
 * @return String
 */
public String recordLevelText() {
	return reorderLevelTB.getText();
}
/**
 * used to fetch quantity per unit
 * @return String
 */
public String quantityPerUnit() {
	return quantityPerUnitTB.getText();
}
/**
 * it will fetch the marketing group
 * @return String
 */
public String marketingGroupText() {
	return marketingGroupDropDown.getText();
}
/**
 * used to provide saved quantity in stock
 * @return
 */
public String quantityInStockText() {
	return quantityInStockTB.getText();
}
/**
 * used to provide saved usage unit text box value
 * @return String
 */
public String usageUnitText() {
	return usageUnitTB.getText();
}
}
