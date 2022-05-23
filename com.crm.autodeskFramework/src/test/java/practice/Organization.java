package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.OrganizationInformationPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

public class Organization extends BaseClass{
	@Test(groups="smokeTest")
public void createOrganization() throws Throwable {
		System.out.println("Organization created with smoke");

	
}
	@Test(groups="regressionTest")
	public void createOrgWithEducationIndustry() throws Throwable {
		System.out.println("create org with industry");


}
	@Test(groups="smokeTest")
public void createOrganizationWithwebsite() throws Throwable {
		System.out.println("org with website");
	}	
}
