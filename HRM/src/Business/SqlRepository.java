package Business;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import Business.Interface.ISqlRepository;
import Helper.PropertyAccess;

public class SqlRepository {
	
	public static <T> boolean Execute(T cls, String sqlStatement){
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
			//Connection connection = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");	
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-VPF0AQ3;databaseName=HRM", "hr", "1");
			CallableStatement statement = connection.prepareCall(sqlStatement);

			Field[] fields = cls.getClass().getFields();
		    for (Field f : fields) {			    	
		    	statement = SetValue(f, cls.getClass(), statement);
		    }
			
		    statement.execute();
			connection.close();		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
//			//Connection connection = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");	
//			Connection connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-VPF0AQ3;databaseName=HRM", "hr", "1");
//			Statement statement = connection.createStatement();
//
//			Field[] fields = cls.getClass().getFields();
//		    for (int i = 0; i < fields.length; i++) {
//		    	Field field = fields[i];
//		    	sqlStatement = sqlStatement.replace("p" + i, PropertyAccess.getProperty(cls, field.getName()).toString());
//		    }
//			
//		    statement.executeUpdate(sqlStatement);
//			connection.close();		
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
	}
	
	private static CallableStatement SetValue(Field field, Object input, CallableStatement statement)
	{
		try {
			if(field.getType().equals(int.class))
	    	{
	    		statement.setInt(field.getName(), PropertyAccess.getProperty(input, field.getName(), 0));
	    		return statement;
	    	}
	    	if(field.getType().equals(String.class))
	    	{
	    		statement.setString(field.getName(), PropertyAccess.getProperty(input, field.getName(), ""));
	    		return statement;
	    	}
	    	if(field.getType().equals(Float.class))
	    	{
	    		statement.setFloat(field.getName(), PropertyAccess.getProperty(input, field.getName(), 0F));
	    		return statement;
	    	}
	    	if(field.getType().equals(Boolean.class))
	    	{
	    		statement.setBoolean(field.getName(), PropertyAccess.getProperty(input, field.getName(), false));
	    		return statement;
	    	}
	    	if(field.getType().equals(Date.class))
	    	{
	    		statement.setDate(field.getName(), (java.sql.Date) PropertyAccess.getProperty(input, field.getName(), new Date()));
	    		return statement;
	    	}
	    	if(field.getType().equals(Double.class))
	    	{
	    		statement.setDouble(field.getName(), PropertyAccess.getProperty(input, field.getName(), 0));
	    		return statement;
	    	}
	    	if(field.getType().equals(Long.class))
	    	{
	    		statement.setLong(field.getName(), PropertyAccess.getProperty(input, field.getName(), 0));
	    		return statement;
	    	}
	    	if(field.getType().equals(Short.class))
	    	{
	    		statement.setShort(field.getName(), PropertyAccess.getProperty(input, field.getName(), (short)0));
	    		return statement;
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}
}
