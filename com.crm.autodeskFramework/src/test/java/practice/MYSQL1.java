package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.DatabaseUtility;
import com.crm.autodesk.genericutility.IPathConstants;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MYSQL1 extends DatabaseUtility {
	
	//private ResultSet result;
	
	@Test
public void m1() throws SQLException {
		
	DatabaseUtility Dutil= new DatabaseUtility();
	Dutil.createConnectionToDB();
	String query="select * from students_info;";
	ResultSet rslt = Dutil.getAllData(query);
	while(rslt.next()) {
		System.out.println(rslt.getInt(1)+" "+rslt.getString(2)+" "+rslt.getString(3)+" "+rslt.getString(4));
	}
	Dutil.closeConnection();
}
}
