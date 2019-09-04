package activity15;

import java.util.*;

public class CollectionsDemo {

	public void ArrayListDemo(){
		ArrayList<Float> col=new ArrayList<Float>();
		
		//them phan tu
		
		col.add(3.5f); //vi tri 0
		col.add(4.0f); // vi  tri 1
		col.add(3.0f); //vi tri 2
		
		//so luong phan tu
		
		System.out.println("n= "+col.size());
		
		//lay phan tu o vi tri bat ky
		System.out.println("at position 0: "+ col.get(0));
		
		//in het
		System.out.println("=====FOR WITH INDEX===========");
		//cach 1
		for(int index=0;index<col.size();index++){
			System.out.println(col.get(index));
			
		}
		
		//cach 2
		System.out.println("=====FOREACH===========");
		for(Float f: col){
			System.out.println(f);
			
		}
		
		
		
	}
	
	public void ArrayListDemo2(){
		
		ArrayList <Student> col1=new ArrayList<Student>();
		Student s1= new Student();
		s1.setId("01");
		s1.setAddress("1234");
		s1.setName("an");
		
		col1.add(s1);
		
		Student s2= new Student();
		s2.setId("02");
		s2.setAddress("3456");
		s2.setName("vy");
		col1.add(s2);
		
		//xoa sv 2
		col1.remove(1);
		
		//xoa sach
		col1.clear();
		
		for(Student std1: col1 ){
			System.out.println("Address = " + std1.getAddress());
			System.out.println("Name = " + std1.getName());
			System.out.println("ID = " + std1.getId());
		}
		
		
		
		
	}
	
	public void VectorDemo(){
		
		Vector<Integer> vec =new Vector<Integer>();
		//them phan tu
		vec.add(1);
		vec.add(5);
		vec.add(12);
		vec.add(0);
		
		System.out.println("so pahn tu" +vec.size());
		
		System.out.println("===List===");
		for(Integer i : vec){
			System.out.println(i);
			
		}
		
		System.out.println("===Remove element with value 12===");
		
		vec.remove(2);
		
		System.out.println("===After remove ===");
		for(Integer i : vec){
			System.out.println(i);
			
		}
		
		System.out.println("===remove all===");
		vec.clear();
		
		System.out.println("=== after clear ==");
		System.out.println(vec.size());
		
		
	}
	
	
	/*Map*/
	
	public void HashMapDemo(){
		
		
		//tao doi tuong cua HashMap
		
		HashMap<String, Integer> hash1 =new HashMap<String, Integer>();
		
		// them phan tu
		
		hash1.put("k1", 1);
		hash1.put("k2", 23);
		hash1.put("k3", 55);
		hash1.put("k2", 52225);
		
		System.out.println("n: " + hash1.size());
		
		//in danh sach
		System.out.println("=========Values========");
		for(Integer i :  hash1.values()){
			
			System.out.println(i);
		}
		
		
		//in danh sach key
		
		System.out.println("=========Keys=========");
		
		for(String s:  hash1.keySet()){
			
			System.out.println(s + " - " + hash1.get(s));
		}
		
		
		System.out.println("====== get object at key k2=============");
		
		//lay gia tri cua phan tu co key k2
		System.out.println(hash1.get("k2"));
		
		// xoa phan tu dua theo key k1
		System.out.println("======After remove k1=====");
		hash1.remove("k1");
		//in danh sach
		
				for(Integer i :  hash1.values()){
					
					System.out.println(i);
				}
		
		
		
	}
	
	public void HashMapDemo2(){
		
		
		HashMap<String, Student> map =new HashMap<String,Student>();
		
		Student s1=new Student();
		s1.setId("3");
		s1.setName("An");
		s1.setAddress("123");
		
		Student s2=new Student();
		s2.setId("1");
		s2.setName("Binh");
		s2.setAddress("235345");
		
		Student s3=new Student();
		s3.setId("2");
		s3.setName("Tao");
		s3.setAddress("235345");
		
		
		map.put(s1.getId(), s1);
		map.put(s2.getId(), s2);
		map.put(s3.getId(), s3);
		
		
		System.out.println("======List student=====");
		
		for(String s:  map.keySet()){
			
			System.out.println(s + "-" + map.get(s).getName());
		}
			
	}
	
