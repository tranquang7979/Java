package Models;

import java.util.Date;

public class Allowance {
	public int getAllowanceId() {
		return AllowanceId;
	}
	public void setAllowanceId(int allowanceId) {
		AllowanceId = allowanceId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
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
	public int AllowanceId = 0;
	public String Title = "";
	public Boolean Active = false;
	public Boolean Del = false;
	public Date CreateDate = new Date();
	public Date ActiveDate = new Date();
	public Date DelDate = new Date(); 
}
