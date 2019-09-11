package Activity19;

public class Task {

	public String name;

	public Task(String name) {
		this.name = name;
	}

	// sync cấp độ phương thức
	public synchronized void print() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " -->" + i);

			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// sync cấp độ statement
	public void display(String name) {
		// share
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " share: " + i);

			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// not share
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(name + " NO share: " + i);

				try {
					Thread.sleep(300);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
