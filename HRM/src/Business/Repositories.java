package Business;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import Business.Interface.IRepositories;
import Business.Interface.ISqlRepository;
import Helper.PropertyAccess;
import Models.BaseModel;
import Utilities.FileHelper;

public abstract class Repositories<T extends BaseModel, K> implements IRepositories<T, K> {
	private Class<T> _cls;
	private T item;
	private FileHelper file = null;
	private Gson gson = null;
		
	public Repositories(Class<T> cls, Gson _gson)
	{
		_cls = cls;
		gson = _gson;
	}
	
	protected Repositories(Class<T> cls) {
		_cls = cls;
	}

	@Override
	public boolean Create(T input, String sqlCommand) {
		return SqlRepository.Execute(input, sqlCommand);
	}

	@Override
	public boolean Update(T input, String sqlCommand) {
		return SqlRepository.Execute(input, sqlCommand);
	}

	@Override
	public ArrayList<T> ReadAll(String sqlCommand) {
		try {
			ArrayList<String> arr = file.read(_cls.getName());
			
			if(arr != null)
			{
				ArrayList<T> result = new ArrayList<T>();				
				for(String s : arr)
				{
					T item = gson.fromJson(s, _cls);
					result.add(item);
				}
				return result;
			}
		} catch (Exception ex) {			
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public T FindById(K id) {
		try {
			ArrayList<String> arr = file.read(_cls.getName());

			for(String s : arr)
			{
				T item = gson.fromJson(s, _cls);
				if(item.getId().equals(item.getId()))
					return item;
			}
		} catch (Exception ex) {			
			ex.printStackTrace();
		}
		return null;
	}

}
