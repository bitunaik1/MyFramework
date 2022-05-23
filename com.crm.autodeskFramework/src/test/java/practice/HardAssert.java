package practice;

import java.util.ArrayList;
import java.util.LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
public void hrdAsrt() {
	String name1="Omprakash";
	String name2="Omprakash";
	String name3="Omprakash Naik";
	
	int num1=10;
	int num2=10;
	int num3=20;
	
	
	boolean flag1=true;
	boolean flag2=true;
	boolean flag3=false;
	
	
	char[] ch1=new char[3];
	char[] ch2=new char[3];
	char[] ch3=new char[5];
	Assert.assertEquals(ch2, ch1);//used to compare Array values
	
	ArrayList al1=new ArrayList();
	al1.add("TestYantra");
	al1.add(10);
	al1.add('A');
	
	ArrayList al2=new ArrayList();
	al2.add("Tes");
	al2.add(1);
	al2.add('A');
	
	Assert.assertEquals(al2, al1);
	
	
	
	//Assert.assertEquals(null, null);
	
	Assert.assertEquals(flag2, flag1); //used to compare boolean value
	Assert.assertEquals(num2, num1); //used to compare int value
	Assert.assertEquals(name1, name2);//used to compare String value
}
}
