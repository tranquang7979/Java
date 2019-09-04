package Activity16;

import java.sql.*;


public class Demo1 {

	public void insert(){
		Connection con=null;
		Statement st=null;
		
		try{
			
			//1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2. get connection
			con=DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB","sa","1");
			//3. statement
			String sql="insert [dbo].[Category] ([Name],[description]) values (N'Văn phòng phẩm',N'no desc..')";
			st = con.createStatement();
			int res=st.executeUpdate(sql);
			if(res>0)
			{
				System.out.println("insert success");
			}else
			{
				System.out.println("insert fail");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void update(){
		Connection con=null;
		Statement st=null;
		
		try{
			
			//1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2. get connection
			con=DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB","sa","1");
			//3. statement
			String sql="update Category set Name='English', [description] = 'no desc' where id = 1";
			st = con.createStatement();
			int res=st.executeUpdate(sql);
			if(res>0)
			{
				System.out.println("update success");
			}else
			{
				System.out.println("update fail");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void delete(){
		Connection con=null;
		Statement st=null;
		try{
			
			//1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2. get connection
			con=DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB","sa","1");
			//3. statement
			String sql="delete Category where id=1";
			st = con.createStatement();
			int res=st.executeUpdate(sql);
			if(res>0)
			{
				System.out.println("delete success");
			}else
			{
				System.out.println("delete fail");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
	
	public void select(){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			
			//1. load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2. get connection
			con=DriverManager.getConnection("jdbc:sqlserver://PC20;databaseName=Activity17DB","sa","1");
			//3. statement
			String sql="select * from category";
			st=con.createStatement();
			rs = st.executeQuery(sql);
			
			System.out.println("======List categories======");
			while(rs.next()){
				int id=  rs.getInt("id");
				String Name = rs.getNString("Name");
				String desc = rs.getNString("description");
				
				System.out.println(id + " | " + Name + " | " + desc);
			}
			rs.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) {
			
		Demo1 d=new Demo1();
		d.select();

	}

}
