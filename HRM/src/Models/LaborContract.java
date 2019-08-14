package Models;

import java.util.Date;

public class LaborContract {
	public int LaborContractId = 0;
	public int getLaborContractId() {
		return LaborContractId;
	}
	public void setLaborContractId(int laborContractId) {
		LaborContractId = laborContractId;
	}
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
	public int EmployeeId = 0;
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String Title = "";
	public Boolean Forever = false;
	public Boolean Active = false;
	public Boolean Del = false;
	public Date CreateDate = new Date();
	public Date ActiveDate = new Date();
	public Date DelDate = new Date();
}
