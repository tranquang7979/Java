package Models;

import java.util.Date;

import Constant.TranStatus;
import Constant.TranType;

public class Transacion {
	public int TransactionId = 0;
	public TranType Type = TranType.Salary;
	public TranStatus Status = TranStatus.Pending;
	public Float Amt = 0f;
	public String Remark = "";
	public Date CreateDate = new Date();
	public int EmployeeId = 0;
	public int AccId = 0;	
}
