package Activity17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Models.BookViewModel;

public class MyDBHelper {
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

	public Vector<BookViewModel> query(String command) {
		Vector<BookViewModel> model = new Vector<BookViewModel>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			// 1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. get connection
			con = DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB", "sa", "1");
			// 3. statement
			String sql = command;//"select * from vw_items";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {

				BookViewModel book = new BookViewModel();
				book.setId(rs.getInt("id"));
				book.setAuthor(rs.getNString("Author"));
				book.setCatName(rs.getNString("CatName"));
				book.setDiscount(rs.getFloat("Discount"));
				book.setImage(rs.getNString("Image"));
				book.setName(rs.getNString("Name"));
				book.setPrice(rs.getFloat("Price"));
				model.add(book);
			}
			rs.close();
			con.close();

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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

	public Vector<BookViewModel> selectView() {
		return query("select * from vw_items");
	}

	public Vector<BookViewModel> searchViewByName(String name) {
		return query("select * from vw_items where Name like '%" + name + "%'");
	}

}
