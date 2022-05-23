package com.crm.autodesk.organization.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.OrganizationInformationPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

/**
 * This class is used to create organization with mandatory field in vtiger application
 * @author Omprakash
 *
 */
public class Create_Organization_Test extends BaseClass{
	@Test(groups="sanatyTest")
public void createOrganization() throws Throwable {

	/*create objects for generic utilities*/
	ExcelUtility eLib = new ExcelUtility();

	/*click on organization*/
	HomePage homePage= new HomePage(driver);
	homePage.clickOnOrganizationLink();

	/*click on create organization*/
	OrganizationPage org=new OrganizationPage(driver);
	org.clickOnCreateOrganization();
		
	/*Write organization name*/
	OrganizationInformationPage oi=new OrganizationInformationPage(driver);
	String organizationName =eLib.getDataFromExcel("org", 1, 0)+jLib.getRanDomNum();
	oi.provideOrganizationName(organizationName);
	
	/*save organization*/
	oi.saveOrganization();
	
	/*verify organization*/
//	if(oi.actualOrgName().contains(organizationName)) {
//		System.out.println(organizationName+"--->Organization creation is passed.");
//	}
//	else {
//		System.err.println(organizationName+"--->Organization creation is failed.");
//	}
	Assert.assertEquals(oi.actualOrgName().contains(organizationName), true);
}
}