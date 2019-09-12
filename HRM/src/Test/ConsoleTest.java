package Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

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
		newAcc.setId(UUID.randomUUID().toString());
		newAcc.setUsername("User1");
		newAcc.setPassword("123456");
		newAcc.setCreatorAccId("");		
		newAcc.setActive(true);
		newAcc.setDel(false);
		newAcc.setCreateDate(new Date());
		newAcc.setActiveDate(new Date());
		newAcc.setDelDate(new Date());
		
		//String sqlCreate = "INSERT INTO [dbo].[Acc] VALUES (?,?,?,?,?,?,?,?,?)";
		//String sqlCreate = "INSERT INTO [dbo].[Acc] VALUES (p0,p1,p2,p3,p4,p5,p6,p7,p8)";
		
		try {
			acc.Create(newAcc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//a.setPassword("123456");
		//acc.Update(a);
		
		//System.out.println(a.getId());
	}

}
