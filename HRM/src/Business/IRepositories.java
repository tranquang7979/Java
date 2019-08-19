package Business;

import java.util.ArrayList;

import Models.BaseModel;

public interface IRepositories<T extends BaseModel, K> {
	T Create (T input);
	T Update (T input);
	ArrayList<T> ReadAll();
	T FindById(K id);
}