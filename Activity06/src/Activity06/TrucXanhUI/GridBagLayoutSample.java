package Activity06.TrucXanhUI;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutSample {
	final boolean shouldFill = true;
	final boolean shouldWeightX = true;
	final boolean RIGHT_TO_LEFT = false;
	private JLabel lblResult;
	private JLabel lblMessage;
	private JTextField txtInput;
	private JButton btnIntro;
	private JButton btnPlay;
	private JButton btnHelp;
	private JButton btnExit;
	private JButton btnConfirm;

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

		lblResult = new JLabel("HELLO", SwingConstants.CENTER);	
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 10, 0); // top padding
		pane.add(lblResult, c);

		txtInput = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 10); // left right padding
		pane.add(txtInput, c);

		btnConfirm  = new JButton("Confirm");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 10); // left right padding
		pane.add(btnConfirm, c);

		lblMessage = new JLabel("", SwingConstants.CENTER);	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 10); // left right padding
		pane.add(lblMessage, c);

		btnIntro  = new JButton("Introduction");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 10); // left right padding
		pane.add(btnIntro, c);

		btnPlay  = new JButton("Play");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 10); // left right padding
		pane.add(btnPlay, c);

		btnHelp  = new JButton("Help");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 10); // left right padding
		pane.add(btnHelp, c);

		btnExit  = new JButton("Exit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 10); // left right padding
		pane.add(btnExit, c);
		
		

		//c.ipady = 40; // make this component tall
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 0; // reset to default
		//c.weighty = 1.0; // request any extra vertical space
		//c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		//c.insets = new Insets(10, 0, 0, 0); // top padding
		//c.gridx = 1; // aligned with button 2
		//c.gridwidth = 2; // 2 columns wide
		//c.gridy = 2; // third row
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
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GridBagLayoutSample gb = new GridBagLayoutSample();
				gb.createAndShowGUI();
			}
		});
	}
}
