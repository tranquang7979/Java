package Models;

import java.util.Date;

public class BaseModel {
	private String Id = "";
	public Boolean Active = false;
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

	public Boolean Del = false;
	public Date CreateDate = new Date();
	public Date ActiveDate = new Date();
	public Date DelDate = new Date();

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
}
