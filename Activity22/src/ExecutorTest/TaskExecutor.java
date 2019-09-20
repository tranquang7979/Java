package ExecutorTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskExecutor {
	public static void main(String a[]) {
		Task task1 = new Task("Task1");
		Task task2 = new Task("Task2");
		Task task3 = new Task("Task3");
		ExecutorService threadexecutor = Executors.newCachedThreadPool();
		System.out.println("Executor started");
		threadexecutor.execute(task1);
		threadexecutor.execute(task2);
		threadexecutor.execute(task3);
		threadexecutor.shutdown();
		if (threadexecutor.isShutdown()) {
			System.out.println("All tasks completed. The executor is shutting down.");
		}
	}
}
