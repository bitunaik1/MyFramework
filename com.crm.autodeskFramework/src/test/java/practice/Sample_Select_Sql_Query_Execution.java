package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_Select_Sql_Query_Execution {
	
public static void main(String[] args) throws Throwable {
	Connection conn=null;
	Statement stat;
	try {
	Driver driverRef = new Driver();
	//step 1: load mysql database
	DriverManager.registerDriver(driverRef);
	//step 2: connect to database
	conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
	System.out.println("Connection created to database.");
	//step 3: create query statement
	stat = conn.createStatement();
	String query = "select * from students_info";
	//step 4: Execute the query
	ResultSet resultset=stat.executeQuery(query);
	while(resultset.next()) {
		System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
	}
	}
	catch(Exception e) {
	}
	finally {
		//step 5: close the connection
		conn.close();
		System.out.println("connection closed with database.");
	}
}
}
