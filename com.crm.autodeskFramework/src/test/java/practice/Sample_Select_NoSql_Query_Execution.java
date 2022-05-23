package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_Select_NoSql_Query_Execution {
public static void main(String[] args) throws Throwable {
	Connection conn=null;;
	Statement stat;
	int result1=0;
	Driver driverRef = new Driver();
	//step 1: load mysql database
	try {
	DriverManager.registerDriver(driverRef);
	//step 2: create connection with database
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
	System.out.println("Connection created.");
	//step 3: create query statement
	stat = conn.createStatement();
	String query = "insert into students_info values('8', 'boommm', 'muslim', 'h');";
	//String query2 = "insert into students_info values('6', 'kaboom', 'sikh', 'h');";
	//step 4: execute query
	result1 = stat.executeUpdate(query);
	}
	catch(Exception e) {
		
	}
	finally {
	//int result2 = stat.executeUpdate(query2);
		if(result1==1) {
		System.out.println("project inserted successfully");	
		}
		else {
			System.err.println("project is not inserted");
		}
	//step 5: close the connection
	conn.close();
	System.out.println("Connection closed.");
	}
}
}
