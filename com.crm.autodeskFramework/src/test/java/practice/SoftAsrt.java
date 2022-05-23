package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsrt {
	@Test
public void softAsrt() {
		String name1="Omprakash";
		String name2="Omprakash";
		String name3="Omprakash Naik";
		
		int num1=10;
		int num2=10;
		int num3=20;
		
		
		boolean flag1=true;
		boolean flag2=true;
		boolean flag3=false;
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(flag2, flag3); // used to compare boolean values
		soft.assertEquals(num2, num1);//used to compare int values
		soft.assertEquals(name2, name3);//used to compare string values
		soft.assertAll();
		
	}
}
