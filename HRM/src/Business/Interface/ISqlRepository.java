package Business.Interface;

public interface ISqlRepository<T> {
	
	boolean Execute(T cls, String sqlStatement);
}
