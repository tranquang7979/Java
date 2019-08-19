package Models;

public class Acc extends BaseModel {
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCreatorAccId() {
		return CreatorAccId;
	}
	public void setCreatorAccId(String creatorAccId) {
		CreatorAccId = creatorAccId;
	}
	public String Username = "";
	public String Password = "";
	public String CreatorAccId = "";
}
