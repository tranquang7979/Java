package Activity19;

public class BankTransactionThread {

	public static void main(String[] args) {
		
		CustomerAccount acc = new CustomerAccount();
		acc.setBalance(900);
		
		BankThread_deposit depositThread = new BankThread_deposit(acc);
		BankThread_withdrawal withdrawalThread = new BankThread_withdrawal(acc);
		
		Thread tW = new Thread(withdrawalThread);
		Thread tD = new Thread(depositThread);

		tW.start();
		tD.start();
		
	}

}
