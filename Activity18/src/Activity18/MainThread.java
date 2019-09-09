package Activity18;

public class MainThread {

	public static void main(String[] args) {
		MainThread mt = new MainThread();
		
		//mt.TestThread();
		mt.TestMultiThread_Runnable();
	}

	public void TestThread() {
		Thread t = Thread.currentThread();

		System.out.println("Name: " + t.getName());
		System.out.println("isAlive: " + t.isAlive());

		for (int i = 1; i <= 50; i++) {
			System.out.println("T1 --> " + i);

			try {
				Thread.sleep(1000); // 5 seconds
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("Finish");
	}

	public void TestMultiThread_Runnable() {
		Thread t = Thread.currentThread();

		System.out.println("Name: " + t.getName());
		System.out.println("isAlive: " + t.isAlive());

		// start child thread (Runnable)
		ChildThread_Runnable ctr = new ChildThread_Runnable();
		Thread t1 = new Thread(ctr);
		t1.start();
		//t1.run(); // this method is used for synchronize thread. In this case, Child Thread must finish first

		// start child thread (Thread)
		ChildThread_Thread ctt = new ChildThread_Thread();
		Thread t2 = new Thread(ctt);
		t2.start();
		
		// start current thread
		for (int i = 1; i <= 50; i++) {
			System.out.println("T1 (Main Thread) --> " + i);

			try {
				Thread.sleep(500); // 5 seconds
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("Finish");
	}

}
