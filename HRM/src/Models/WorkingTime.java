package Models;

import java.util.Date;

import Constant.WeekDay;

public class WorkingTime extends BaseModel {
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
	public Date StartTime = new Date();
	public Date EndTime = new Date();
}
