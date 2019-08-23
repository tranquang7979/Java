package Acitivity15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Student implements Comparable<Student> {
	
	public Student() {}
	public Student(String id, String name, String address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Student(String id, String name, String address, int gpa)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.GPA = gpa;
	}
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String name;
	private String address;
	private int GPA;
	
	public int getGPA() {
		return GPA;
	}
	public void setGPA(int gPA) {
		GPA = gPA;
	}
	// tự cấp phát vùng nhớ liền nhau => phù hợp cho quá trình ĐỌC dữ liệu
	public void ArrayListDemo()
	{
		ArrayList<Student> arr = new ArrayList<Student>();
		
		Student newStudent = new Student();
		newStudent.setId("1");
		newStudent.setName("Student 1");
		newStudent.setAddress("123 Nguyen Trai");
		arr.add(newStudent);
	}
	
	// lock vùng nhớ cho đến khi vùng nhớ được giải phóng => phù hợp cho quá trình GHI dữ liệu
	public void VectorDemo() {
		Vector<Integer> v = new Vector<Integer>();
		v.add(1);// add number 1
		v.get(0);// return 1
		v.clear();// clear all data
	}
	
	// tự cấp phát vùng nhớ rãi rác => tối ưu vùng nhớ => phù hợp cho quá trình ĐỌC dữ liệu
	public void LinkedListDemo()
	{
		LinkedList<Integer> link = new LinkedList<Integer>();
	}
	
	public static void main(String[] args)
	{
		
	}
	@Override
	public int compareTo(Student s) {
		
		// =0: 2 object is the same
		if(getGPA() == s.getGPA())
		{
			System.out.println("Compare to " + s.getId() + " => 0");
			return 0;
		}
		
		// <0: object 1 < object 2
		if(getGPA() < s.getGPA())
		{
			System.out.println("Compare to " + s.getId() + " => -1");
			return -1;
		}
		// >0: object 1 > object 2
		System.out.println("Compare to " + s.getId() + " => 1");
		return 1;
	}
}
