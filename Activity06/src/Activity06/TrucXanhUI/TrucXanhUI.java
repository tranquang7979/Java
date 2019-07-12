package Activity06.TrucXanhUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TrucXanhUI extends JFrame {

	// declare variables
	private String result;
	private char[] inputResult;
	private int count;
	private String[] arrResult = { "TEA", "GOOD", "HELLO", "RACE", "BOOK", "CANDY" };

	
	public TrucXanhUI() {
		super();
		
		// init components
		JLabel lblResult = new JLabel("HELLO", SwingConstants.CENTER);		
		JButton btnIntro  = new JButton("Introduction");
		JButton btnPlay  = new JButton("Play");
		JButton btnHelp  = new JButton("Help");
		JButton btnExit  = new JButton("Exit");

		//Creating the panel (still not visible in output)
        JPanel panel = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(300, 200);		
		// Center it on the screen
		this.setLocationRelativeTo(null);
				
		lblResult.setFont(new Font(lblResult.getName(), Font.PLAIN, 50));
				
        panel.add(btnIntro);
        panel.add(btnPlay);
        panel.add(btnHelp);
        panel.add(btnExit);

        btnIntro.addActionListener(e -> System.exit(0));
        btnPlay.addActionListener(e -> System.exit(0));
        btnHelp.addActionListener(e -> System.exit(0));
		btnExit.addActionListener(e -> System.exit(0));
		
		//Adding Components to the frame.
		this.getContentPane().add(BorderLayout.CENTER, lblResult);
		this.getContentPane().add(BorderLayout.SOUTH, panel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TrucXanhUI frame = new TrucXanhUI();
			frame.setVisible(true);
		});
	}
}
