package Test;

import Business.AccountRepository;
import Business.IRepositories;
import Business.Repositories;
import Models.Acc;

public class ConsoleTest {

	public static void main(String[] args) {
		
		AccountRepository acc = new AccountRepository();
		
		
		Acc newAcc = new Acc();
		newAcc.setAccId(1);
		newAcc.setActive(true);
		
		Acc a = acc.Create(newAcc);
		
		System.out.println(a.getAccId());
	}

}
