package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
/**
 * This class is used to access common data from property file
 * @author Omprakash
 *
 */
public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 */
    public String getPropertyKeyValue(String key) throws Throwable {
    	 FileInputStream fis = new FileInputStream(IPathConstants.PROPERTIESFILE_PATH);
    	 Properties pobj = new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(key);
		return value;
    }
    /**
     * it is used to set key value in property file
     * @param key
     * @param value
     * @throws Throwable
     */
    public void setPropertyKeyValue(String key, String value) throws Throwable {
    	FileOutputStream fos = new FileOutputStream(IPathConstants.PROPERTIESFILE_PATH);
    	Properties pobj = new Properties();
    	pobj.setProperty(key, value);
    	pobj.store(fos, null);
    }

}
