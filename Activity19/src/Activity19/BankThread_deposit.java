package Activity19;

public class BankThread_deposit implements Runnable {
	CustomerAccount acc;
	public BankThread_deposit(CustomerAccount acc) {
		this.acc = acc;
	}

	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			acc.deposit(600);
		}		
	}

}
