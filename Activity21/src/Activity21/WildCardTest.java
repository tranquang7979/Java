package Activity21;

public class WildCardTest {
	
	public void vd1() {
		WildCard<Integer> i = new WildCard<Integer>();		
		i.setVar(12);
		
		WildCard<String> s = new WildCard<String>();
		s.setVar("12");
		
		WildCard<Integer> j = new WildCard<Integer>();
		j.setVar(12);

		WildCard<Float> k = new WildCard<Float>();
		k.setVar(12.0f);
				
		//i.isEqualNumber(s); // error
		i.isEqualNumber(j); // OK
		i.isEqualNumber(k); // OK because Float is child of Integer
	}
	
	public static void main(String args) {
		WildCardTest wct = new WildCardTest();
		wct.vd1();
	}

}
