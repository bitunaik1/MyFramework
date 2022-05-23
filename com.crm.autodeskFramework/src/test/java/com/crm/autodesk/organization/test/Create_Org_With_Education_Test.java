package com.crm.autodesk.organization.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.OrganizationInformationPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

/**
 * This class is used to create organization with mandatory field, industry Education and type Investor
 * @author Omprakash
 *
 */
public class Create_Org_With_Education_Test extends BaseClass{
	@Test(groups="regressionTest")
	public void createOrgWithEducationIndustry() throws Throwable {

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

/*select industry*/
String industry=eLib.getDataFromExcel("org", 1, 1);
oi.chooseIndustry(industry);

/*save organization*/
oi.saveOrganization();
		
		/*verify organization*/
//		if(oi.actualOrgName().contains(organizationName)) {
//			System.out.println(organizationName+"--->Organization creation is passed.");
//		}
//		else {
//			System.err.println(organizationName+"--->Organization creation is failed.")a;
//		}
Assert.assertEquals(oi.actualOrgName().contains(organizationName), true);
		
		/*verify industry*/
//		if(industry.equals(oi.savedIndustryText())) {
//			System.out.println(industry+" is verified.");
//		}
//		else
//		{
//			System.out.println(industry+" is not verified.");
//		}
Assert.assertTrue(industry.equals(oi.savedIndustryText()));

		/*handle synchronize issue*/
		wLib.waitForElementToVisible(driver, oi.savedInfoText());

}
}
