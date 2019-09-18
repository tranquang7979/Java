package Activity21;

public class Test {
	
	
	public void vd1() {
		DanhSach ds = new DanhSach();
		
		ds.ThemPhanTu("item 1");
		ds.ThemPhanTu("item 2");
		ds.InDanhSach();
	}

	public void vd2() {
		System.out.println("---Integer-------------");
		DanhSach_Generic<Integer> ds1 = new DanhSach_Generic<Integer>();		
		ds1.ThemPhanTu(1);
		ds1.ThemPhanTu(2);
		ds1.InDanhSach();

		System.out.println("---String-------------");
		DanhSach_Generic<String> ds2 = new DanhSach_Generic<String>();
		ds2.ThemPhanTu("item 1");
		ds2.ThemPhanTu("item 2");
		ds2.InDanhSach();


		System.out.println("---Employee-------------");
		DanhSach_Generic<Employee> ds3 = new DanhSach_Generic<Employee>();
		Employee e = new Employee();
		e.setFullName("Steven Tran");
		e.setPhone("0938798009");
		ds3.ThemPhanTu(e);
		ds3.ChiTiet(0);
		ds3.InDanhSach();
	}
	
	public void v31() {
		Employee e = new Employee();
		e.setFullName("Steven Tran");
		e.setPhone("0938798009");
		
		DAOGeneric<Employee> daoEmployee = new DAOGeneric<Employee>();
		daoEmployee.create(e);
		
		
		Department d = new Department();
		d.setName("IT Department");
		d.setLocation("Etown 3");
		
		DAOGeneric<Department> daoDepartment = new DAOGeneric<Department>();
		daoDepartment.create(d);
	}

	public static void main(String[] args) {

		Test tst = new Test();
		
		System.out.println("---TEST NON-GENERIC-------------");
		tst.vd1();
		System.out.println("---TEST GENERIC-------------");
		tst.vd2();
		
	}

}
