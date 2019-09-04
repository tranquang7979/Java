package Activity17;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CategoryManagement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryManagement frame = new CategoryManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CategoryManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categories");
		lblNewLabel.setBounds(10, 21, 174, 14);
		contentPane.add(lblNewLabel);
		
		//get data from db
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
			int count=0;
			while(rs.next()){
				
				String categoryName = rs.getNString("Name");
				JButton btnNewButton = new JButton(categoryName);
				btnNewButton.setBounds(10, 57 + (23+10)*count, 235, 23);
				count++;
				
				contentPane.add(btnNewButton);
			}
			//refresh 
			contentPane.updateUI();
			
			rs.close();
			con.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}