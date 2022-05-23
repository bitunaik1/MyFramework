package com.crm.autodesk.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * 
 * @author Omprakash
 *
 */
public class RetryAnalyzerclass implements IRetryAnalyzer {
	int count=0;
	int retryCount=3;
	public boolean retry(ITestResult result) {
//		if(count<retryCount) {
//			count++;
//			return true;
//		}
		for(int i=count;i<retryCount;i++) {
			count++;
			return true;
		}
		return false;
	}
}
