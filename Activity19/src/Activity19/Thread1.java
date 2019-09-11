package Activity19;

public class Thread1 extends Thread {
	
	private Task task;
	
	public Thread1(Task task)
	{
		this.task = task;
		this.task.name =  "T1";
	}
	
	public void run() {
		//task.print();
		task.display("T1");
	}
	
}
