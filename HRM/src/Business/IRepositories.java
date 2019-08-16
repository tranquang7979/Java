package Business;

import java.util.ArrayList;

public interface IRepositories<T> {
	T Create (T input);
	T Update (T input);
	ArrayList<T> ReadAll();
}