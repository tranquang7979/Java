package Models;

public class CourseViewModel {

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTeacher() {
		return Teacher;
	}

	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	public String Name = "";
	public String Teacher = "";
	
	 @Override
	  public String toString() {
	    return Name;
	  }
}
