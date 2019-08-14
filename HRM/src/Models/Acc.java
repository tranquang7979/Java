package Models;

import java.util.Date;

public class Acc {
	public int AccId = 0;
	public String Username = "";
	public String Password = "";
	public int CreatorAccId = 0;
	public Boolean Active = false;
	public Boolean Del = false;
	public Date CreateDate = new Date();
	public Date ActiveDate = new Date();
	public Date DelDate = new Date();
}
