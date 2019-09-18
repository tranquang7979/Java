package Activity21;

public class DAOGeneric<T> {

	public void create(T t) {
		System.out.println("insert into db ...");
		
		String sql = "";
		if(t instanceof Employee) {
			sql = "insert into Employee values(?,?)";
			
			Employee e = (Employee)t;
			String name = e.getFullName();
			String address = e.getPhone();
			//..
		}
		else if (t instanceof Department) {
			//..
		}
	}

	public void update(T t) {
		System.out.println("update into db ...");
	}

	public void delete(T t) {
		System.out.println("delete into db ...");
	}

	public T select(T t) {
		System.out.println("select into db ...");
		return t;
	}
	
}
