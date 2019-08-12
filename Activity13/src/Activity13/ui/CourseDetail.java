package Activity13.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Activity13.FileReaderDemo;
import Models.CourseModel;

public class CourseDetail extends JFrame {

	private JPanel contentPane;
	private JLabel lblDuration;
	private JLabel lblTeacher;
	private JLabel lblPrice;
	private JLabel lblRating;

	JComboBox<CourseModel> cboCourse = null;
	DefaultListModel<CourseModel> modelCourse;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseDetail frame = new CourseDetail();
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
	public CourseDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseDetail = new JLabel("COURSE DETAIL");
		lblCourseDetail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCourseDetail.setBounds(56, 11, 186, 37);
		contentPane.add(lblCourseDetail);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(10, 72, 46, 14);
		contentPane.add(lblCourse);

		modelCourse = new DefaultListModel<CourseModel>();
		CourseModel[] courses = new FileReaderDemo().GetAllCourse();
		for(int i = 0; i < courses.length; i++) {			
			modelCourse.addElement(courses[i]);
		}
		cboCourse = new JComboBox<CourseModel>(courses);		
		cboCourse.setBounds(66, 68, 153, 22);
		contentPane.add(cboCourse);
		cboCourse.addActionListener(e -> {
			JComboBox<CourseModel> cbo = (JComboBox<CourseModel>)e.getSource();
			CourseModel item = (CourseModel) cbo.getSelectedItem();
			bindingData(item);
		});
		
		JLabel lblNewLabel = new JLabel("Duration");
		lblNewLabel.setBounds(10, 113, 57, 14);
		contentPane.add(lblNewLabel);
		
		lblDuration = new JLabel("-");
		lblDuration.setBounds(73, 113, 146, 14);
		contentPane.add(lblDuration);
		
		lblTeacher = new JLabel("-");
		lblTeacher.setBounds(73, 138, 146, 14);
		contentPane.add(lblTeacher);
		
		JLabel lbl2 = new JLabel("Teacher");
		lbl2.setBounds(10, 138, 57, 14);
		contentPane.add(lbl2);
		
		lblPrice = new JLabel("-");
		lblPrice.setBounds(73, 163, 146, 14);
		contentPane.add(lblPrice);
		
		JLabel lbl3 = new JLabel("Price");
		lbl3.setBounds(10, 163, 57, 14);
		contentPane.add(lbl3);
		
		lblRating = new JLabel("-");
		lblRating.setBounds(73, 188, 146, 14);
		contentPane.add(lblRating);
		
		JLabel lbl5 = new JLabel("Rating");
		lbl5.setBounds(10, 188, 57, 14);
		contentPane.add(lbl5);
		
		bindingData(courses[0]);
	}

	private void bindingData(CourseModel item) 
	{
		if(item == null) return;
		lblDuration.setText(item.Duration);
		lblTeacher.setText(item.Teacher);
		lblPrice.setText(item.Price.toString());
		lblRating.setText(item.Rate.toString());
	}

}
