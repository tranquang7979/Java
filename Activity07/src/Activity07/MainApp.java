package Activity07;

public class MainApp {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		e1.employeeCode = "E001";
		e1.employeeName = "An";
		e1.password = "123456";
		e1.userName = "user01";
		e1.address = "123 NT";
		
		System.out.println("==============================");
		System.out.print("EmployeeName: " + e1.employeeName + "\n");
		System.out.print("UserName/Password: " + e1.userName + "\t" + e1.password);
		System.out.printf("EmployeeCode: %s", e1.getEmployeeCode());
	}

}
