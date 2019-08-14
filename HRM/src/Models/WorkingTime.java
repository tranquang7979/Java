package Models;

import java.util.Date;

import Constant.WeekDay;

public class WorkingTime {
	public int WorkingTimeId = 0;
	public int getWorkingTimeId() {
		return WorkingTimeId;
	}
	public void setWorkingTimeId(int workingTimeId) {
		WorkingTimeId = workingTimeId;
	}
	public WeekDay Day = WeekDay.Monday;
	public WeekDay getDay() {
		return Day;
	}
	public void setDay(WeekDay day) {
		Day = day;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
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
	public Date getDelDate() {
		return DelDate;
	}
	public void setDelDate(Date delDate) {
		DelDate = delDate;
	}
	public Date StartTime = new Date();
	public Date EndTime = new Date();
	public Boolean Del = false;
	public Date CreateDate = new Date();
	public Date DelDate = new Date(); 
}
