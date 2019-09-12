package Business;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import Helper.PropertyAccess;

public class SqlRepository {

	public static <T> String Insert(T input, Class<T> cls) throws SQLException {
		Connection connection = null;
		try {
			Field[] fields = input.getClass().getFields();
			String tableName = input.getClass().getName().replace("Models.", "");

			String sqlCommand = GenerateInsertCommand(tableName, fields);
			if(sqlCommand.length() == 0) return "Sql command can not be generated.";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Connection connection = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-VPF0AQ3;databaseName=HRM", "hr", "1");
			PreparedStatement statement = connection.prepareStatement(sqlCommand);

			for (int i = 0; i < fields.length; i++) {
				statement = SetValue(i + 1, fields[i], input, cls, statement);
			}

			int result = statement.executeUpdate();
			connection.close();

			return result > 0 ? "" : "Insert data into table "+tableName+" fail.";
		} catch (Exception e) {
			e.printStackTrace();
			
			if(connection != null && !connection.isClosed())
				connection.close();
			
			return e.getMessage();
		}
	}

	public static <T> String Update(T input, Class<T> cls) throws SQLException {
		Connection connection = null;
		try {
			Field[] fields = input.getClass().getFields();
			String tableName = input.getClass().getName().replace("Models.", "");

			String sqlCommand = GenerateInsertCommand(tableName, fields);
			if(sqlCommand.length() == 0) return "Sql command can not be generated.";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Connection connection = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-VPF0AQ3;databaseName=HRM", "hr", "1");
			PreparedStatement statement = connection.prepareStatement(sqlCommand);

			for (int i = 0; i < fields.length; i++) {
				statement = SetValue(i + 1, fields[i], input, cls, statement);
			}

			int result = statement.executeUpdate();
			connection.close();

			return result > 0 ? "" : "Insert data into table "+tableName+" fail.";
		} catch (Exception e) {
			e.printStackTrace();
			
			if(connection != null && !connection.isClosed())
				connection.close();
			
			return e.getMessage();
		}
	}
	
	private static String GenerateInsertCommand(String tableName, Field[] fields) {
		String sqlCommand = "INSERT INTO [dbo].[" + tableName + "] ([COLUMNS]) VALUES ([PARAMETERS])";
		String columns = "";
		String parameters = "";
		for (int i = 0; i < fields.length; i++) {
			columns += fields[i].getName() + ",";
			parameters += "?,";
		}
		if (columns.length() > 0) {
			columns = columns.substring(0, columns.length() - 1);
			parameters = parameters.substring(0, parameters.length() - 1);
			sqlCommand = sqlCommand.replace("[COLUMNS]", columns).replace("[PARAMETERS]", parameters);
			return sqlCommand;
		}
		return "";
	}

	private static <T> PreparedStatement SetValue(int index, Field field, T input, Class<T> cls, PreparedStatement statement) {
		try {
			if (field.getType().equals(int.class)) {
				int value = PropertyAccess.getPropertyGeneric(input, cls,field.getName(), 0);
				statement.setInt(index, value);
				return statement;
			}
			if (field.getType().equals(String.class)) {
				String value = PropertyAccess.getPropertyGeneric(input,cls, field.getName(), "");
				statement.setString(index, value);
				return statement;
			}
			if (field.getType().equals(Float.class)) {
				Float value = PropertyAccess.getPropertyGeneric(input, cls,field.getName(), 0F);
				statement.setFloat(index, value);
				return statement;
			}
			if (field.getType().equals(Boolean.class)) {
				Boolean value = PropertyAccess.getPropertyGeneric(input,cls, field.getName(), false);
				statement.setBoolean(index, value);
				return statement;
			}
			if (field.getType().equals(Date.class)) {
			    java.util.Date utilDate = PropertyAccess.getPropertyGeneric(input,cls, field.getName(), new Date());
			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());				
				statement.setDate(index, sqlDate);
				return statement;
			}
			if (field.getType().equals(Double.class)) {
				Double value = PropertyAccess.getPropertyGeneric(input,cls, field.getName(), Double.parseDouble("0"));
				statement.setDouble(index, value);
				return statement;
			}
			if (field.getType().equals(Long.class)) {
				Long value = PropertyAccess.getPropertyGeneric(input, cls,field.getName(), Long.parseLong("0"));
				statement.setLong(index, value);
				return statement;
			}
			if (field.getType().equals(Short.class)) {
				Short value = PropertyAccess.getPropertyGeneric(input,cls, field.getName(), (short) 0);
				statement.setShort(index, value);
				return statement;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}

}
