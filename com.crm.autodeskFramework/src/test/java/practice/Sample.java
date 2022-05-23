package practice;

import java.util.Date;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class Sample {
public static void main(String[] args) throws Throwable {
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	fLib.setPropertyKeyValue("name", "bitu");
	System.out.println("====Done====");
}
}
