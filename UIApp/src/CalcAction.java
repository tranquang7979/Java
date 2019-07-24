
public class CalcAction implements ICalcAction {

	@Override
	public float sum(float a, float b) {
		return a + b;
	}

	@Override
	public float sub(float a, float b) {
		return a-b;
	}

	@Override
	public float mul(float a, float b) {
		return a * b;
	}

	@Override
	public float div(float a, float b) {
		try
		{
			return a / b;
		}
		catch(Exception ex) 
		{
			return 0;
		}
	}

}
