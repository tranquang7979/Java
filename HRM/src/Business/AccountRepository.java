package Business;
import Models.Acc;

import com.google.gson.Gson;

public class AccountRepository extends Repositories<Acc, String> {

	public AccountRepository(Gson _gson) {
		super(Acc.class, _gson);
		// TODO Auto-generated constructor stub
	}

}
