package com.crm.autodesk.product.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.ProductsInformationPage;
import com.crm.autodesk.objectRepository.ProductsPage;
import com.crm.autodesk.objectRepository.SavedProductWithPriceInformationPage;

/**
 * This class used to create contact with price information
 * @author Omprakash
 *
 */
public class Create_Product_With_Price_Information_Test extends BaseClass{
	@Test
public void createProductWithPrice() throws Throwable {
	
	/*create objects for generic utilities*/
	ExcelUtility eLib = new ExcelUtility();

	/*click on product name*/
	HomePage homePage= new HomePage(driver);
	homePage.clickOnProductsLink();
	
	/*click on create production button*/
	ProductsPage productPage = new ProductsPage(driver);
	productPage.clickOnCreateProductsImage();
	
	/*write product name*/
	ProductsInformationPage pi= new ProductsInformationPage(driver);
	String productName=eLib.getDataFromExcel("Product", 1, 0);
	pi.provideProductName(productName);
	
	/*write unit price*/
	String unit_Price=eLib.getDataFromExcel("Product", 1, 1);
	pi.provideUnitPrice(unit_Price);
	
	/*write commission percentage*/
	String commissionPercentage=eLib.getDataFromExcel("Product", 1, 2);
	pi.provideCommissionRate(commissionPercentage);
	
	/*save the product*/
	pi.saveProduct();
	
	/*verification of product information*/
	SavedProductWithPriceInformationPage spf=new SavedProductWithPriceInformationPage(driver);
//	if(spf.productNameText().contains(productName)) {
//		System.out.println(productName+" is validated.");
//	}
//	else {
//		System.out.println(productName+" is not validated.");
//	}
	Assert.assertEquals(spf.productNameText().contains(productName), true);
//	if(spf.unitPriceText().contains(unit_Price)) {
//		System.out.println(unit_Price+" is validated.");
//	}
//	else {
//		System.out.println(unit_Price+" is not validated.");
//	}
	Assert.assertEquals(spf.unitPriceText().contains(unit_Price), true);
//	if(spf.commissionText().contains(commissionPercentage)) {
//		System.out.println(commissionPercentage+" is validated.");
//	}
//	else {
//		System.out.println(commissionPercentage+" is not validated.");
//	}
	Assert.assertEquals(spf.commissionText().contains(commissionPercentage), true);
}
}
