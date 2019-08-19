package Test;

import com.google.gson.Gson;

import Business.AccountRepository;
import Models.Acc;
import Utilities.FileHelper;

public class ConsoleTest {

	public static void main(String[] args) {
		
		FileHelper file = new FileHelper();
		Gson gson = new Gson();
		AccountRepository acc = new AccountRepository(file, gson);
		
		
		Acc newAcc = new Acc();
		newAcc.setId("1");
		newAcc.setActive(true);
		
		Acc a = acc.Create(newAcc);
		
		a.setPassword("123456");
		acc.Update(a);
		
		System.out.println(a.getId());
	}

}
