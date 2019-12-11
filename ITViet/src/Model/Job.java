package Model;

import java.sql.Date;

public class Job {
	private int Id, CompanyId;
	private String Title, ShortDescription;
	private boolean IsHotJob;
	private Date CreateDate;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getShortDescription() {
		return ShortDescription;
	}
	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}
	public boolean getIsHotJob() {
		return IsHotJob;
	}
	public void setIsHotJob(boolean isHotJob) {
		IsHotJob = isHotJob;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
}
