package Activity19;

public class BankThread_withdrawal implements Runnable {
	CustomerAccount acc;
	
	public BankThread_withdrawal(CustomerAccount acc) {
		this.acc = acc;
	}

	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			acc.withdraw(300);
		}		
	}

}
