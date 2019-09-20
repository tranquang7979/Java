package CallableTest;

import java.util.concurrent.Callable;

public class CallableTask implements Callable {

	String taskname;

	public CallableTask(String name) {
		taskname = name;
	}

	public String call() {
		System.out.println("The task name is " + taskname + " executed by " + Thread.currentThread().getName());
		return taskname;
	}
}
