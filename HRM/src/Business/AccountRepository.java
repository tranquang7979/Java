package Business;

import com.google.gson.Gson;

import Models.Acc;
import Utilities.FileHelper;

public class AccountRepository extends Repositories<Acc, String> {

	public AccountRepository(Gson _gson) {
		super(Acc.class, _gson);
		// TODO Auto-generated constructor stub
	}

}
