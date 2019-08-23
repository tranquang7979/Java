package Business;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import Business.Interface.IRepositories;
import Models.BaseModel;
import Utilities.FileHelper;

public abstract class Repositories<T extends BaseModel, K> implements IRepositories<T, K> {
	private Class<T> _cls;
	private T item;
	private FileHelper file = null;
	private Gson gson = null;
		
	public Repositories(Class<T> cls, FileHelper _file, Gson _gson)
	{
		_cls = cls;
		file = _file;
		gson = _gson;
	}
	
	protected Repositories(Class<T> cls) {
		_cls = cls;
		//System.out.println(_cls.getName());
	}

	@Override
	public T Create(T input) {
		try {		
			input.setCreateDate(new Date());
						
			String json = gson.toJson(input);
			
			//System.out.println(json);
			
			file.write(_cls.getName(), json, true);
			
			return input;
		} catch (Exception ex) {			
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public T Update(T input) {
		try {
			if(input.getDel())
				input.setDelDate(new Date());
			if(input.getActive())
				input.setActiveDate(new Date());
			
			ArrayList<T> arr = ReadAll();
			boolean flag = false;
			String json = "";
			
			for(int i = 0; i < arr.size(); i++)
			{
				item = arr.get(i);
				if(item.getId().equals(input.getId()))
				{
					item = input;
					flag = true;
				}	
				json += gson.toJson(item);
			}

			file.write(_cls.getName(), json, false);
			
			return flag ? input : null;
		} catch (Exception ex) {			
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<T> ReadAll() {
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
