package Activity21;

public class WildCard<T> {
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
	// '? extends' -> T can be any type BUT it must be child of a Number
	public boolean isEqualNumber(WildCard<? extends Number> t) {
		return var == t.var;
	}
	
	// '? super' -> T can be any type BUT it must be parent of Float
	public boolean isEqualFloat(WildCard<? super Float> t) {
		boolean result = var == t.var;
		System.out.println(result);
		return result;
	}
}
