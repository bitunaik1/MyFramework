package practice;

import java.util.Scanner;

public class ScannerClass {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("type first number.");
	int firstNum = sc.nextInt();
	System.out.println("type second number");
	int secondNum=sc.nextInt();
	int sum= firstNum+secondNum;
	System.out.println(sum);
}
}
