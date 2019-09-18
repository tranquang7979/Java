package Activity21;

import java.util.ArrayList;

public class DanhSach {
	
	ArrayList lst = new ArrayList();
	
	public void ThemPhanTu(String item) {
		lst.add(item);
	}
	
	public String ChiTiet(int i) {
		return lst.get(i).toString();
	}
	
	public void InDanhSach() {
		for(int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i).toString());
		}
	}
	
}
