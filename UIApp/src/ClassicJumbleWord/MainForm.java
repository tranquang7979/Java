package ClassicJumbleWord;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MainForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassicJumbleWord = new JLabel("CLASSIC JUMBLE WORD");
		lblClassicJumbleWord.setForeground(Color.GRAY);
		lblClassicJumbleWord.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblClassicJumbleWord.setBounds(20, 11, 320, 47);
		contentPane.add(lblClassicJumbleWord);
		
		JButton btnPlayGame = new JButton("");
		btnPlayGame.setIcon(new ImageIcon("E:\\TranDuyQuang\\eclipse-workspace\\UIApp\\imgs\\icons8-play-80.png"));
		btnPlayGame.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPlayGame.setBounds(20, 69, 89, 73);
		contentPane.add(btnPlayGame);
		
		JButton btnViewInstructions = new JButton("");
		btnViewInstructions.setIcon(new ImageIcon("E:\\TranDuyQuang\\eclipse-workspace\\UIApp\\imgs\\icons8-help-801.png"));
		btnViewInstructions.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnViewInstructions.setBounds(132, 69, 80, 73);
		contentPane.add(btnViewInstructions);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon("E:\\TranDuyQuang\\eclipse-workspace\\UIApp\\imgs\\icons8-exit-64.png"));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(232, 69, 89, 80);
		contentPane.add(btnExit);
	}

}
