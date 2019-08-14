package Activity14;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Activity14.Login.ValidateStaticInnerClass;
import Activity14.Model.Account;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(10, 11, 312, 45);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 59, 75, 14);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(93, 56, 229, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 87, 75, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(93, 115, 91, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(e -> {
			if(validateAccount()) {
				JOptionPane.showMessageDialog(null, "Login successfull!");
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(194, 115, 91, 23);
		contentPane.add(btnCancel);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(93, 87, 229, 20);
		contentPane.add(txtPassword);
	}
	
	private Boolean validateAccount() 
	{
		Account acc = new Account();
		acc.setUsername(txtUsername.getText());
		acc.setPassword(txtPassword.getText());
		
		Login lg = new Login();		
		lg.setUsername(acc.getUsername());
		lg.setPassword(acc.getPassword());
		Login.ValidateInnerClass vic = lg.new ValidateInnerClass();
				
		lg.setUsername(acc.Username);
		if(!vic.checkUsername())
		{
			JOptionPane.showMessageDialog(null, "Length of Username should be greater than 3!");
			return false;
		}
		
		if(!vic.checkPassword())
		{
			JOptionPane.showMessageDialog(null, "Length of Password should be greater than 6!");
			return false;
		}
		
		Boolean exist = new ValidateStaticInnerClass().checkExistUser(txtUsername.getText());
		return exist;
	}
}
