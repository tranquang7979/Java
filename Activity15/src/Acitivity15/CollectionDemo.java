package Acitivity15;

import java.util.ArrayList;

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
	
	public static void main(String[] args)
	{
		CollectionDemo cd = new CollectionDemo();
		cd.ArrayListDemo();
	}
}
