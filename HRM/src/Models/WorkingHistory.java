package Models;

import java.util.Date;

public class WorkingHistory {
	public int WorkingHistoryId = 0;
	public int getWorkingHistoryId() {
		return WorkingHistoryId;
	}
	public void setWorkingHistoryId(int workingHistoryId) {
		WorkingHistoryId = workingHistoryId;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int EmployeeId = 0;
	public Date FromDate = new Date();
	public Date ToDate = new Date();
	public int OccupationId = 0;
	public int DepartmentId = 0;
	public String Description = "";
	public Boolean Del = false;
	public Boolean getDel() {
		return Del;
	}
	public void setDel(Boolean del) {
		Del = del;
	}
	public Date getDelDate() {
		return DelDate;
	}
	public void setDelDate(Date delDate) {
		DelDate = delDate;
	}
	public Date DelDate = new Date();
}
