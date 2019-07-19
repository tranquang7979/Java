package Activity09;

public class OperatorsImplement extends ArithmeticImplement {

	@Override
	public float assginAdd(float a, float b) {
		a+=b;
		return a; 
	}

	@Override
	public float assginSub(float a, float b) {
		a-=b;
		return a;
	}

	@Override
	public float assginDivide(float a, float b) {
		if(b == 0) return 0;
		a/=b;
		return a;
	}

	@Override
	public float assginMod(float a, float b) {
		a%=b;
		return a;
	}

	@Override
	public void and() {
		int m1 = 45;
		int m2 = 78;
		
		if(m1>=45 && m2>=45)
			System.out.println("pass semester");
		else
			System.out.println("fail semester");
	}

	@Override
	public void or() {
		int m1 = 42;
		int m2 = 78;
		
		if(m1>=45 || m2>=45)
			System.out.println("pass semester");
		else
			System.out.println("fail semester");
	}

	@Override
	public int increment(int i) {
		System.out.printf("i++ %d \n", i++); // postfix
		System.out.printf("i++ %d \n", ++i); // prefix
		return i;
	}

	@Override
	public int decrement(int i) {
		System.out.printf("i++ %d \n", i--); // postfix
		System.out.printf("i++ %d \n", --i); // prefix
		return 0;
	}

}
