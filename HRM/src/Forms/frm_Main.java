package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class frm_Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_Main frame = new frm_Main();
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
	public frm_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Employee");
		JMenuItem item = new JMenuItem("Add new");
		menu.add(item);
		item = new JMenuItem("List employee");
		menu.add(item);
		menuBar.add(menu);

		menu = new JMenu("Contract & Insurance");
		item = new JMenuItem("Labor Contract");
		menu.add(item);
		item = new JMenuItem("Social Insurance");
		menu.add(item);		
		menuBar.add(menu);

		menu = new JMenu("Reports");
		item = new JMenuItem("Salary History");
		menu.add(item);
		item = new JMenuItem("Time keeping");
		menu.add(item);
		item = new JMenuItem("Reward");
		menu.add(item);
		item = new JMenuItem("Discipline");
		menu.add(item);
		item = new JMenuItem("User login");
		menu.add(item);
		menuBar.add(menu);

		menu = new JMenu("Settings");
		item = new JMenuItem("Allowance");
		menu.add(item);
		item = new JMenuItem("Benefit");
		menu.add(item);
		item = new JMenuItem("Checkin-out time");
		menu.add(item);
		item = new JMenuItem("Imprest");
		menu.add(item);
		menuBar.add(menu);

		menu = new JMenu("My account");
		item = new JMenuItem("Profile");
		menu.add(item);
		item = new JMenuItem("Change password");
		menu.add(item);
		item = new JMenuItem("Logout");
		menu.add(item);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
