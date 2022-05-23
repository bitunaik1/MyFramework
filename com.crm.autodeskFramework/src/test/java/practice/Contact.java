package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.objectRepository.ContactInformationPage;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.OrganizationChildPage;
import com.crm.autodesk.objectRepository.OrganizationInformationPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

public class Contact extends BaseClass {
	@Test(groups="smokeTest")
public void createContact() throws Throwable {
	System.out.println("Create Contact");
}
	
	@Test(groups="regressionTest")
	public void createContactWithOrg() throws Throwable {
		System.out.println("create contact with organization");
						
	}
	@Test(groups="smokeTest")
public void createContactWithFirstName() throws Throwable {
	System.out.println("Create contact with first name");
}
	@Test(groups="regressionTest")
public void createContactWithEmail() throws Throwable {
	System.out.println("create contact with email");
}
}
