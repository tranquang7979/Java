package EmployeeBook;

import java.util.Date;

public class Employee {
	private String id;
	private String name;
	private String department;
	private String designation;
	private String address;
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	private Date dateOfJoining;
	private Date dateOfBirth;
	private Boolean maritalStatus;
	private String mobilePhone;
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	private Date dateOfMarriage;
	
	public Employee(String id, String name, String department, String designation, String address, 
			Date dateOfJoining, Date dateOfBirth, String mobilePhone, Boolean maritalStatus, Date dateOfMarriage) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.maritalStatus = maritalStatus;
		this.mobilePhone = mobilePhone;
		this.dateOfMarriage = dateOfMarriage;
		this.address = address;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Boolean getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(Boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Date getDateOfMarriage() {
		return dateOfMarriage;
	}
	public void setDateOfMarriage(Date dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}
}
