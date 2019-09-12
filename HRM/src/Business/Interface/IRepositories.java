package Business.Interface;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.BaseModel;

public interface IRepositories<T extends BaseModel, K> {
	String Create (T input) throws SQLException;
	String Update (T input) throws SQLException;
	ArrayList<T> ReadAll(String sqlCommand);
	T FindById(K id);
}