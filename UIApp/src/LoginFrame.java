import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		setBounds(100, 100, 450, 233);
		contentPane = new JPanel();
		contentPane.setToolTipText("Please key in password");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(66, 83, 61, 14);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setToolTipText("Please key in username");
		textField.setBounds(135, 80, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(66, 108, 61, 14);
		contentPane.add(lblPassword);
		
		JLabel lblLoginForm = new JLabel("LOGIN FORM");
		lblLoginForm.setBackground(SystemColor.desktop);
		lblLoginForm.setBounds(159, 25, 131, 28);
		lblLoginForm.setForeground(SystemColor.desktop);
		lblLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblLoginForm);
		
		JButton btnLogin = new JButton("Cancel");
		btnLogin.setBounds(244, 136, 91, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignin = new JButton("Signin");
		btnSignin.setBounds(135, 136, 91, 23);
		contentPane.add(btnSignin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 108, 200, 20);
		contentPane.add(passwordField);
	}
}
