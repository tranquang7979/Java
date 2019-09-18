package Activity21;

import java.util.ArrayList;

public class DanhSach_Generic<T> {
	
	ArrayList<T> lst = new ArrayList<T>();
	
	public void ThemPhanTu(T item) {
		lst.add(item);
	}
	
	public T ChiTiet(int i) {
		return lst.get(i);
	}
	
	public void InDanhSach() {
		for(int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}
	}
	
}
