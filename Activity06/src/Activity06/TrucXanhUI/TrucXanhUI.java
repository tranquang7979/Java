package Activity06.TrucXanhUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class TrucXanhUI {
	final boolean shouldFill = true;
	final boolean shouldWeightX = true;
	final boolean RIGHT_TO_LEFT = false;
	private static JLabel lblResult;
	private static JLabel lblContent;
	private static JTextField txtInput;
	private JButton btnIntro;
	private JButton btnPlay;
	private JButton btnHelp;
	private JButton btnExit;
	private JButton btnConfirm;
	private String[] arrResult = { "TEA", "GOOD", "HELLO", "RACE", "BOOK", "CANDY" };
	private String result = "";
	private static TrucXanhUI tx;
	private static int countResult;

	public void addComponentsToPane(Container pane) {
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			// natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		lblResult = new JLabel("WELCOME TO HANGINMAN!", SwingConstants.CENTER);
		lblResult.setFont(new Font("Courier New", Font.BOLD, 39));
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 5, 0); // top padding
		pane.add(lblResult, c);

		txtInput = new JTextField();
		txtInput.setFont(new Font("Courier New", Font.BOLD, 50));
		txtInput.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 30; // make this component tall
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 0, 0, 5); // left right padding
		pane.add(txtInput, c);

		btnConfirm = new JButton("Confirm");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(5, 0, 0, 5); // left right padding
		pane.add(btnConfirm, c);

		btnIntro = new JButton("Introduction");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5, 0, 0, 5); // left right padding
		pane.add(btnIntro, c);

		btnPlay = new JButton("Play");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(5, 0, 0, 5); // left right padding
		pane.add(btnPlay, c);

		btnHelp = new JButton("Help");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		c.insets = new Insets(5, 0, 0, 5); // left right padding
		pane.add(btnHelp, c);

		btnExit = new JButton("Exit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 2;
		c.insets = new Insets(5, 0, 0, 5); // left right padding
		pane.add(btnExit, c);

		lblContent = new JLabel("", SwingConstants.RIGHT);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5, 0, 0, 5); // left right padding
		pane.add(lblContent, c);

		btnIntro.addActionListener(e -> System.exit(0));
		btnPlay.addActionListener(e -> tx.Play());
		btnHelp.addActionListener(e -> System.exit(0));
		btnExit.addActionListener(e -> System.exit(0));
		btnConfirm.addActionListener(e -> tx.Confirm());

		KeyListener keyListener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {				
				if(txtInput.getText().length() > 1)
					txtInput.setText(txtInput.getText().substring(0,  1));
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		};
		txtInput.addKeyListener(keyListener);

		// c.ipady = 40; // make this component tall
		// c.fill = GridBagConstraints.HORIZONTAL;
		// c.ipady = 0; // reset to default
		// c.weighty = 1.0; // request any extra vertical space
		// c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10, 0, 0, 0); // top padding
		// c.gridx = 1; // aligned with button 2
		// c.gridwidth = 2; // 2 columns wide
		// c.gridy = 2; // third row
	}

	private static void messageBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	private void Play() {
		countResult = 0;

		// random a word in arrResult
		Random r = new Random();
		int randomNumber = r.nextInt(arrResult.length);
		result = arrResult[randomNumber];
		String text = "";
		for (int i = 0; i < result.length(); i++) {
			text += "_ ";
		}
		lblResult.setText(text);
	}

	private void Confirm() {
		Character input = txtInput.getText().charAt(0);
		StringBuilder output = new StringBuilder(lblResult.getText());

		for (int i = 0; i < output.length(); i++) {
			if (input == output.charAt(i)) {
				messageBox(input + " was found already. Please choose another character.", "Warning Message");
				return;
			}
		}

		int count = 0;
		for (int j = 0; j < result.length(); j++) {
			if (input == result.charAt(j)) {
				output.setCharAt(j * 2, input);
				count++;
				countResult++;
			}
		}
		if (count > 0)
			messageBox("There " + (count > 1 ? "are " : "is ") + input + ".", "Congratulation!");
		else
			messageBox("There is no any " + input + ".", "Sorry!");
		lblResult.setText(output.toString());

		if (countResult == result.length())
			messageBox("YOU WON!!!", "Congratulation!");

		txtInput.setText("");
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	private void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("GridBagLayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tx = new TrucXanhUI();
				tx.createAndShowGUI();
			}
		});
	}
}
