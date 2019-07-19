package Activity09;

public interface IOperators {
	
	//<access modifier> <return type> <method name>(parameter1, parameter2)
	
	// arithmetic
	public float add(float a, float b);	
	public float sub(float a, float b);	
	public float divide(float a, float b);	
	public float multi(float a, float b);
	public float mod(float a, float b);

	// comparison
	public float assginAdd(float a, float b);
	public float assginSub(float a, float b);
	public float assginDivide(float a, float b);
	public float assginMod(float a, float b);
	
	// logic
	public void and();
	public void or();
	
	// unary
	public int increment(int i);
	public int decrement(int i);
}