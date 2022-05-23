package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
@Test(retryAnalyzer = com.crm.autodesk.genericutility.RetryAnalyzerclass.class)
public void retry_Boy() {
	System.out.println("trying...");
	Assert.fail();

}
}
