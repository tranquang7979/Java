package Acitivity15.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CategoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryFrame frame = new CategoryFrame();
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
	public CategoryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CategoryFrame.class.getResource("/resources/download.jpg")));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(10, 14, 227, 194);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 219, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Browse");
		btnNewButton.setBounds(146, 219, 91, 23);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();

				int result = chooser.showOpenDialog(null);

				// chooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					textField.setText(chooser.getSelectedFile().getName());
					String path = CategoryFrame.class.getResource("/resources/").getPath();
					Path source = Paths.get(chooser.getSelectedFile().getAbsolutePath());
					File destination = new File(path + textField.getText());
					try {
						FileOutputStream os = new FileOutputStream(destination);
						Files.copy(source, os);
						os.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblNewLabel.setIcon(new ImageIcon(destination.getAbsolutePath()));

				}
			}
		});
	}
};