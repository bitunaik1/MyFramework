package com.crm.autodesk.contact.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.ContactInformationPage;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.OrganizationChildPage;
import com.crm.autodesk.objectRepository.OrganizationInformationPage;
import com.crm.autodesk.objectRepository.OrganizationPage;
/**
 * This class is used to create contact with organization name and mandatory field
 * @author Omprakash
 *
 */
public class Create_Contact_With_Org_Test extends BaseClass{
	@Test(groups="regressionTest")
public void createContactWithOrg() throws Throwable {
	ExcelUtility eLib= new ExcelUtility();
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
	
	/*handle synchronize issue*/
	wLib.waitForElementToVisible(driver, oi.savedInfoText());
		
	/*verify organization*/
//	if(oi.actualOrgName().contains(organizationName)) {
//		System.out.println(organizationName+"--->Organization creation is passed.");
//	}
//	else {
//		System.err.println(organizationName+"--->Organization creation is failed.");
//	}
	Assert.assertEquals(oi.actualOrgName().contains(organizationName), true);
		
	
	/*click on Contact*/
	homePage.clickOnContactLink();
	
	/*click on create contact*/
	ContactsPage contactPage=new ContactsPage(driver);
	contactPage.clickOnCreateContactIcon();

	/*write mandatory field of contact*/
	ContactInformationPage ci = new ContactInformationPage(driver);
	String lastName=eLib.getDataFromExcel("Contact", 1, 1)+jLib.getRanDomNum();
	ci.provideLastName(lastName);
	
	/*click on organization*/
	ci.clickOrganizationIcon();
	
	/*search for organization name*/
	OrganizationChildPage orgChild=new OrganizationChildPage(driver);
	orgChild.provideOrgNameAndSearch(driver, organizationName);
	
	/*save Contact*/
	ci.clickOnSaveContactButton(driver);
	
	
	/*verify contact*/
//	if(ci.actualLastName().contains(lastName)) {
//		System.out.println(lastName+"--->Contact creation is passed.");
//	}
//	else {
//		System.err.println(lastName+"--->Contact creation is failed.");
//	}
	Assert.assertEquals(ci.actualLastName().contains(lastName), true);
	
	/*verify organization name*/
//	if(ci.savedOrganizationName().contains(organizationName)) {
//		System.out.println(organizationName+"--->Organization verified.");
//	}
//	else {
//		System.err.println(organizationName+"--->Organization not verified.");
//	}	
	Assert.assertEquals(ci.savedOrganizationName().contains(organizationName), true);
}
}
