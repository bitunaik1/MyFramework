package com.crm.autodesk.campaign.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.CampaignsInformationPage;
import com.crm.autodesk.objectRepository.CampaignsPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.ProductsInformationPage;
import com.crm.autodesk.objectRepository.ProductsPage;
/**
 * This class is used to create campaign with mandatory field and product
 * @author Omprakash
 *
 */
public class Create_Campaign_With_Product_Test extends BaseClass {
	//@Parameters("username")
	@Test(groups="smokeTest")
public void createCampaignWithProduct() throws Throwable {
	//	System.out.println();
	/*create objects for generic utilities*/
	ExcelUtility eLib = new ExcelUtility();

	/*click on product link*/
	HomePage homePage= new HomePage(driver);
	homePage.clickOnProductsLink();
		
	/*click on create product image*/
	ProductsPage productsPage=new ProductsPage(driver);
	productsPage.clickOnCreateProductsImage();
	//Assert.fail();
		
	/*provide product name*/
	String productName=eLib.getDataFromExcel("Product", 1, 0)+jLib.getRanDomNum();
	ProductsInformationPage pi=new ProductsInformationPage(driver);
	pi.provideProductName(productName);
	
	/*save product*/
	pi.saveProduct();
			
	/*click on Campaigns*/
	homePage.clickOnCampaigns(driver);
	
	/*click create campaign link*/
	CampaignsPage campaignPage=new CampaignsPage(driver);
	campaignPage.clickOnCreateCampaigns();
		
	/*write campaign name*/
	String campaignName= eLib.getDataFromExcel("Campaign", 0, 1)+jLib.getRanDomNum();
	CampaignsInformationPage campaignInfo=new CampaignsInformationPage(driver);
	campaignInfo.provideCampaignName(campaignName);

		
	/*click on product image*/
	campaignInfo.clickOnProductIcon();
		
	/*select product*/
	campaignInfo.selectProduct(driver, productName);
		
	/*save campaign*/
	campaignInfo.saveCampaign(driver);
	
	/*verify product*/
	String actualProduct=campaignInfo.savedProduct();
//		if(actualProduct.contains(productName)) {
//			System.out.println(productName+" is added to campaign.");
//		}
//		else {
//			System.out.println(productName+" is not added to campaign.");
//		}
	Assert.assertEquals(actualProduct.contains(productName), true);
		
		/*verify campaign*/
//		if(campaignInfo.savedCampaign().contains(campaignName)) {
//			System.out.println(campaignName+"--->Campaign creation is passed.");
//		}
//		else {
//			System.err.println(campaignName+"--->Campaign creation is failed.");
//		}
	Assert.assertEquals(campaignInfo.savedCampaign().contains(campaignName), true);
}
}
