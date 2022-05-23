package practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
@Listeners(com.crm.autodesk.genericutility.ListenerImplementation.class)
public class PracticeExtentReport extends BaseClass{
@Test
public void m1() {
	System.out.println("Script passed");
}
@Test
public void m2() {
	System.out.println("Script failed");
	Assert.fail();
	
	
}
@Test
public void m3() {
	System.out.println("Script skipped");
	throw new SkipException("skipped exception");
}
}
