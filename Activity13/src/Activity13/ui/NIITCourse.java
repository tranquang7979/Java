package Activity13.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Activity13.FileWriterDemo;

public class NIITCourse extends JFrame {

	private JPanel contentPane;
	private JTextField txtCourseName;
	private JTextField txtDuration;
	private JTextField txtTeacher;
	private JTextField txtPrice;
	private JTextField txtRating;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NIITCourse frame = new NIITCourse();
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
	public NIITCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddNewCourse = new JLabel("ADD NEW COURSE");
		lblAddNewCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewCourse.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddNewCourse.setBounds(10, 11, 327, 45);
		contentPane.add(lblAddNewCourse);

		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(10, 76, 80, 14);
		contentPane.add(lblCourseName);

		txtCourseName = new JTextField();
		txtCourseName.setBounds(89, 73, 236, 20);
		contentPane.add(txtCourseName);
		txtCourseName.setColumns(10);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(10, 104, 80, 14);
		contentPane.add(lblDuration);

		txtDuration = new JTextField();
		txtDuration.setColumns(10);
		txtDuration.setBounds(89, 101, 236, 20);
		contentPane.add(txtDuration);

		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(10, 132, 80, 14);
		contentPane.add(lblTeacher);

		txtTeacher = new JTextField();
		txtTeacher.setColumns(10);
		txtTeacher.setBounds(89, 129, 236, 20);
		contentPane.add(txtTeacher);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 160, 80, 14);
		contentPane.add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(89, 157, 236, 20);
		contentPane.add(txtPrice);

		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(10, 188, 80, 14);
		contentPane.add(lblRating);

		txtRating = new JTextField();
		txtRating.setColumns(10);
		txtRating.setBounds(89, 185, 236, 20);
		contentPane.add(txtRating);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(84, 213, 91, 23);
		contentPane.add(btnSave);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createCourse();
			}
		});
	}

	private void createCourse() {
		String filePath = "niit-courses.txt";
		String separate = "#!";
		String content = txtCourseName.getText() + separate + txtDuration.getText() + separate
				+ txtTeacher.getText() + separate + txtPrice.getText() + separate + txtRating.getText();

		FileWriterDemo fwd = new FileWriterDemo();
		fwd.WriteLine(filePath, content);

		JOptionPane.showMessageDialog(null, "New course is added successfull!");
		
		readCourse();
	}

	private void readCourse() {
		String filePath = "niit-courses.txt";
		String separate = "#!";
		
		FileWriterDemo fwd = new FileWriterDemo();

		String content = fwd.ReadLine(filePath); 

		System.out.print(content);
	}
		
}
