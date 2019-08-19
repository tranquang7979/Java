package Models;

import java.util.Date;

public class Role extends BaseModel {
	public String Title = "";
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getCreatorAccId() {
		return CreatorAccId;
	}
	public void setCreatorAccId(String creatorAccId) {
		CreatorAccId = creatorAccId;
	}
	public String CreatorAccId = "";
}
