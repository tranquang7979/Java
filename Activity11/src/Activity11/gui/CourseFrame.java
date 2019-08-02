package Activity11.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class CourseFrame extends JFrame {

	String[] lst_courses = {"JAVA", "C#", "HTML", "JAVASCRIPT", "PYTHON" };
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseFrame frame = new CourseFrame();
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
	public CourseFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(16, 74, 46, 14);
		contentPane.add(lblCourse);
		
		JComboBox cbx_courses = new JComboBox();
		cbx_courses.setModel(new DefaultComboBoxModel(lst_courses));
		cbx_courses.setBounds(66, 70, 286, 22);
		contentPane.add(cbx_courses);
		
		JCheckBox chk_246 = new JCheckBox("2-4-6");
		chk_246.setBounds(26, 114, 58, 23);
		contentPane.add(chk_246);
		
		JCheckBox chk_357 = new JCheckBox("3-5-7");
		chk_357.setBounds(135, 114, 97, 23);
		contentPane.add(chk_357);
		
		JCheckBox chk_78 = new JCheckBox("7-CN");
		chk_78.setBounds(242, 114, 97, 23);
		contentPane.add(chk_78);
		
		JLabel lblNiitCourses = new JLabel("NIIT COURSES");
		lblNiitCourses.setForeground(Color.BLUE);
		lblNiitCourses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNiitCourses.setBounds(118, 13, 191, 46);
		contentPane.add(lblNiitCourses);
		
		JTextArea txt_Note = new JTextArea();
		txt_Note.setBounds(16, 318, 336, 67);
		contentPane.add(txt_Note);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setBounds(16, 300, 46, 14);
		contentPane.add(lblNote);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(160, 410, 91, 35);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = "Course: " + cbx_courses.getSelectedIndex() + " - " + cbx_courses.getSelectedItem();
				String selectedDay = "Days: ";
				if(chk_246.isSelected())
					selectedDay += "2-4-6";
				if(chk_357.isSelected())
					selectedDay += (chk_246.isSelected() ? "-" : "") + "3-5-7";
				if(chk_78.isSelected())
					selectedDay += (chk_357.isSelected() || chk_246.isSelected() ? "-" : "") +"7-CN";
				String note = txt_Note.getText();
				
				String result = selectedItem + "\n" + selectedDay + "\n" + note; 
				JOptionPane.showMessageDialog(null,  result);			
				
			}
		});
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(261, 410, 91, 35);
		contentPane.add(btnCancel);
		
		JList listQuarter1 = new JList();
		listQuarter1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Quarter I", "Quarter II", "Quarter III", "Quarter IV", "Quarter V", "Quarter VI"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listQuarter1.setBounds(16, 160, 126, 129);		
		contentPane.add(listQuarter1);
		
		JList listQuarter2 = new JList();
		listQuarter2.setBounds(225, 160, 127, 129);
		contentPane.add(listQuarter2);
		
		JLabel lblQuarter = new JLabel("Quarter");
		lblQuarter.setBounds(16, 144, 46, 14);
		contentPane.add(lblQuarter);
		
		JLabel label = new JLabel("Quarter");
		label.setBounds(215, 144, 46, 14);
		contentPane.add(label);
		
		JButton btnAdd = new JButton(">");
		btnAdd.setBounds(155, 166, 56, 23);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DefaultListModel<String> modelQuater1 = (DefaultListModel<String>)listQuarter1.getModel();
				DefaultListModel<String> modelQuater2 = (DefaultListModel<String>)listQuarter2.getModel();
				
				if(modelQuater2 == null)
				{
					modelQuater2 = new DefaultListModel();
					listQuarter2.setModel(modelQuater2);
				}
				System.out.println(listQuarter1.getSelectedValue());
				//modelQuater2.addElement((String) listQuarter1.getSelectedValue());
			}
		});
		contentPane.add(btnAdd);
		
		JButton btnAddAll = new JButton(">>");
		btnAddAll.setBounds(155, 200, 56, 23);
		contentPane.add(btnAddAll);
		
		JButton btnBack = new JButton("<");
		btnBack.setBounds(156, 231, 55, 23);
		contentPane.add(btnBack);
		
		JButton btnBackAll = new JButton("<<");
		btnBackAll.setBounds(155, 265, 56, 23);
		contentPane.add(btnBackAll);
	}
}
