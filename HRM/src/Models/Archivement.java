package Models;

public class Archivement extends BaseModel {
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Boolean getReward() {
		return Reward;
	}
	public void setReward(Boolean reward) {
		Reward = reward;
	}
	public String EmployeeId = "";
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String Title = "";
	public String Description = "";
	public Boolean Reward = false;
}
