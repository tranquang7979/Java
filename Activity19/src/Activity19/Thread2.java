package Activity19;

public class Thread2 extends Thread {
	
	private Task task;
	
	public Thread2(Task task)
	{
		this.task = task;
		this.task.name =  "T2";
	}
	
	public void run() {
		//task.print();
		task.display("T2");
	}
	
}
