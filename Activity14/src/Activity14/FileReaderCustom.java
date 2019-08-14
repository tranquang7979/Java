package Activity14;

import java.io.BufferedReader;
import java.io.FileReader;

import Activity14.Model.Account;

public class FileReaderCustom {
	private String fileName = "accounts.txt";

	public Account[] GetAllAccount() {
		try {
			Account[] result;
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			
			int count = 0;
			while ((line = br.readLine()) != null) {
				count++;
			}

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			result = new Account[count];
			count = 0;
			while ((line = br.readLine()) != null) {				
				String[] items = line.split("#!");
				Account acc = new Account();
				acc.setUsername(items[0]);
				acc.setUsername(items[1]);
				result[count] = acc;
				count++;
			}

			br.close();
			fr.close();
			
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Account GetAccountByUsername(String username) {
		try {
			Account acc = new Account();
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while ((line = br.readLine()) != null) {				
				String[] items = line.split("#!");
				if(!username.equalsIgnoreCase(items[0])) continue;
				acc.setUsername(items[0]);
				acc.setUsername(items[1]);
				break;
			}

			br.close();
			fr.close();
			
			return acc;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


}
