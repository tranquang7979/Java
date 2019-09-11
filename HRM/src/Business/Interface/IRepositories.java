package Business.Interface;

import java.util.ArrayList;

import Models.BaseModel;

public interface IRepositories<T extends BaseModel, K> {
	boolean Create (T input, String sqlCommand);
	boolean Update (T input, String sqlCommand);
	ArrayList<T> ReadAll(String sqlCommand);
	T FindById(K id);
}