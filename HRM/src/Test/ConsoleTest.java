package Test;

import com.google.gson.Gson;

import Business.AccountRepository;
import Helper.FileAccess;
import Models.Acc;
import Models.Config;
import Utilities.FileHelper;

public class ConsoleTest {

	public static void main(String[] args) {

		
		Gson gson = new Gson();
		
		String filePath = "D:\\Test\\Eclipse\\Java\\HRM\\src\\resources\\config.json";
		String jsonConfig = new FileAccess().read(filePath);
		Config config = gson.fromJson(jsonConfig, Config.class);
		
		AccountRepository acc = new AccountRepository(gson);
		
		
		Acc newAcc = new Acc();
		newAcc.setId("1");
		newAcc.setActive(true);
		
		String sqlCreate = "";
		acc.Create(newAcc, sqlCreate);
		
		//a.setPassword("123456");
		//acc.Update(a);
		
		//System.out.println(a.getId());
	}

}
