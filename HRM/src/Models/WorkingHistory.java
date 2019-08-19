package Models;

import java.util.Date;

public class WorkingHistory extends BaseModel {
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public Date getFromDate() {
		return FromDate;
	}
	public void setFromDate(Date fromDate) {
		FromDate = fromDate;
	}
	public Date getToDate() {
		return ToDate;
	}
	public void setToDate(Date toDate) {
		ToDate = toDate;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String EmployeeId = "";
	public Date FromDate = new Date();
	public Date ToDate = new Date();
	public String OccupationId = "";
	public String DepartmentId = "";
	public String Description = "";
}
