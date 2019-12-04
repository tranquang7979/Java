package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GeneralDAO {

	String dbuser = "sa";
	String dbpassword = "1";
	String url = "jdbc:sqlserver://localhost;databaseName=ITViet";

	public GeneralDAO() {
	}

	public GeneralDAO(String dbuser, String dbpassword, String url) {
		this.dbuser = dbuser;
		this.dbpassword = dbpassword;
		this.url = url;
	}

	public ResultSet execSELECT(String sql) {

		try {
			// 1.load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// 2. Tao connection
			Connection con = DriverManager.getConnection(url, dbuser, dbpassword);

			// 3. statement
			Statement st = con.createStatement();

			// 5. execute
			ResultSet rs = st.executeQuery(sql);

			//con.close();

			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String execINSERT_UPDATE_DELETE(String sql) {

		try {
			// 1.load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// 2. Tao connection
			Connection con = DriverManager.getConnection(url, dbuser, dbpassword);

			// 3. statement
			Statement st = con.createStatement();
			
			int i = st.executeUpdate(sql);
			if(i <= 0)
				return "Error";

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "";
	}

}
