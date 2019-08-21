package Acitivity15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class CollectionDemo {
	
	public void ArrayListDemo()
	{
		ArrayList<Float> cols = new ArrayList<Float>();
		
		cols.add(3.5f);
		cols.add(4.5f);
		cols.add(5.5f);
		
		for(int i = 0; i < cols.size(); i++) 
		{
			System.out.println(cols.get(i));
		}
		
		System.out.println("---FOR EACH-----------");
		for(Float f : cols)
		{
			System.out.println(f);
		}
	}
	
	public void HashMapDemo()
	{
		HashMap<Integer, Student> h = new HashMap<Integer, Student>();

		h.put(2, new Student("S3", "Student 3", "Address"));
		h.put(3, new Student("S2", "Student 2", "Address"));
		h.put(1, new Student("S1", "Student 1", "Address"));
		
		System.out.println("Total Student: " + h.size());		
		System.out.println("Student S2: " + h.get(2).getName());
		System.out.println("--------------------------------------");
		
		for(int s : h.keySet())
		{
			System.out.println("Student "+ s +":" + h.get(s).getName());
		}
		
		h.remove(2);
		System.out.println("Total Student (after remove): " + h.size());
	}

	public void HashTableDemo()
	{
		Hashtable<Integer, Student> h = new Hashtable<Integer, Student>();

		h.put(2, new Student("S2", "Student 2", "Address"));
		h.put(3, new Student("S3", "Student 3", "Address"));
		h.put(1, new Student("S1", "Student 1", "Address"));
		
		System.out.println("Total Student: " + h.size());		
		System.out.println("Student 2: " + h.get(2).getName());
		System.out.println("--------------------------------------");
		
		for(int s : h.keySet())
		{
			System.out.println("Student "+ s +":" + h.get(s).getName());
		}
		
		h.remove(2);
		System.out.println("Total Student (after remove): " + h.size());
	}

	public void TreeMapDemo()
	{
		TreeMap<Integer, Student> h = new TreeMap<Integer, Student>();

		h.put(2, new Student("S2", "Student 2", "Address"));
		h.put(3, new Student("S3", "Student 3", "Address"));
		h.put(1, new Student("S1", "Student 1", "Address"));
		
		System.out.println("Total Student: " + h.size());		
		System.out.println("Student 2: " + h.get(2).getName());
		System.out.println("--------------------------------------");
		
		for(int s : h.keySet())
		{
			System.out.println("Student "+ s +":" + h.get(s).getName());
		}
		
		h.remove(2);
		System.out.println("Total Student (after remove): " + h.size());
	}
	
	public static void main(String[] args)
	{
		CollectionDemo cd = new CollectionDemo();
		//cd.ArrayListDemo();
		System.out.println("---Has Map-----------------------------------");
		cd.HashMapDemo();
		System.out.println("---Hash Table-----------------------------------");
		cd.HashTableDemo();
		System.out.println("---Tree Map-----------------------------------");
		cd.TreeMapDemo();
	}
}
