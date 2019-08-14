package Activity14;

public class Counter {
	public int count =0;
	public static int staticCount = 0;
	
	public void inc()
	{
		count++;
		staticCount++;
		
		System.out.println("count= " + count);
		System.out.println("staticCount= " + staticCount);
	}
	
	public static void main(String[] args)
	{
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		
		c1.inc();
		c2.inc();
		c3.inc();
	}
}
