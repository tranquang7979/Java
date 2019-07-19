package Activity09;

public class MainApp {
	public static void main(String[] args) {
		float a = 0;
		float b = 0;
		
		OperatorsImplement oi = new OperatorsImplement();
		
		a = 7;
		b = 5;
		System.out.printf("%f + %f = %f \n", a, b, oi.add(a, b));

		a = 7;
		b = 5;
		System.out.printf("%f - %f = %f \n", a, b, oi.sub(a, b));

		a = 7;
		b = 5;
		System.out.printf("%f / %f = %f \n", a, b, oi.divide(a, b));

		a = 7;
		b = 5;
		System.out.printf("%f * %f = %f \n", a, b, oi.multi(a, b));

		a = 7;
		b = 5;
		System.out.printf("%f mod %f = %f \n", a, b, oi.mod(a, b));

		a = 7;
		b = 5;
		System.out.printf("%f += %f => %f \n", a, b, oi.assginAdd(a, b));

		a = 7;
		b = 5;
		System.out.printf("%f -= %f => %f \n", a, b, oi.assginSub(a, b));

		a = 7;
		b = 5;
		System.out.printf("%f /= %f => %f \n", a, b, oi.assginDivide(a, b));

		a = 7;
		b = 5;
		System.out.printf("%f mod= %f => %f \n", a, b, oi.assginMod(a, b));
		
		oi.and();
		
		oi.or();
		
		oi.increment(6);
		oi.decrement(10);
	}
}
