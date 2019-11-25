package beans;

import java.io.Serializable;
import java.sql.*;

public class ContactBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2614299957006916385L;
	
	private String title, email, phone, content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ContactBean() {
		
	}

	// save to db
	String dbuser="sa";
	String dbpassword="1";
	String url="jdbc:sqlserver://localhost;databaseName=GlobalToyz";
	public boolean createContact() {
		
		try {
		//1. load driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//2. connection 
		
		Connection con =DriverManager.getConnection(url,dbuser, dbpassword);
		
		//3.  statement
		Statement st = con.createStatement();
		//4. sql
				
		String sql="INSERT into ContactUs VALUES ('"+title+"','"+email+"','"+phone+"','"+content+"')";
	
		System.out.println(sql);
		
		//5 execute
		
		int result=  st.executeUpdate(sql);
		if(result> 0)
			System.out.println("add success!!!");
		else{
			System.out.println("add fail!!!");
		}
		
		//close connection
		con.close();
		
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}
		return true;
	}

}
