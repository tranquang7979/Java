package EmployeeBook;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employee {

	private ArrayList<Employee> arr;

	public Manager(String id, String name, String department, String designation, String address, Date dateOfJoining,
			Date dateOfBirth, String mobilePhone, Boolean maritalStatus, Date dateOfMarriage) {
		super(id, name, department, designation, address, dateOfJoining, dateOfBirth, mobilePhone, maritalStatus,
				dateOfMarriage);
		// TODO Auto-generated constructor stub

		arr = new ArrayList<Employee>();
		arr.add(new Employee(id, name, department, designation, address, dateOfJoining, dateOfBirth, mobilePhone, maritalStatus,
				dateOfMarriage));
	}

	public ArrayList<Employee> selectEmployee() {
		return arr;
	}

	public String addEmployee(Employee e) {
		if (e.getId().length() == 0)
			return "Id is not valid.";

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getId().equals(e.getId()))
				return "This id is existed in the system.";
		}

		arr.add(e);
		return "";
	}

	public void updateEmployee(Employee e) {
		for (int i = 0; i < arr.size(); i++) {
			Employee existEmployee = arr.get(i);
			if (existEmployee.getId().equals(e.getId())) {
				arr.set(i, e);
			}
		}
	}

}
