package activity15;

public class Student  implements Comparable<Student>{

	private String id;
	private String name;
	private String address;
	private int GPA;
	
	
	public int getGPA() {
		return GPA;
	}
	public void setGPA(int gPA) {
		GPA = gPA;
	}
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
	
	
	@Override
	public int compareTo(Student s) {
		System.out.println("compareTo: " + s.getId());
		// 0 co nghia la hai doi tuong bang nhau
		//<0 co nghia la doi tuong 1 nho hon doi tuong 2
		//> 0 co nghia la doi tuong 1 lon hon doi tuong 2
		
		if(getGPA() == s.getGPA()){
			return 0;
		}
		else if(getGPA() < s.getGPA()){
			return -1;
		}else 
			return 1;
	}
	
	
	
	
	
	
}
