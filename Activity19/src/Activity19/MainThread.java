package Activity19;

public class MainThread {
	
	public static void main(String[] args) {
		Task t = new Task("");
		
		System.out.println("Thread 1 created...");
		Thread1 t1 = new Thread1(t);
		
		System.out.println("Thread 2 created...");
		Thread2 t2 = new Thread2(t);
		
		t1.start();
		t2.start();
		
		System.out.println("Main thread --> end");
	}
}
