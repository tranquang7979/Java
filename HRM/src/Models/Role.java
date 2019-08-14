package Models;

import java.util.Date;

public class Role {
	public int RoleId = 0;
	public String Title = "";
	public int CreatorAccId = 0;
	public Boolean Active = false;
	public Boolean Del = false;
	public Date CreateDate = new Date();
	public Date ActiveDate = new Date();
	public Date DelDate = new Date();
}
