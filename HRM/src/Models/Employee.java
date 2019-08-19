package Models;

import java.util.Date;

import Constant.Sex;

public class Employee extends BaseModel {
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
	public String getOccupationId() {
		return OccupationId;
	}
	public void setOccupationId(String occupationId) {
		OccupationId = occupationId;
	}
	public String getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(String departmentId) {
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
	public Date getResignDate() {
		return ResignDate;
	}
	public void setResignDate(Date resignDate) {
		ResignDate = resignDate;
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
	public String OccupationId = "";
	public String DepartmentId = "";
	public Date StartDate = new Date();
	public String SocialInsurranceNo = "";
	public Date SocialInsurranceDate = new Date();
	public Boolean Resign = false;
	public Date ResignDate = new Date();
	}
