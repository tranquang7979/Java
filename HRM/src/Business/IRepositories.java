package Business;

import java.util.ArrayList;

public interface IRepositories<T extends Class, K extends String> {
	T Create (T input);
	T Update (T input);
	ArrayList<T> ReadAll();
	T FindById(K id);
}