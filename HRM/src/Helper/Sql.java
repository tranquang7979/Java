package Helper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Sql<T> {
	private Class<T> _cls;
	
	public void select(String command){
		_cls.getName();
	}
}
