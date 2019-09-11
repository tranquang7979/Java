package Activity19;

public class CustomerAccount {
	private int balance;

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public synchronized void withdraw(int amount) {
		System.out.println("Balance before withdrawal: " + balance);

		if (balance - amount <= 0) {
			System.out.println("Balance is sufficient.");
			
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		balance = balance - amount;
		System.out.println("Balance after withdrawal: " + balance);
	}

	public synchronized void deposit(int amount) {
		System.out.println("Balance before deposit: " + balance);
		balance = balance + amount;
		System.out.println("Balance after deposit: " + balance);
		
		notifyAll();
	}
}
