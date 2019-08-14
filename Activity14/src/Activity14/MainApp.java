package Activity14;

public class MainApp {
	
	public static void main(String[] args) {
		Login obj = new Login();
		obj.setUsername("");
		obj.setPassword("");
		
		Login.ValidateInnerClass v = obj.new ValidateInnerClass();
		v.checkUsername();
		v.checkPassword();
	}
	
}
