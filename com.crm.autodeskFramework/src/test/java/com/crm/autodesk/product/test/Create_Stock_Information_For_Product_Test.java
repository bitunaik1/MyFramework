package com.crm.autodesk.product.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.ProductsInformationPage;
import com.crm.autodesk.objectRepository.ProductsPage;
import com.crm.autodesk.objectRepository.SavedProductWithStockInformationPage;


/**
 * This class used to create stock information for product
 * @author Omprakash
 *
 */
public class Create_Stock_Information_For_Product_Test extends BaseClass{
	@Test
public void createStockInfoForProduct() throws Throwable {

	/*create objects for generic utilities*/
	ExcelUtility eLib = new ExcelUtility();
	/*click on product name*/
	HomePage homePage= new HomePage(driver);
	homePage.clickOnProductsLink();
	
	/*click on create production button*/
	ProductsPage productPage = new ProductsPage(driver);
	productPage.clickOnCreateProductsImage();
	
	/*write product name*/
	String productName=eLib.getDataFromExcel("Product", 2, 0);
	ProductsInformationPage pi= new ProductsInformationPage(driver);
	pi.provideProductName(productName);
	
	/*scroll down action*/
	pi.scrollDownPage(driver);
	
	/*choose usage unit*/
	String usageUnit=eLib.getDataFromExcel("Product", 2, 3);
	pi.usageUnitSelect(usageUnit);
	
	/*write quantity in stock*/
	String quantityInStock=eLib.getDataFromExcel("Product", 2, 4);
	pi.provideQuantityInStock(quantityInStock);
	
	/*write quantity per unit*/
	String quantityPerUnit=eLib.getDataFromExcel("Product", 2, 5);
	pi.provideQuantityPerUnit(quantityPerUnit);
	
	/*write reorder level*/
	String reorderLevel=eLib.getDataFromExcel("Product", 2, 6);
	pi.provideReorderLevel(reorderLevel);
	
	/*click on group radio button*/
	pi.clickOnGroupRadioButton();
	
	/*wait till marketing group element will visible*/
	pi.waitTillMarketinGroupVisible(driver);
	
	/*assign marketing group*/
	String marketingGroup=eLib.getDataFromExcel("Product", 2, 7);
	pi.assignMarketingGroup(marketingGroup);

	/*write quantity in demand*/
	String quantityInDemand=eLib.getDataFromExcel("Product", 2, 8);
	pi.provideQuantityInDemand(quantityInDemand);
	
	/*save the product*/
	pi.saveProduct();
	
	/*validation*/
	SavedProductWithStockInformationPage sps = new SavedProductWithStockInformationPage(driver);
//	if(usageUnit.equals(sps.usageUnitText())) {
//		System.out.println(usageUnit+" is verified successfully.");
//	}
//	else {
//		System.out.println(usageUnit+" is not verified.");
//	}
	Assert.assertEquals(usageUnit, sps.usageUnitText());
//	if(sps.quantityInStockText().contains(quantityInStock)) {
//		System.out.println(quantityInStock+" is verified successfully.");
//	}
//	else {
//		System.out.println(quantityInStock+" is not verified.");
//	}
	Assert.assertEquals(sps.quantityInStockText().contains(quantityInStock), true);
//	if(sps.quantityPerUnit().contains(quantityPerUnit)) {
//		System.out.println(quantityPerUnit+" is verified successfully.");
//	}
//	else {
//		System.out.println(quantityPerUnit+" is not verified.");
//	}
	Assert.assertEquals(sps.quantityPerUnit().contains(quantityPerUnit), true);
//	if(reorderLevel.equals(sps.recordLevelText())) {
//		System.out.println(reorderLevel+" is verified successfully.");
//	}
//	else {
//		System.out.println(reorderLevel+" is not verified.");
//	}
	Assert.assertEquals(reorderLevel, sps.recordLevelText());
//	if(quantityInDemand.equals(sps.quantityInDemandText())) {
//		System.out.println(quantityInDemand+" is verified successfully.");
//	}
//	else {
//		System.out.println(quantityInDemand+" is not verified.");
//	}
	Assert.assertEquals(quantityInDemand, sps.quantityInDemandText());
//	if(marketingGroup.equals(sps.marketingGroupText())) {
//		System.out.println(marketingGroup+" is verified successfully.");
//	}
//	else {
//		System.out.println(marketingGroup+" is not verified.");
//	}
	Assert.assertEquals(marketingGroup, sps.marketingGroupText());
}
}
