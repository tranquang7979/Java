package Models;

import java.util.Date;

public class LaborContract extends BaseModel {
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Boolean getForever() {
		return Forever;
	}
	public void setForever(Boolean forever) {
		Forever = forever;
	}
	public String EmployeeId = "";
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String Title = "";
	public Boolean Forever = false;
}
