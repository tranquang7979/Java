package Acitivity15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ListIterator;
import java.util.Stack;
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
	
	// LIFO: Last In First Out
	public void StackDemo() 
	{
		Stack<Student> stack = new Stack<Student>();
		stack.push(new Student("S2", "Student 2", "Address"));
		stack.push(new Student("S1", "Student 1", "Address"));
		stack.push(new Student("S3", "Student 3", "Address"));
		
		System.out.println(stack.pop().getName());
		System.out.println(stack.pop().getName());
		System.out.println(stack.pop().getName());
	}

	// FIFO: First In First Out
	public void QueueDemo() 
	{
		ArrayDeque<Student> stack = new ArrayDeque<Student>();
		stack.add(new Student("S2", "Student 2", "Address"));
		stack.add(new Student("S1", "Student 1", "Address"));
		stack.add(new Student("S3", "Student 3", "Address"));
		
		System.out.println(stack.getFirst().getName()); // only get top 1
		System.out.println(stack.getLast().getName()); // only get bottom 1
		System.out.println(stack.removeFirst().getName()); // get top 1 and delete item in queue
		System.out.println(stack.removeLast().getName()); // get bottom 1 and delete item in queue
	}
	
	/**/
	public void compareInCollection()
	{
		Student s1 = new Student("S2", "Student 2", "Address", 80);
		Student s2 = new Student("S1", "Student 1", "Address", 70);
		Student s3 = new Student("S3", "Student 3", "Address", 95);
		
		ArrayList<Student> arr = new ArrayList<Student>();
		arr.add(s1);
		arr.add(s2);
		arr.add(s3);
		
		for(Student s : arr)
		{
			System.out.println(s.getId() + " : " + s.getName() + " : " + s.getGPA());
		}

		/*Learn more: 
		 * SORT: Quick Sort, Bubble Sort, Merger Sort
		 * SEARCH: Binary search 
		 * */
		Collections.sort(arr);
		System.out.println("--- After sort -----------------------------------");
		ListIterator<Student> students = arr.listIterator();
		while(students.hasNext())
		{
			Student s = students.next();
			System.out.println(s.getId() + " : " + s.getName() + " : " + s.getGPA());
		}
	}
	
	public static void main(String[] args)
	{
		CollectionDemo cd = new CollectionDemo();
		System.out.println("---Compare collection-----------------------------------");
		cd.compareInCollection();
//		System.out.println("---Queue-----------------------------------");
//		cd.QueueDemo();
//		System.out.println("---Stack-----------------------------------");
//		cd.StackDemo();
//		System.out.println("---Array List-----------------------------------");
//		cd.ArrayListDemo();
//		System.out.println("---Has Map-----------------------------------");
//		cd.HashMapDemo();
//		System.out.println("---Hash Table-----------------------------------");
//		cd.HashTableDemo();
//		System.out.println("---Tree Map-----------------------------------");
//		cd.TreeMapDemo();
	}
}
