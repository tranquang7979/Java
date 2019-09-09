package Activity18;

public class ChildThread_Runnable implements Runnable {
	public void task() {
		for (int i = 1; i < 50; i++) {
			System.out.println("T2 (Runnable) --> " + i);

			try {
				Thread.sleep(300); // 5 seconds
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		task();
	}
}
