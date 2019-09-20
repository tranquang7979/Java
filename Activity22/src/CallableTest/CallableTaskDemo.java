package CallableTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTaskDemo {
	public static void main(String a[]) {
		CallableTask task1 = new CallableTask("Task1");
		CallableTask task2 = new CallableTask("Task2");
		CallableTask task3 = new CallableTask("Task3");
		ExecutorService threadexecutorPool1 = Executors.newFixedThreadPool(3);
		ExecutorService threadexecutorPool2 = Executors.newFixedThreadPool(3);
		Future<String> f1 = threadexecutorPool1.submit(task1);
		Future<String> f2 = threadexecutorPool2.submit(task2);
		Future<String> f3 = threadexecutorPool2.submit(task3);

	}
}
