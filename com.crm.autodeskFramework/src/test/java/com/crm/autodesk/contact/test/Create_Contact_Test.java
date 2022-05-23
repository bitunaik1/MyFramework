package com.crm.autodesk.contact.test;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.ContactInformationPage;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.HomePage;
/**
 * This class is used to create contact with mandatory field
 * @author Omprakash
 *
 */
public class Create_Contact_Test extends BaseClass{
	//@Parameters({"username1","username2"})
	@Test(groups="smokeTest")
	public void createContact(/* String username1, String username2 */) throws Throwable {
		//System.out.println(username1+" "+username2);
	ExcelUtility eLib = new ExcelUtility();
	/*click on Contact*/
	HomePage homePage= new HomePage(driver);
	homePage.clickOnContactLink();
	
	/*click on create contact*/
	ContactsPage contactPage=new ContactsPage(driver);
	contactPage.clickOnCreateContactIcon();

	/*write mandatory field of contact*/
	ContactInformationPage ci = new ContactInformationPage(driver);
	String lastName=eLib.getDataFromExcel("Contact", 1, 1)+jLib.getRanDomNum();
	ci.provideLastName(lastName);
	
	/*save Contact*/
	ci.clickOnSaveContactButton(driver);
	
	/*verify contact*/
	Assert.assertEquals(ci.actualLastName().contains(lastName), true);
}
}
