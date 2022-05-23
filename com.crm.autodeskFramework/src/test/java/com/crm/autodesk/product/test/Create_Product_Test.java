package com.crm.autodesk.product.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.ProductsInformationPage;
import com.crm.autodesk.objectRepository.ProductsPage;

/**
 * This class is used to create product with mandatory field in vtiger application
 * @author Omprakash
 *
 */
public class Create_Product_Test extends BaseClass{
	@Test(groups="sanatyTest")
public void createProduct() throws Throwable {

	/*create objects for generic utilities*/
	ExcelUtility eLib = new ExcelUtility();

	/*click on product link*/
	HomePage homePage= new HomePage(driver);
	homePage.clickOnProductsLink();
		
	/*click on create product image*/
	ProductsPage productsPage=new ProductsPage(driver);
	productsPage.clickOnCreateProductsImage();
		
	/*provide product name*/
	String productName=eLib.getDataFromExcel("Product", 1, 0)+jLib.getRanDomNum();
	ProductsInformationPage pi=new ProductsInformationPage(driver);
	pi.provideProductName(productName);
	
	/*save the product*/
	pi.saveProduct();

		/*handle synchronize issue*/
		pi.handleSynchronizedForProduct(driver);
		
		/*verify product*/
//		if(pi.savedProductText().contains(productName)) {
//			System.out.println(productName+"--->Product creation is passed.");
//		}
//		else {
//			System.err.println(productName+"--->Product creation is failed.");
//		}
		Assert.assertEquals(pi.savedProductText().contains(productName), true);
}
}
