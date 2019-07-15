package Activity06.TrucXanhUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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
	private TrucXanhLib lib;
	
	private JLabel lblResult;		
	private JButton btnIntro;
	private JButton btnPlay;
	private JButton btnHelp;
	private JButton btnExit;
	
	
	
	public TrucXanhUI() {
		super();
		
		setLayout(new GridLayout(4,4));
    		
		lib = new TrucXanhLib();
		
		// init components
		lblResult = new JLabel("HELLO", SwingConstants.CENTER);		
		btnIntro  = new JButton("Introduction");
		btnPlay  = new JButton("Play");
		btnHelp  = new JButton("Help");
		btnExit  = new JButton("Exit");

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
        btnPlay.addActionListener(e -> btnPlay_Click(e));
        btnHelp.addActionListener(e -> System.exit(0));
		btnExit.addActionListener(e -> System.exit(0));
		
		//Adding Components to the frame.
		//this.getContentPane().add(BorderLayout.CENTER, lblResult);
		//this.getContentPane().add(BorderLayout.SOUTH, panel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TrucXanhUI frame = new TrucXanhUI();
			frame.setVisible(true);
		});
	}
	
	private void btnPlay_Click(ActionEvent e) {
		String word = lib.Play();
		lblResult.setText("");
		String temp = "";
		for(int i = 0; i < word.length(); i++) {
			temp += "_ ";
		}	
		lblResult.setText(temp);
	}
}
