package SQLServerApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class SQLServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SQLServerFrame frame = new SQLServerFrame();
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
	public SQLServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SQLServerFrame.class.getResource("/images/sql-logo.png")));
		lblNewLabel.setBounds(0, 0, 411, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblServerType = new JLabel("Server type:");
		lblServerType.setBounds(10, 79, 112, 14);
		contentPane.add(lblServerType);
		
		JComboBox cbx_ServerType = new JComboBox();
		cbx_ServerType.setModel(new DefaultComboBoxModel(new String[] {"Database Engine", "Analysis Services", "Reporting Services", "Integration Services"}));
		cbx_ServerType.setBounds(147, 75, 254, 22);
		contentPane.add(cbx_ServerType);
		
		JLabel lblServerName = new JLabel("Server name:");
		lblServerName.setBounds(12, 105, 112, 14);
		contentPane.add(lblServerName);
		
		JComboBox cbx_ServerName = new JComboBox();
		cbx_ServerName.setEditable(true);
		cbx_ServerName.setModel(new DefaultComboBoxModel(new String[] {"PC02", "PC02/SQLEXPRESS", "<Browse for more...>"}));
		cbx_ServerName.setBounds(149, 101, 252, 22);
		contentPane.add(cbx_ServerName);
		
		JLabel lblAuthentication = new JLabel("Authentication:");
		lblAuthentication.setBounds(10, 131, 112, 14);
		contentPane.add(lblAuthentication);
		
		JComboBox cbx_Authentication = new JComboBox();
		cbx_Authentication.setModel(new DefaultComboBoxModel(new String[] {"Window Authentication", "SQL Server Authentication"}));
		cbx_Authentication.setBounds(147, 127, 254, 22);
		contentPane.add(cbx_Authentication);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(12, 159, 71, 14);
		contentPane.add(lblLogin);
		
		JComboBox cbx_Login = new JComboBox();
		cbx_Login.setEditable(true);
		cbx_Login.setModel(new DefaultComboBoxModel(new String[] {"sa"}));
		cbx_Login.setBounds(159, 155, 242, 22);
		contentPane.add(cbx_Login);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(12, 183, 71, 14);
		contentPane.add(lblPassword);
		
		txt_Password = new JTextField();
		txt_Password.setBounds(159, 183, 242, 20);
		contentPane.add(txt_Password);
		txt_Password.setColumns(10);
		
		JCheckBox rdo_Remember = new JCheckBox("Remember password");
		rdo_Remember.setBounds(154, 203, 185, 23);
		contentPane.add(rdo_Remember);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 236, 391, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Options >>");
		btnNewButton.setBounds(304, 250, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(219, 250, 81, 23);
		contentPane.add(btnHelp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(133, 250, 81, 23);
		contentPane.add(btnCancel);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(47, 249, 81, 23);
		contentPane.add(btnConnect);
	}
}
