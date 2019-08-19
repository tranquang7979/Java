package Business;

import java.util.ArrayList;

import com.google.gson.Gson;

import Utilities.FileHelper;

public abstract class Repositories<T extends Class, K extends String> implements IRepositories<T, K> {
	Class<T> _cls;
	
	protected Repositories(Class<T> cls) {
		_cls = cls;
		//System.out.println(_cls.getName());
	}

	@Override
	public T Create(T input) {
		try {
			Gson gson = new Gson();			
			String json = gson.toJson(input);
			
			//System.out.println(json);
			
			FileHelper file = new FileHelper();
			file.write(_cls.getName(), json);
			
			return input;
		} catch (Exception ex) {			
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public T Update(T input) {
		try {
			Gson gson = new Gson();			
			String json = gson.toJson(input);
			
			//System.out.println(json);
			
			FileHelper file = new FileHelper();
			file.write(_cls.getName(), json);
			
			return input;
		} catch (Exception ex) {			
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<T> ReadAll() {
		try {
			FileHelper file = new FileHelper();
			ArrayList<String> arr = file.read(_cls.getName());
			
			if(arr != null)
			{
				ArrayList<T> result = new ArrayList<T>();
				Gson gson = new Gson();
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
//		try {
//			FileHelper file = new FileHelper();
//			ArrayList<String> arr = file.read(_cls.getName());
//			
//			if(arr != null)
//			{
//				ArrayList<T> result = new ArrayList<T>();
//				Gson gson = new Gson();
//				for(String s : arr)
//				{
//					T item = gson.fromJson(s, _cls);
//					result.add(item);
//				}
//				return result;
//			}
//		} catch (Exception ex) {			
//			ex.printStackTrace();
//		}
		return null;
	}

}
