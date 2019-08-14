package Models;

import java.util.Date;

import Constant.Sex;

public class Employee {
	public int EmployeeId = 0;
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public String getIDNo() {
		return IDNo;
	}
	public void setIDNo(String iDNo) {
		IDNo = iDNo;
	}
	public String getIDDate() {
		return IDDate;
	}
	public void setIDDate(String iDDate) {
		IDDate = iDDate;
	}
	public String getIDPlace() {
		return IDPlace;
	}
	public void setIDPlace(String iDPlace) {
		IDPlace = iDPlace;
	}
	public Boolean getMarried() {
		return Married;
	}
	public void setMarried(Boolean married) {
		Married = married;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getOccupationId() {
		return OccupationId;
	}
	public void setOccupationId(int occupationId) {
		OccupationId = occupationId;
	}
	public int getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public String getSocialInsurranceNo() {
		return SocialInsurranceNo;
	}
	public void setSocialInsurranceNo(String socialInsurranceNo) {
		SocialInsurranceNo = socialInsurranceNo;
	}
	public Date getSocialInsurranceDate() {
		return SocialInsurranceDate;
	}
	public void setSocialInsurranceDate(Date socialInsurranceDate) {
		SocialInsurranceDate = socialInsurranceDate;
	}
	public Boolean getResign() {
		return Resign;
	}
	public void setResign(Boolean resign) {
		Resign = resign;
	}
	public Boolean getActive() {
		return Active;
	}
	public void setActive(Boolean active) {
		Active = active;
	}
	public Boolean getDel() {
		return Del;
	}
	public void setDel(Boolean del) {
		Del = del;
	}
	public Date getResignDate() {
		return ResignDate;
	}
	public void setResignDate(Date resignDate) {
		ResignDate = resignDate;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Date getActiveDate() {
		return ActiveDate;
	}
	public void setActiveDate(Date activeDate) {
		ActiveDate = activeDate;
	}
	public Date getDelDate() {
		return DelDate;
	}
	public void setDelDate(Date delDate) {
		DelDate = delDate;
	}
	public int AccId = 0;
	public int getAccId() {
		return AccId;
	}
	public void setAccId(int accId) {
		AccId = accId;
	}
	public String Avatar = "";
	public String FirstName = "";
	public String LastName = "";
	public Sex Male = Sex.Male;
	public Sex getMale() {
		return Male;
	}
	public void setMale(Sex male) {
		Male = male;
	}
	public Date Birthday = new Date();			
	public String IDNo = "";
	public String IDDate = "";
	public String IDPlace = "";
	public Boolean Married = false;
	public String Address = "";
	public String Email = "";
	public int OccupationId = 0;
	public int DepartmentId = 0;
	public Date StartDate = new Date();
	public String SocialInsurranceNo = "";
	public Date SocialInsurranceDate = new Date();
	public Boolean Resign = false;
	public Boolean Active = false;
	public Boolean Del = false;
	public Date ResignDate = new Date();
	public Date CreateDate = new Date();
	public Date ActiveDate = new Date();
	public Date DelDate = new Date();
	}
