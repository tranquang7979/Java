package Activity16;

import java.sql.*;

public class Demo1 {

	public void insert() {
		Connection con = null;
		Statement st = null;

		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = "insert [dbo].[Category] ([Name],[description]) values (N'Văn phòng phẩm',N'no desc..')";
			st = con.createStatement();
			int res = st.executeUpdate(sql);
			if (res > 0) {
				System.out.println("insert success");
			} else {
				System.out.println("insert fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update() {
		Connection con = null;
		Statement st = null;

		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = "update Category set Name='English', [description] = 'no desc' where id = 1";
			st = con.createStatement();
			int res = st.executeUpdate(sql);
			if (res > 0) {
				System.out.println("update success");
			} else {
				System.out.println("update fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		Connection con = null;
		Statement st = null;
		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = "delete Category where id=1";
			st = con.createStatement();
			int res = st.executeUpdate(sql);
			if (res > 0) {
				System.out.println("delete success");
			} else {
				System.out.println("delete fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void select() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = "select * from category";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			System.out.println("======List categories======");
			while (rs.next()) {
				int id = rs.getInt("id");
				String Name = rs.getNString("Name");
				String desc = rs.getNString("description");

				System.out.println(id + " | " + Name + " | " + desc);
			}
			rs.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void callProc_select() {
		Connection con = null;
		CallableStatement st = null;
		ResultSet rs = null;
		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = "prc_countItems";
			st = con.prepareCall(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				int count = rs.getInt(1);
				System.out.println("Total Items: " + count);
			}
			rs.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void callProc_insert() {
		Connection con = null;
		CallableStatement st = null;

		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = "{ call prc_insertCategory(?,?,?) }";
			st = con.prepareCall(sql);
			// pass IN parameters
			st.setString(1, "Category 2");
			st.setString(2, "This is category 2");
			// register OUT parameters
			st.registerOutParameter(3, Types.INTEGER);

			st.execute();

			// retrieve OUTPUT
			int newId = st.getInt(3);
			System.out.println("New item id: " + newId);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void callProc_insert_inline() {
		Connection con = null;
		PreparedStatement st = null;

		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = "insert into Category values (?,?)";
			st = con.prepareStatement(sql);
			// pass IN parameters
			st.setString(1, "Category 2");
			st.setString(2, "This is category 2");

			int res = st.executeUpdate();
			if (res > 0)
				System.out.println("success");
			else
				System.out.println("fail");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void callProc_insert_inline_multi() {
		Connection con = null;
		PreparedStatement st = null;

		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = "insert into Category values (?,?)";
			
			con.setAutoCommit(false);
			
			st = con.prepareStatement(sql);
			// pass IN parameters
			for(int i = 0; i < 10; i++)
			{
				st.setString(1, "New Category " + i);
				st.setString(2, "This is category " + i);
				st.addBatch();
			}
			int[] res = st.executeBatch();
			
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public static void main(String[] args) {

		Demo1 d = new Demo1();
		d.callProc_insert_inline_multi();

	}

}
