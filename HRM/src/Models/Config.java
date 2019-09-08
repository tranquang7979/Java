package Models;

public class Config
{
	public SqlInformation SqlDatabase = null;
	public SqlInformation getSqlDatabase() {
		return SqlDatabase;
	}
	public void setSqlDatabase(SqlInformation sqlDatabase) {
		SqlDatabase = sqlDatabase;
	}
	public class SqlInformation
	{
		public String Connection ="";
		public String getConnection() {
			return Connection;
		}
		public void setConnection(String connection) {
			Connection = connection;
		}
		public String getUsername() {
			return Username;
		}
		public void setUsername(String username) {
			Username = username;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String Username ="";
		public String Password ="";
	}
}

