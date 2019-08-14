package Activity14;

import Activity14.Model.Account;

public class Login {
	
	static private String username = "";
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	static private String password = "";
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	class ValidateInnerClass
	{
		public Boolean checkUsername() 
		{
			if(username.trim().length() != 0)
			{
				System.out.println("valid");
				return true;
			}
			else
			{
				System.out.println("Invalid");
				return false;
			}
		}

		public Boolean checkPassword() 
		{
			if(password.trim().length() >= 6)
			{
				System.out.println("valid");
				return true;
			}
			else
			{
				System.out.println("Invalid");
				return false;
			}
		}
		
		public Boolean checkExistUser()
		{
			FileReaderCustom frc = new FileReaderCustom();
			Account acc = frc.GetAccountByUsername(username);
			return acc != null && acc.Username.length() > 0; 
		}
	}

	static class ValidateStaticInnerClass
	{
		public Boolean checkUsername() 
		{
			if(username.trim().length() != 0)
			{
				System.out.println("valid");
				return true;
			}
			else
			{
				System.out.println("Invalid");
				return false;
			}
		}

		public Boolean checkPassword() 
		{
			if(password.trim().length() >= 6)
			{
				System.out.println("valid");
				return true;
			}
			else
			{
				System.out.println("Invalid");
				return false;
			}
		}

		public Boolean checkExistUser(String username)
		{
			FileReaderCustom frc = new FileReaderCustom();
			Account acc = frc.GetAccountByUsername(username);
			return acc != null && acc.Username.length() > 0; 
		}
	}
}
