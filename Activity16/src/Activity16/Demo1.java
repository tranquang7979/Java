package Activity16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {
	
	public void insert() {
		Connection con = null;
		Statement query = null;
		
		try
		{
			/*1. load driver
			expand 'sqljdbc4.jar and find 'SQLServerDriver'
			then, right click and select 'Copy Qualify Name' */
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//2. get connection
			// jdbc:sqlserver://[SERVER NAME];databaseName=[DB NAME]
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity16", "sa", "1");
			
			//3. statement
			String sqlCommand = "insert into Category values (N'Tiểu thuyết', N'no desc')";
			query = con.createStatement();
			int result = query.executeUpdate(sqlCommand);
			if(result > 0)
				System.out.println("Insert success");
			else
				System.out.println("Insert fail");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	// prevent SQL Injection
	public void insert(String name, String description) {
		Connection con = null;
		Statement query = null;
		
		try
		{
			/*1. load driver
			expand 'sqljdbc4.jar and find 'SQLServerDriver'
			then, right click and select 'Copy Qualify Name' */
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//2. get connection
			// jdbc:sqlserver://[SERVER NAME];databaseName=[DB NAME]
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity16", "sa", "1");
			
			//3. PREPARE statement
			String sqlCommand = "insert into Category values (?, ?)";
			PreparedStatement prepare = con.prepareStatement(sqlCommand);
			prepare.setString(1,  name);
			prepare.setString(2,  description);
			
			int result = prepare.executeUpdate();
			if(result > 0)
				System.out.println("Insert success");
			else
				System.out.println("Insert fail");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void select() {
		Connection con = null;
		Statement query = null;
		ResultSet result = null;
		
		try
		{
			/*1. load driver
			expand 'sqljdbc4.jar and find 'SQLServerDriver'
			then, right click and select 'Copy Qualify Name' */
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//2. get connection
			// jdbc:sqlserver://[SERVER NAME];databaseName=[DB NAME]
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity16", "sa", "1");
						
			//3. statement
			String sqlCommand = "select Id, CategoryName, Description from Category";
			query = con.createStatement();
			result = query.executeQuery(sqlCommand);
			
			while(result.next())
			{
				/*System.out.println("Id: " + result.getInt(1) 
								+ " - Name: " + result.getString(2) 
								+ " - Description: " + result.getString(3));*/
				System.out.println("Id: " + result.getInt("id") 
								+ " - Name: " + result.getString("CategoryName") 
								+ " - Description: " + result.getString("Description"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Demo1 d = new Demo1();
		//d.insert();
		d.insert("Truyện ngụ ngôn", "no desc");
		d.select();
	}

}
