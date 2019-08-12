package Activity13;

import java.io.BufferedReader;
import java.io.FileReader;

import Models.CourseModel;
import Models.CourseViewModel;

public class FileReaderDemo {

	public static void main(String[] args) {
		FileReaderDemo d = new FileReaderDemo();
		d.GetAllCourse();
	}

	public void readData() {
		String fileName = "niit-courses.txt";
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String content = "";
			String line = "";

			while ((line = br.readLine()) != null) {
				content += line + "\n";
			}

			System.out.print(content);

			br.close();
			fr.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public CourseModel[] GetAllCourse() {
		String fileName = "niit-courses.txt";
		try {
			CourseModel[] result;
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String content = "";
			String line = "";
			
			int count = 0;
			while ((line = br.readLine()) != null) {
				count++;
			}

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			result = new CourseModel[count];
			count = 0;
			while ((line = br.readLine()) != null) {
				content += line + "\n";
				
				String[] items = line.split("#!");
				CourseModel course = new CourseModel();
				course.setName(items[0]);
				course.setDuration(items[1]);
				course.setTeacher(items[2]);
				course.setPrice(Float.parseFloat(items[3]));
				course.setRate(Float.parseFloat(items[4]));
				result[count] = course;
				count++;
			}

			System.out.print(content);

			br.close();
			fr.close();
			
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public CourseViewModel[] GetAllCourseForComboBox() {
		String fileName = "niit-courses.txt";
		try {
			CourseModel[] courses = GetAllCourse();
			CourseViewModel[] result = new CourseViewModel[courses.length];
			for(int i = 0; i < courses.length; i++) 
			{
				CourseModel course = courses[i];
				CourseViewModel cvm = new CourseViewModel();
				cvm.setName(course.getName());
				cvm.setTeacher(course.getTeacher());
				
				result[i] = cvm;
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


}
