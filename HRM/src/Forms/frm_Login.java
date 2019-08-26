package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Button;

public class frm_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_Login frame = new frm_Login();
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
	public frm_Login() {
		setTitle("HRM - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourLogin = new JLabel("ENTER YOUR LOGIN INFORMATION");
		lblEnterYourLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterYourLogin.setBounds(10, 29, 328, 30);
		contentPane.add(lblEnterYourLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 93, 67, 14);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(87, 90, 251, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(87, 124, 251, 20);
		contentPane.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 127, 67, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(87, 158, 91, 23);
		contentPane.add(btnLogin);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(188, 158, 91, 23);
		contentPane.add(btnQuit);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(10, 70, 328, 14);
		contentPane.add(lblMessage);
	}
}
