package AnonymousInterface;

public class Account {
	
	public void LoginAccount() 
	{
		// this guide how to init an anonymous interface 
		IAccount acc = new IAccount() {
			
			@Override
			public void Login() {
				// TODO Auto-generated method stub
				
			}
		};
		
		acc.Login();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
