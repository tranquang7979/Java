package UpDownCasting;

public class TestUpDownCasting {

	public static void main(String[] args) {
		
		Bird b = new Bird();
		b.Description();
		b.canFly();
		
		
		// UP CASTING
		Animal b1 = new Bird();
		b1.Description();
		//b1.canFly(); // error
		
		
		// DOWN CASTING
		Bird b2 = (Bird)b1;
		b2.Description();
		b2.canFly();
		
	}

}
