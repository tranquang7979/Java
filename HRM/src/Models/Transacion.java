package Models;

import java.util.Date;

import Constant.TranStatus;
import Constant.TranType;

public class Transacion extends BaseModel {
	public String TransactionId = "";
	public String getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
	public TranType getType() {
		return Type;
	}
	public void setType(TranType type) {
		Type = type;
	}
	public TranStatus getStatus() {
		return Status;
	}
	public void setStatus(TranStatus status) {
		Status = status;
	}
	public Float getAmt() {
		return Amt;
	}
	public void setAmt(Float amt) {
		Amt = amt;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getAccId() {
		return AccId;
	}
	public void setAccId(String accId) {
		AccId = accId;
	}
	public TranType Type = TranType.Salary;
	public TranStatus Status = TranStatus.Pending;
	public Float Amt = 0f;
	public String Remark = "";
	public Date CreateDate = new Date();
	public String EmployeeId = "";
	public String AccId = "";	
}
