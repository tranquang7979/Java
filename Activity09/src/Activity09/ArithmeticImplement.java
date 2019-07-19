package Activity09;

public abstract class ArithmeticImplement implements IOperators {
	@Override
	public float add(float a, float b) {
		return a + b;
	}

	@Override
	public float sub(float a, float b) {
		return a-b;
	}

	@Override
	public float divide(float a, float b) {
		if(b == 0) return 0;
		return a/b;
	}

	@Override
	public float multi(float a, float b) {
		return a*b;
	}

	@Override
	public float mod(float a, float b) {
		float result = a%b;
		return result;
	}

}