    public void HashTableDemo(){
		
    	
    	Hashtable<Integer, String> map =new Hashtable<Integer, String>();
    	
		
    	map.put(1, "Apple");
    	map.put(2, "Dragon fruit");
    	map.put(3, "Lemon");
    	map.put(11, "Banana");
    	
    	//map.put(12, null); //error
    	
    	
       for(Integer i:  map.keySet()){
			
			System.out.println(i + "-" + map.get(i));
		}
	
			
	}
    
     public void TreeMapDemo(){
		
    	
    	TreeMap<Integer, String> map =new TreeMap<Integer, String>();
    	
		
    	map.put(1, "Apple");
    	map.put(2, "Dragon fruit");
    	map.put(3, "Lemon");
    	map.put(11, "Banana");
    	
    	//map.put(12, null); //error
    	
    	
       for(Integer i:  map.keySet()){
			
			System.out.println(i + "-" + map.get(i));
		}
	
			
	}
	
     /*Stack = LIFO*/
     
     public void StackDemo(){
    	 
    	 Stack<String> stack =new Stack<String>();
    	 //them phan tu
    	 stack.push("A");
    	 stack.push("B");
    	 stack.push("C");
    	 stack.push("D");
    	 
    	 // lay phan tu
    	 
    	 System.out.println(stack.pop());  //D
    	 System.out.println(stack.pop());  //C
    	 System.out.println(stack.pop());  //B
    	 System.out.println(stack.pop());  //A
    	 System.out.println(stack.pop());  //runtime exception
     }
     
     
     /*Queue = FIFO*/
       
     public void QueueDemo(){
  
    	 ArrayDeque<String> queue =new ArrayDeque<String>();
    	 //them phan tu vao cuoi danh sach
    	 queue.add("A");
    	 queue.add("B");
    	 queue.add("C");
    	 queue.add("D");
    	 queue.add("E");
    	 
    	 // lay phan tu o dau danh sach
    	System.out.println(queue.removeFirst());
    	System.out.println(queue.removeFirst());
    	System.out.println(queue.removeFirst()); 
    	 
     }
     
     /**/
     
     public void compareInCollection(){
    	 
    	 Student s1=new Student();
    	 s1.setId("R1");
    	 s1.setName("A");
    	 s1.setGPA(80);
    	 
    	 
    	 Student s2=new Student();
    	 s2.setId("R2");
    	 s2.setName("B");
    	 s2.setGPA(70);
    	 
    	 
    	 Student s3=new Student();
    	 s3.setId("R3");
    	 s3.setName("C");
    	 s3.setGPA(95);
    	 
    	 
    	 ArrayList<Student> lst =new ArrayList<Student>();
    	 lst.add(s1);
    	 lst.add(s2);
    	 lst.add(s3);
    	 
    	 //in danh sach
    	 System.out.println("======Student List=====");
    	 for(Student s : lst){
    		 
    		 System.out.println(s.getId()+" : " + s.getName() + " : "+s.getGPA());
     	 }
    	 
    	 
    	 // in danh sach co thu tu
     	 Collections.sort(lst);
     	 
    	 System.out.println("======Student List sorted  by GPA=====");
    	 
    	 ListIterator<Student> ds= lst.listIterator();
    	 while(ds.hasNext()){
    		 
    		 Student std= ds.next();
    		 System.out.println(std.getId()+" : " + std.getName() + " : "+std.getGPA());
     	 }
    	 
    	 
    	 
     }
     
	public static void main(String[] args) {
		
		CollectionsDemo c=new CollectionsDemo();
	    c.compareInCollection();

	}

}
