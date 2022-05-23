package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific methods
 * @author Omprakash
 *
 */
public class JavaUtility {
	/**
	 * generate integer random number within the boundary of 0 to 10000
	 * @return int
	 */
	public int getRanDomNum() {
		Random random = new Random();
		int ranNum = random.nextInt(10000);
		return ranNum;
	}
	/**
	 * used to get system date and time in IST format
	 * @return String
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();
	}
	/**
	 * used to fetch today's date in YYYY-MM-DD format
	 * @return String
	 */
	public String getSystemDateWithFormat() {
		Date date = new Date();
		String dateAndTime=date.toString();
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		String finalFormat= YYYY+"-"+MM+"-"+DD;
		return finalFormat;
	}
}