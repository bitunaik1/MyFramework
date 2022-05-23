package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumberProvider {
	@Test(dataProvider = "getData")
	public void number(String name, int num) {
		System.out.println(name + num);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj=new Object[5][2];
		obj[0][0]="Vampire1";
		obj[0][1]=999;
		
		obj[1][0]="Morbius1";
		obj[1][1]=111;
		
		obj[2][0]="Dracula1";
		obj[2][1]=000;
		
		obj[3][0]="Godzilla1";
		obj[3][1]=222;
		
		obj[4][0]="Venom1";
		obj[4][1]=333;
		
		return obj;
	}
}
