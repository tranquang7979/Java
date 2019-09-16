package Activity20;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataTest {
	
	public void Database_metadata() {
		try {
			/* HOW TO GET FULL PATH OF SQLDRIVER
			 * step 1: expand 'sqljdbc4.jar'
			 * step 2: find 'SQLServerDriver'
			 * step 3: right click and select 'Copy Qualified Name'*/
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity20", "sa" , "1");
			DatabaseMetaData dbMetadata = connection.getMetaData();
			ResultSet result = dbMetadata.getTables(null, null, null, new String[] {"TABLE"});
			
			while(result.next()) {
				System.out.println("--- METADATA of DATABASE --------------------------");
				System.out.println(result.getString("TABLE_NAME"));
				System.out.println("******");
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				System.out.println(result.getString(4));
			}

			result.close();
			connection.close();
		} catch (Exception e) {
			
		}		
	}

	public void ResultSet_metadata() {
		try {
			/* HOW TO GET FULL PATH OF SQLDRIVER
			 * step 1: expand 'sqljdbc4.jar'
			 * step 2: find 'SQLServerDriver'
			 * step 3: right click and select 'Copy Qualified Name'*/
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity20", "sa" , "1");
			
			String sql = "select * from Category";
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			ResultSetMetaData metaData = result.getMetaData();

			System.out.println("--- METADATA of TABLE --------------------------");
			System.out.println("Table CATEGORY");
			System.out.println("Catalog: " + metaData.getCatalogName(1));
			System.out.println("Total Columns: " + metaData.getColumnCount());
			
			for(int i = 1; i <= metaData.getColumnCount(); i++) {
				System.out.println("-----------------------------");
				System.out.println("Column Name: " + metaData.getColumnName(i));
				System.out.println("Column Type: " + metaData.getColumnTypeName(i));
				System.out.println("Is Auto Increment: " + metaData.isAutoIncrement(i));
			}
			
			
			result.close();
			connection.close();
		} catch (Exception e) {
			
		}		
	}

	public void ResultSet_ScrollSensitive() {
		try {
			/* HOW TO GET FULL PATH OF SQLDRIVER
			 * step 1: expand 'sqljdbc4.jar'
			 * step 2: find 'SQLServerDriver'
			 * step 3: right click and select 'Copy Qualified Name'*/
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity20", "sa" , "1");
			
			String sql = "select * from Category";
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet result = statement.executeQuery(sql);

			System.out.println("--- METADATA SCROLL SENSITIVE --------------------------");

			/*ABSOLUTE: after get absolute at a specified row, its index will become 0 */
			// try to get the second row
			Boolean canRead = result.absolute(2);
			if(canRead)
			{
				System.out.println("--- Absolute ---");
				System.out.println("Id: " + result.getString(1)); // first column
				System.out.println("Name: " + result.getString(2)); // second column
			}

			/*RELATIVE: base on the ABSOLUTE row (index 0) and count next or previous*/
			System.out.println("--- Relative ---");
			canRead = result.relative(-1);
			if(canRead)
			{
				System.out.println("Id: " + result.getString(1)); // first column
				System.out.println("Name: " + result.getString(2)); // second column
			}
						
			result.close();
			connection.close();
		} catch (Exception e) {
			
		}		
	}

	public void ResultSet_ScrollSensitiveUpdate() {
		try {
			/* HOW TO GET FULL PATH OF SQLDRIVER
			 * step 1: expand 'sqljdbc4.jar'
			 * step 2: find 'SQLServerDriver'
			 * step 3: right click and select 'Copy Qualified Name'*/
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity20", "sa" , "1");
			
			String sql = "select * from Category";
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet result = statement.executeQuery(sql);

			System.out.println("--- METADATA SCROLL SENSITIVE UPDATE --------------------------");

			/*LAST: after get last row, its index will become 0 (same ABSOLUTE)*/
			Boolean canRead = result.last();
			if(canRead)
			{
				System.out.println("--- Last ---");
				System.out.println("Id: " + result.getString(1)); // first column
				System.out.println("Name: " + result.getString(2)); // second column
				
				result.updateString(2,  "Fashion");
				result.updateRow();
			}

			/*RELATIVE: base on the LAST row (index 0) and count next or previous*/
			System.out.println("--- Relative ---");
			canRead = result.relative(-2);
			if(canRead)
			{
				System.out.println("Id: " + result.getString(1)); // first column
				System.out.println("Name: " + result.getString(2)); // second column
			}
				
			result.close();
			connection.close();
		} catch (Exception e) {
			
		}		
	}

	public static void main(String[] args) {
		MetaDataTest test = new MetaDataTest();
		test.Database_metadata();
		test.ResultSet_metadata();
		test.ResultSet_ScrollSensitive();
		test.ResultSet_ScrollSensitiveUpdate();
	}

}
